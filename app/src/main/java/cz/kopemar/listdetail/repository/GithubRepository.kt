package cz.kopemar.listdetail.repository

import android.util.Log
import cz.kopemar.listdetail.model.Branch
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.rest.GitHubService
import retrofit2.HttpException

class GithubRepository(private val githubApi: GitHubService) {

    /**
     * @return list of all repositories.
     * Try-catch block for catching HttpExceptions (eg. 403 code for more than 60 requests per hour).
     */
    suspend fun getAllRepos(): List<Repository> {
        return try {
            githubApi.getAllRepos()
        } catch (e: HttpException) {
            Log.d(TAG, "Got HttpException ")
            ArrayList()
        }
    }

    /**
     * @return list of all branches in individual repository.
     * Try-catch block for catching HttpExceptions (eg. 403 code for more than 60 requests per hour).
     */
    suspend fun getAllBranchesInRepo(repoName: String): List<Branch> {
        return try {
            githubApi.getBranchesInRepo(repoName)
        } catch (e: HttpException) {
            Log.d(TAG, "Got HttpException ")
            ArrayList()
        }
    }

    /**
     * @return list of all commits in individual repository.
     * Try-catch block for catching HttpExceptions (eg. 403 code for more than 60 requests per hour).
     */
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