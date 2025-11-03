package com.ssixvfivess.anatomy.di

import android.content.Context
import androidx.room.Room
import com.ssixvfivess.anatomy.data.AnatomyDatabase
import com.ssixvfivess.anatomy.data.MuscleDao
import com.ssixvfivess.anatomy.data.MuscleRepositoryImpl
import com.ssixvfivess.anatomy.domain.MuscleRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Reusable
    abstract fun bindTripDataRepository(impl: MuscleRepositoryImpl): MuscleRepository

    @Module
    @InstallIn(SingletonComponent::class)
    class Providers {

        @Provides
        @Singleton
        fun provideAppDataBase(@ApplicationContext context: Context): AnatomyDatabase {
            return Room.databaseBuilder<AnatomyDatabase>(
                context,
                AnatomyDatabase::class.java,
                "anatomy_database.db"
            ).build()
        }

        @Provides
        @Singleton
        fun provideMuscleDao(database: AnatomyDatabase): MuscleDao {
            return database.muscleDao()
        }

    }
}