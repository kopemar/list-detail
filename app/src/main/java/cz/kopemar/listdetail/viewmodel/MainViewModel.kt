package cz.kopemar.listdetail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.rest.GitHubService
import cz.kopemar.listdetail.rest.provideOkHttpClient
import cz.kopemar.listdetail.rest.provideRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private lateinit var apiService: GitHubService

    init {
        connect()
    }

    fun getAllRepos(): LiveData<List<Repository>> {
        val call = apiService.getAllRepos()

        val data = MediatorLiveData<List<Repository>>()

        call.enqueue(object : Callback<List<Repository>> {
            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                if (response.isSuccessful) data.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                t.localizedMessage
            }
        })
        return data
    }

    private fun connect() {
        val retrofit = provideRetrofit(provideOkHttpClient())
        apiService = retrofit.create(GitHubService::class.java)
    }

}
