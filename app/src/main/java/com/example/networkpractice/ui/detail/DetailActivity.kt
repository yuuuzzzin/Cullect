package com.example.networkpractice.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.networkpractice.R
import com.example.networkpractice.base.BaseBindingActivity
import com.example.networkpractice.databinding.ActivityDetailBinding
import com.example.networkpractice.ui.home.HomeFragment.Companion.CULTURE_SEQ
import com.example.networkpractice.util.UiState
import com.example.networkpractice.viewmodel.DetailViewModel
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class DetailActivity : BaseBindingActivity<ActivityDetailBinding>(R.layout.activity_detail), OnMapReadyCallback {

    private val viewModel: DetailViewModel by viewModels()
    private lateinit var mapView: MapView
    private lateinit var naverMap: NaverMap
    private var gpsX: Double = 127.0
    private var gpsY: Double = 32.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapView = binding.mapView
        processIntent()
        observeViewModel(savedInstanceState)
    }

    private fun processIntent() {
        lifecycleScope.launchWhenStarted {
            intent?.getStringExtra(CULTURE_SEQ)?.let {
                viewModel.getCultureDetail(it)
            }
        }
    }

    private fun observeViewModel(savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is UiState.Success -> {
                        binding.item = state.data
                        binding.tvEmpty.visibility = View.GONE
                        binding.loading.visibility = View.GONE

                        if (!state.data.url.isNullOrEmpty()) {
                            binding.btTickting.visibility = View.VISIBLE
                            binding.btTickting.setOnClickListener {
                                val intent = Intent(
                                    Intent.ACTION_VIEW,
                                    Uri.parse(state.data.url)
                                )
                                startActivity(intent)
                            }
                        } else {
                            binding.btTickting.visibility = View.GONE
                        }

                        if(!state.data.gpsX.isNullOrEmpty() && !state.data.gpsY.isNullOrEmpty()) {
                            gpsX = state.data.gpsX.toDouble()
                            gpsY = state.data.gpsY.toDouble()
                            Timber.d("$gpsX/$gpsY")

                            setMapView(savedInstanceState)
                        }
                    }
                    is UiState.Loading -> {
                        binding.loading.visibility = View.VISIBLE
                    }
                    is UiState.Empty -> {
                        binding.loading.visibility = View.GONE
                        binding.tvEmpty.visibility = View.VISIBLE
                    }
                    is UiState.Error -> {
                        binding.loading.visibility = View.GONE
                        binding.tvEmpty.apply {
                            text = state.error.toString()
                            visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }

    private fun setMapView(savedInstanceState: Bundle?) {
        mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync(this@DetailActivity)
    }

    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        mapView.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onMapReady(map: NaverMap) {
        naverMap = map
        naverMap.maxZoom = 18.0
        naverMap.minZoom = 10.0

        val cameraUpdate = CameraUpdate.scrollTo(LatLng(gpsY, gpsX))
        naverMap.moveCamera(cameraUpdate)

        val marker = Marker()
        marker.position = LatLng(gpsY, gpsX)
        marker.map = naverMap
    }
}
