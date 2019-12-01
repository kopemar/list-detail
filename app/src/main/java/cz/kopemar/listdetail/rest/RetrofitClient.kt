package cz.kopemar.listdetail.rest

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val BASE_URL = "https://api.github.com/"

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(setUpGson()))
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    val client = OkHttpClient().newBuilder()

    client.addInterceptor {
        return@addInterceptor it.proceed(it.request())
    }

    return client.build()
}

private fun setUpGson(): Gson {
    return GsonBuilder()
        .setLenient()
        .create()
}