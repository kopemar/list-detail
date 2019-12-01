package cz.kopemar.listdetail.viewmodel

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import cz.kopemar.listdetail.rest.GitHubService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseViewModel: ViewModel() {

    init {
        connect()
    }

    protected lateinit var apiService: GitHubService

    private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val baseUrl = "https://api.github.com/"
        return Retrofit.Builder().baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(setUpGson()))
            .build()
    }

    private fun provideOkHttpClient(): OkHttpClient {
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

    private fun connect() {
        val retrofit = provideRetrofit(provideOkHttpClient())
        apiService = retrofit.create(GitHubService::class.java)
    }
}