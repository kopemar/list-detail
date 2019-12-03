package cz.kopemar.listdetail.viewmodel

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import cz.kopemar.listdetail.model.Branch
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.branches
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.commits
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewModel : BaseViewModel() {

    var name: String? = null
    set (value) {
        field = value
        repo = value
    }

    fun getAllBranchesInRepo(repo: String): MediatorLiveData<List<Branch>> {
        if (branches == null) {
            return fetchAllBranches(repo)
        }
        return branches!!
    }

    fun getAllCommitsInRepo(repo: String): MediatorLiveData<List<CommitWrapper>> {
        if (commits == null) {
            return fetchAllCommits(repo)
        }
        return commits!!
    }

    private fun fetchAllBranches(repo: String): MediatorLiveData<List<Branch>> {
        val call = apiService.getBranchesInRepo(repo)

        branches = MediatorLiveData()

        call.enqueue(object : Callback<List<Branch>> {
            override fun onResponse(
                call: Call<List<Branch>>,
                response: Response<List<Branch>>
            ) {
                if (branches != null) {
                    if (response.isSuccessful) branches!!.postValue(response.body())
                    else Log.i(MainViewModel.tag, "Got ${response.code()} when fetching all branches")
                }
            }
            override fun onFailure(call: Call<List<Branch>>, t: Throwable) {
                t.localizedMessage
            }
        })

        return branches!!
    }

    private fun fetchAllCommits(repo: String): MediatorLiveData<List<CommitWrapper>> {
        val call = apiService.getCommitsInRepo(repo, limit)

        commits = MediatorLiveData()

        call.enqueue(object : Callback<List<CommitWrapper>> {
            override fun onResponse(
                call: Call<List<CommitWrapper>>,
                response: Response<List<CommitWrapper>>
            ) {
                if (commits != null) {
                    if (response.isSuccessful) commits!!.postValue(response.body())
                    else Log.i(MainViewModel.tag, "Got ${response.code()} when fetching all commits")
                }
            }

            override fun onFailure(call: Call<List<CommitWrapper>>, t: Throwable) {
                t.localizedMessage
            }
        })

        return commits!!
    }

    companion object {
        const val limit = 10
    }
}