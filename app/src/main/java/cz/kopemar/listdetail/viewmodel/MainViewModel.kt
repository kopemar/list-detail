package cz.kopemar.listdetail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.repository.GithubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val githubRepo: GithubRepository) : BaseViewModel() {

    var repositories: MediatorLiveData<List<Repository>>? = null

    fun getAllRepos(): LiveData<List<Repository>> {
        if (repositories == null) {
            return fetchAllRepos()
        }
        return repositories!!
    }

    private fun fetchAllRepos(): MediatorLiveData<List<Repository>> {
        val call = apiService.getAllRepos()

        repositories = MediatorLiveData()

        call.enqueue(object : Callback<List<Repository>> {
            override fun onResponse(
                call: Call<List<Repository>>,
                response: Response<List<Repository>>
            ) {
                if (repositories != null) {
                    if (response.isSuccessful) repositories!!.postValue(response.body())
                    else Log.i(tag, "Got ${response.code()} when fetching all repos")
                }
            }
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                t.localizedMessage
            }
        })
        return repositories!!
    }

    companion object {
        const val tag = "MainViewModel"
    }

}
