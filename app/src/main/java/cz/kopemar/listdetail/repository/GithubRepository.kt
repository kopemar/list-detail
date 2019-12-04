package cz.kopemar.listdetail.repository

import cz.kopemar.listdetail.rest.GitHubService

class GithubRepository(private val githubApi: GitHubService) {
    suspend fun getAllRepos() = githubApi.getAllRepos()

}