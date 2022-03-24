package com.example.networkpractice

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        // 다크모드 비활성화
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: BaseApplication

        fun appCtx(): Context {
            return instance.applicationContext
        }
    }
}