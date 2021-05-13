package com.golnaz.countries.utils.networkDi

import android.viewbinding.BuildConfig
import com.skydoves.sandwich.coroutines.CoroutinesResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(
        httpClient: OkHttpClient.Builder,
        converterFactory: MoshiConverterFactory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://restcountries.eu/rest")
            .addConverterFactory(converterFactory)
            .client(httpClient.build())
            .addCallAdapterFactory(CoroutinesResponseCallAdapterFactory())
            .build()

    @Provides
    @Singleton
    fun provideOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient.Builder {
        val httpClient = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(httpLoggingInterceptor)
        }
        httpClient.retryOnConnectionFailure(true)
        return httpClient
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }
}