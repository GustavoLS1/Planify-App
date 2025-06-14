package com.example.planify.screen.homePage.ui.di

import android.content.Context
import com.example.planify.BuildConfig
import com.example.planify.auth.authInterceptor
import com.example.planify.screen.homePage.ui.data.recoverHomePageApiServe
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object homePageRetrofitHelper {

    private var retrofit: Retrofit? = null

    fun getHomePageService(context: Context): recoverHomePageApiServe {

        if (retrofit == null) {
            val gson = GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create()

            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(authInterceptor(context)) // JWT aquí
                .writeTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(1, TimeUnit.MINUTES)
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(okHttpClient)
                .build()
        }

        return retrofit!!.create(recoverHomePageApiServe::class.java)
    }
}