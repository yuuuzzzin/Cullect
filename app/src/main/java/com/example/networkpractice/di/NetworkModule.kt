package com.example.networkpractice.di

import com.example.networkpractice.BuildConfig
import com.example.networkpractice.network.api.CultureService
import com.example.networkpractice.util.decode
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/* 네트워크 통신을 위한 모듈 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val CULTURE_BASE_URL = BuildConfig.CULTURE_BASE_URL
    private const val API_KEY = BuildConfig.CULTURE_API_KEY

    private val apiKeyInterceptor = Interceptor {
        val request = it.request()
        val url = request.url.newBuilder().addQueryParameter("serviceKey",
            decode(API_KEY)
        ).build()
        return@Interceptor it.proceed(request.newBuilder().url(url).build())
    }

    @Singleton
    @Provides
    fun provideCultureService(retrofit: Retrofit): CultureService =
        retrofit.create(CultureService::class.java)

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(1, TimeUnit.MINUTES) // 연결 타임아웃
            .readTimeout(30, TimeUnit.SECONDS) // 읽기 타임아웃
            .writeTimeout(30, TimeUnit.SECONDS) // 쓰기 타임아웃
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(CULTURE_BASE_URL)
            .addConverterFactory(
                TikXmlConverterFactory.create(
                    TikXml.Builder()
                        .exceptionOnUnreadXml(false)
                        .build()
                )
            )
            .client(okHttpClient)
            .build()
    }
}