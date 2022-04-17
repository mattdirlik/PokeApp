package com.example.pokeapp.di

import com.example.pokeapp.data.PokeRepository
import com.example.pokeapp.data.PokeApi
import com.example.pokeapp.viewmodels.detail.DetailViewModel
import com.example.pokeapp.viewmodels.main.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {
    viewModel {
        MainViewModel(get())
    }
}

val detailModule = module {
    viewModel {
        DetailViewModel(get())
    }
}

val repositoryModule = module {
    fun provideRepository(api: PokeApi): PokeRepository {
        return PokeRepository(api)
    }

    single { provideRepository(get()) }
}

val apiModule = module {
    fun provideApiInterface(retrofit: Retrofit): PokeApi {
        return retrofit.create(PokeApi::class.java)
    }

    single { provideApiInterface(get()) }
}

val networkModule = module {

    fun provideHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(interceptor)

        return okHttpClientBuilder.build()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    single { provideHttpClient() }
    single { provideRetrofit(get()) }
}