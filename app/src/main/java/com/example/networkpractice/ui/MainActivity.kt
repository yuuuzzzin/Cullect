package com.example.networkpractice.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.networkpractice.R
import com.example.networkpractice.base.BaseActivity
import com.example.networkpractice.databinding.ActivityMainBinding
import com.example.networkpractice.util.RecyclerViewUtil
import com.example.networkpractice.viewmodel.MainViewModel
import com.example.networkpractice.base.BaseBindingActivity
import com.example.networkpractice.ui.home.CultureListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>({ActivityMainBinding.inflate(it)}) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
    }

}