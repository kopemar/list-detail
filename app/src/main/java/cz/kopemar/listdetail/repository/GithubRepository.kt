package cz.kopemar.listdetail.repository

import cz.kopemar.listdetail.rest.GitHubService

class GithubRepository(private val githubApi: GitHubService) {
    suspend fun getAllRepos() = githubApi.getAllRepos()

    suspend fun getAllBranchesInRepo(repoName: String) = githubApi.getBranchesInRepo(repoName)

    suspend fun getAllCommitsInRepo(repoName: String) = githubApi.getAllCommitsInRepo(repoName)

    suspend fun getCommitsInRepo(repoName: String, limit: Int) =
        githubApi.getCommitsInRepo(repoName, limit)
}