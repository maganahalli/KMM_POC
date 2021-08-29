package com.mobile.venky.kmm.ktor.poc.android.di

import com.mobile.venky.kmm.ktor.poc.Service
import com.mobile.venky.kmm.ktor.poc.WebServiceCallWithGet
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Venky Maganahalli updated on 08/29/2021
 */

@InstallIn(SingletonComponent::class)
@Module
class NetworkingModule {

    @Provides
    fun provideRestApiService(): Service {
        return WebServiceCallWithGet()
    }

}


