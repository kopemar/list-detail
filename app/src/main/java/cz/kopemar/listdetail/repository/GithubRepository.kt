package cz.kopemar.listdetail.repository

import android.util.Log
import cz.kopemar.listdetail.model.Branch
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.rest.GitHubService
import retrofit2.HttpException

class GithubRepository(private val githubApi: GitHubService) {

    suspend fun getAllRepos(): List<Repository> {
        return try {
            githubApi.getAllRepos()
        } catch (e: HttpException) {
            Log.d(TAG, "Got HttpException ")
            ArrayList()
        }
    }

    suspend fun getAllBranchesInRepo(repoName: String): List<Branch> {
        return try {
            githubApi.getBranchesInRepo(repoName)
        } catch (e: HttpException) {
            Log.d(TAG, "Got HttpException ")
            ArrayList()
        }
    }

    suspend fun getCommitsInRepo(repoName: String, limit: Int): List<CommitWrapper> {
        return try {
            githubApi.getCommitsInRepo(repoName, limit)
        } catch (e: HttpException) {
            Log.d(TAG, "Got HttpException ")
            ArrayList()
        }
    }

    companion object {
        const val TAG = "GithubRepository"
    }
}