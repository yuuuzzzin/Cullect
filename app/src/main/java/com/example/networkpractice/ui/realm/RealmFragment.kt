package com.example.networkpractice.ui.realm

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.networkpractice.R
import com.example.networkpractice.databinding.FragmentHomeBinding
import com.example.networkpractice.databinding.FragmentRealmBinding
import com.yuuuzzzin.recordnize.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RealmFragment : BaseFragment<FragmentRealmBinding>(FragmentRealmBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
    }

    private fun setListener() {
        binding.apply {
            layoutA.setOnClickListener {
                intentToRealmActivity("A000", "연극")
            }
            layoutB.setOnClickListener {
                intentToRealmActivity("B000", "음악")
            }
            layoutC.setOnClickListener {
                intentToRealmActivity("C000", "무용")
            }
            layoutD.setOnClickListener {
                intentToRealmActivity("D000", "미술")
            }
            layoutE.setOnClickListener {
                intentToRealmActivity("E000", "건축")
            }
            layoutG.setOnClickListener {
                intentToRealmActivity("G000", "영상")
            }
            layoutH.setOnClickListener {
                intentToRealmActivity("H000", "문학")
            }
            layoutI.setOnClickListener {
                intentToRealmActivity("I000","문화정책")
            }
            layoutJ.setOnClickListener {
                intentToRealmActivity("J000", "문화공간")
            }
            layoutL.setOnClickListener {
                intentToRealmActivity("L000", "기타")
            }
        }
    }

    private fun intentToRealmActivity(realm: String, title: String) {
        val intent = Intent(context, CultureByRealmActivity::class.java)
        intent.putExtra(REALM_CODE, realm)
        intent.putExtra(REALM_TITLE, title)
        startActivity(intent)
    }

    companion object {
        const val REALM_CODE = "realm.code"
        const val REALM_TITLE = "realm.title"
    }
}