package cz.kopemar.listdetail.rest

import cz.kopemar.listdetail.model.Repository
import retrofit2.Call
import retrofit2.http.GET

interface GitHubService {

    @GET("repos")
    fun getAllRepos(): Call<List<Repository>>

}