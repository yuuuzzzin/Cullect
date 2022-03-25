package com.example.networkpractice.di

import com.example.networkpractice.network.api.CultureService
import com.example.networkpractice.repository.CultureRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideCultureRepository(cultureService: CultureService): CultureRepository {
        return CultureRepository(cultureService)
    }
}