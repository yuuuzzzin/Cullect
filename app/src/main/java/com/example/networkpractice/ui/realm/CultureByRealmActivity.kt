package com.example.networkpractice.ui.realm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.networkpractice.R
import com.example.networkpractice.base.BaseBindingActivity
import com.example.networkpractice.databinding.ActivityCultureByRealmBinding
import com.example.networkpractice.databinding.ActivityDetailBinding
import com.example.networkpractice.network.model.CultureModel
import com.example.networkpractice.ui.detail.DetailActivity
import com.example.networkpractice.ui.home.CultureListAdapter
import com.example.networkpractice.ui.home.HomeFragment
import com.example.networkpractice.util.RecyclerViewUtil
import com.example.networkpractice.viewmodel.DetailViewModel
import com.example.networkpractice.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class CultureByRealmActivity :
    BaseBindingActivity<ActivityCultureByRealmBinding>(R.layout.activity_culture_by_realm) {
    private val viewModel: MainViewModel by viewModels()
    private val cultureListAdapter: CultureListAdapter = CultureListAdapter()
    private lateinit var realm: String
    private lateinit var title: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        processIntent()
        initView()
        observeViewModel()
    }

    private fun processIntent() {
        realm = intent.getStringExtra(REALM_CODE).toString()
        title = intent.getStringExtra(REALM_TITLE).toString()
    }

    private fun initView() {

        binding.tvTitle.text = title

        binding.rvCulture.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = cultureListAdapter
            addItemDecoration(RecyclerViewUtil.GridSpaceItemDecoration(2, 16, false))
            hasFixedSize()
        }

        cultureListAdapter.addLoadStateListener { loadState ->
            cultureListAdapter?.apply {
                if (itemCount <= 0 && !loadState.source.refresh.endOfPaginationReached) {
                    Timber.d("==> to show empty view")
                    binding.tvEmpty.isVisible = cultureListAdapter.itemCount == 0
                } else {
                    Timber.d("==> to hide empty view")
                    binding.tvEmpty.isVisible = false
                }
            }
        }

        cultureListAdapter.setItemClickListener(object :
            CultureListAdapter.OnItemClickListener {
            override fun onItemClicked(item: CultureModel?) {
                item!!.seq.let { seq ->
                    val intent = Intent(this@CultureByRealmActivity, DetailActivity::class.java)
                    intent.putExtra(CULTURE_SEQ, seq)
                    startActivity(intent)
                }
            }
        })

        binding.swipeRefreshLayout.setOnRefreshListener {
            lifecycleScope.launchWhenStarted {
                viewModel.fetchCultureListByRealm(realm).collect {
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
            viewModel.fetchCultureListByRealm(realm).collect {
                cultureListAdapter.submitData(it)
            }
        }
    }

    companion object {
        const val REALM_CODE = "realm.code"
        const val REALM_TITLE = "realm.title"
        const val CULTURE_SEQ = "culture.seq"
    }
}