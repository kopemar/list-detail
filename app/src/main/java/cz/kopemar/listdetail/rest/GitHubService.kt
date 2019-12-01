package cz.kopemar.listdetail.rest

import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    /**
     * Call to get all repositories
     */
    @GET("users/Janamou/repos")
    fun getAllRepos(): Call<List<Repository>>

    /**
     * Call to get all commit wrappers in given repository
     */
    @GET("repos/Janamou/{repo}/commits")
    fun getAllCommitsInRepo(@Path("repo") repo: String): Call<List<CommitWrapper>>

}