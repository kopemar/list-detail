package cz.kopemar.listdetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.rest.GitHubService
import cz.kopemar.listdetail.rest.provideOkHttpClient
import cz.kopemar.listdetail.rest.provideRetrofit
import cz.kopemar.listdetail.viewmodel.holder.RepositoriesHolder.Companion.commits
import cz.kopemar.listdetail.viewmodel.holder.RepositoriesHolder.Companion.repositories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

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

    fun getAllCommitsInRepo(repo: String): MediatorLiveData<List<CommitWrapper>> {
        if (commits == null) {
            return fetchAllCommits(repo)
        }
        return commits!!
    }

    private fun fetchAllRepos(): MediatorLiveData<List<Repository>> {
        val call = apiService.getAllRepos()

        repositories = MediatorLiveData()

        call.enqueue(object : Callback<List<Repository>> {
            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                if (response.isSuccessful) repositories!!.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                t.localizedMessage
            }
        })

        return repositories!!
    }

    private fun fetchAllCommits(repo: String): MediatorLiveData<List<CommitWrapper>> {
        val call = apiService.getAllCommitsInRepo(repo)

        commits = MediatorLiveData()

        call.enqueue(object : Callback<List<CommitWrapper>> {
            override fun onResponse(
                call: Call<List<CommitWrapper>>,
                response: Response<List<CommitWrapper>>
            ) {
                if (response.isSuccessful) commits!!.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CommitWrapper>>, t: Throwable) {
                t.localizedMessage
            }
        })

        return commits!!
    }

    private fun connect() {
        val retrofit = provideRetrofit(provideOkHttpClient())
        apiService = retrofit.create(GitHubService::class.java)
    }

}
