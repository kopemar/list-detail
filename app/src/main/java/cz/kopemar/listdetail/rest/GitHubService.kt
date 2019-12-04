package cz.kopemar.listdetail.rest

import cz.kopemar.listdetail.model.Branch
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.model.Repository
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {

    /**
     * Call to get all repositories
     */
    @GET("users/Janamou/repos")
    suspend fun getAllRepos(): List<Repository>

    /**
     * Call to get all commits in given repository
     */
    @GET("repos/Janamou/{repo}/commits")
    suspend fun getAllCommitsInRepo(@Path("repo") repo: String): List<CommitWrapper>

    /**
     * Call to get some latest commits in given repository
     */
    @GET("repos/Janamou/{repo}/commits")
    suspend fun getCommitsInRepo(@Path("repo") repo: String, @Query("per_page") limit: Int): List<CommitWrapper>

    /**
     * Get all branches in repo.
     */
    @GET("repos/Janamou/{repo}/branches")
    suspend fun getBranchesInRepo(@Path("repo") repo: String): List<Branch>

}