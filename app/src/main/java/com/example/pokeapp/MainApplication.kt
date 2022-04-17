package com.example.pokeapp

import android.app.Application
import com.example.pokeapp.di.apiModule
import com.example.pokeapp.di.detailModule
import com.example.pokeapp.di.mainModule
import com.example.pokeapp.di.networkModule
import com.example.pokeapp.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(apiModule, networkModule, mainModule, detailModule, repositoryModule)
        }
    }
}