package com.example.networkpractice.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.networkpractice.R
import com.example.networkpractice.databinding.FragmentHomeBinding
import com.example.networkpractice.network.model.CultureModel
import com.example.networkpractice.ui.detail.DetailActivity
import com.example.networkpractice.util.RecyclerViewUtil
import com.example.networkpractice.viewmodel.MainViewModel
import com.yuuuzzzin.offoff_android.utils.base.BaseBindingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter
import timber.log.Timber
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

@AndroidEntryPoint
class HomeFragment : BaseBindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewModel: MainViewModel by viewModels()
    private val cultureListAdapter: CultureListAdapter = CultureListAdapter()
    lateinit var from: String
    lateinit var to: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calDate()
        initView()
        observeViewModel()
    }

    private fun calDate() {
        val date = Date()
        val dateFormat = SimpleDateFormat("yyyyMMdd", Locale("ko", "KR"))
        val calendar = Calendar.getInstance()
        calendar.time = date
        from = dateFormat.format(calendar.time)
        calendar.add(Calendar.YEAR, 1)
        to = dateFormat.format(calendar.time)
    }

    private fun initView() {

        binding.rvCulture.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = cultureListAdapter
            addItemDecoration(RecyclerViewUtil.GridSpaceItemDecoration(2, 16, false))
            hasFixedSize()
        }

        cultureListAdapter.addLoadStateListener {
            if (it.append.endOfPaginationReached) {
                binding.tvEmpty.isVisible = cultureListAdapter.itemCount == 0
            } else {
                binding.tvEmpty.isVisible = false
            }
        }

        cultureListAdapter.setItemClickListener(object :
            CultureListAdapter.OnItemClickListener {
            override fun onItemClicked(item: CultureModel?) {
                item!!.seq.let { seq ->
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra(CULTURE_SEQ, seq)
                    startActivity(intent)
                }
            }
        })

        binding.swipeRefreshLayout.setOnRefreshListener {
            lifecycleScope.launchWhenStarted {
                viewModel.fetchCultureListByPeriod(from, to).collect {
                    cultureListAdapter.submitData(it)
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            cultureListAdapter.loadStateFlow.distinctUntilChangedBy {
                it.refresh
            }
                .filter {
                    it.refresh is LoadState.NotLoading
                }
                .collect {
                    binding.swipeRefreshLayout.isRefreshing = false
                }
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launchWhenStarted {
            viewModel.fetchCultureListByPeriod(from, to).collect {
                cultureListAdapter.submitData(it)
            }
        }
    }

    companion object {
        const val CULTURE_SEQ = "culture.seq"
    }
}