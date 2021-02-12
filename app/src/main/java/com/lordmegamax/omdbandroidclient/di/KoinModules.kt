package com.lordmegamax.omdbandroidclient.di

import com.lordmegamax.omdbandroidclient.data.ApiKeyInterceptor
import com.lordmegamax.omdbandroidclient.data.OmdbApi
import com.lordmegamax.omdbandroidclient.ui.home.HomeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    viewModel { HomeViewModel(get()) }
}

val networkModule = module {

    single<OmdbApi> {
        Retrofit.Builder()
            // TODO: 11-Feb-21 move url to proper place
            .baseUrl("http://www.omdbapi.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()

            .create(OmdbApi::class.java)
    }

    single {
        OkHttpClient.Builder()
            // TODO: 11-Feb-21 move apikey value to proper place
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.HEADERS)
            )
            .addInterceptor(ApiKeyInterceptor("2d75c2e"))

            .build()
    }


}