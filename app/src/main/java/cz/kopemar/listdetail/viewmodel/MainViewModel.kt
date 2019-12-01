package cz.kopemar.listdetail.viewmodel

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

    var repositories = RepositoriesHolder.repositories

    private lateinit var apiService: GitHubService

    init {
        connect()
    }

    fun getAllRepos(): LiveData<List<Repository>> {
        if (repositories == null) {
            return fetchAllRepos()
        }
        return repositories!!
    }

    private fun fetchAllRepos(): MediatorLiveData<List<Repository>> {
        val call = apiService.getAllRepos()

        RepositoriesHolder.repositories = MediatorLiveData()

        call.enqueue(object : Callback<List<Repository>> {
            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                if (response.isSuccessful) RepositoriesHolder.repositories!!.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                t.localizedMessage
            }
        })

        return RepositoriesHolder.repositories!!
    }

    private fun connect() {
        val retrofit = provideRetrofit(provideOkHttpClient())
        apiService = retrofit.create(GitHubService::class.java)
    }

}
