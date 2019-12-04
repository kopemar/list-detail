package cz.kopemar.listdetail.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import cz.kopemar.listdetail.repository.GithubRepository
import cz.kopemar.listdetail.rest.GitHubService
import cz.kopemar.listdetail.viewmodel.MainViewModel
import cz.kopemar.listdetail.viewmodel.RepositoryDetailViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val applicationModule: Module = module {
    viewModel { MainViewModel(get()) }
    viewModel { RepositoryDetailViewModel() }
}

val networkModule: Module = module {
    factory { provideOkHttpClient() }
    factory { provideGithubApi(get()) }
    single { provideRetrofit(get()) }
}

val githubModule = module {
    factory { GithubRepository(get()) }
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    val baseUrl = "https://api.github.com/"
    return Retrofit.Builder().baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(setUpGson()))
        .build()
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor {
        return@addInterceptor it.proceed(it.request())
    }.build()
}

private fun setUpGson(): Gson {
    return GsonBuilder()
        .setLenient()
        .create()
}

private fun provideGithubApi(retrofit: Retrofit): GitHubService {
    return retrofit.create(GitHubService::class.java)
}
