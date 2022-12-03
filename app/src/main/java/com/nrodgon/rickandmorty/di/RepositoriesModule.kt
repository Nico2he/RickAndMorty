package com.nrodgon.rickandmorty.di

import com.nrodgon.rickandmorty.data.repositories.CharacterRepositoryImpl
import com.nrodgon.rickandmorty.domain.repositories.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindCharacterRepository(impl: CharacterRepositoryImpl): CharacterRepository
}