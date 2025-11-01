package com.ssixvfivess.anatomy.di

import com.ssixvfivess.anatomy.base.CoroutineDispatchers
import com.ssixvfivess.anatomy.base.CoroutineDispatchersImpl
import com.ssixvfivess.anatomy.base.ResourceProvider
import com.ssixvfivess.anatomy.base.ResourceProviderImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    @Reusable
    fun bindResourceProvider(impl: ResourceProviderImpl): ResourceProvider

    @Binds
    @Reusable
    fun bindCoroutineDispatchers(impl: CoroutineDispatchersImpl): CoroutineDispatchers
}