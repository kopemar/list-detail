package cz.kopemar.listdetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.viewmodel.holder.RepositoriesHolder.Companion.repositories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : BaseViewModel() {

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
                }
            }

            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                t.localizedMessage
            }
        })

        return repositories!!
    }

}
