package com.example.networkpractice.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.networkpractice.R
import com.example.networkpractice.databinding.ActivityMainBinding
import com.example.networkpractice.util.RecyclerViewUtil
import com.example.networkpractice.viewmodel.HomeViewModel
import com.example.networkpractice.base.BaseBindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter

@AndroidEntryPoint
class MainActivity : BaseBindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: HomeViewModel by viewModels()
    private val cultureListAdapter: CultureListAdapter = CultureListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()
        afterOnCreate()
    }

    private fun initView() {

        binding.rvCulture.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = cultureListAdapter
            addItemDecoration(RecyclerViewUtil.GridSpaceItemDecoration(2, 16, false))
            hasFixedSize()
        }

        cultureListAdapter.addLoadStateListener {
            if(it.append.endOfPaginationReached) {
                binding.viewEmpty.isVisible = cultureListAdapter.itemCount == 0
            } else {
                binding.viewEmpty.isVisible = false
            }
        }

        binding.swipeRefreshLayout.setOnRefreshListener { lifecycleScope.launchWhenStarted {
            viewModel.fetchCultureListByRealm().collect {
                cultureListAdapter.submitData(it)
            }
        }}

        lifecycleScope.launchWhenCreated {
            cultureListAdapter.loadStateFlow.distinctUntilChangedBy {
                it.refresh }
                .filter {
                    it.refresh is LoadState.NotLoading }
                .collect {
                    binding.swipeRefreshLayout.isRefreshing = false
                }
        }
    }

    private fun afterOnCreate() {
        lifecycleScope.launchWhenStarted {
            viewModel.fetchCultureListByRealm().collect {
                cultureListAdapter.submitData(it)
            }
        }
    }
}