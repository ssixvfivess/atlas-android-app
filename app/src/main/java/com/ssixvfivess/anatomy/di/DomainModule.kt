package com.ssixvfivess.anatomy.di

import com.ssixvfivess.anatomy.domain.GetMuscleUseCase
import com.ssixvfivess.anatomy.domain.GetMuscleUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    @Reusable
    fun bindGetMusclesListUseCase(impl: GetMuscleUseCaseImpl): GetMuscleUseCase
}