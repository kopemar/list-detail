package cz.kopemar.listdetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import cz.kopemar.listdetail.model.Branch
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.repository.GithubRepository

/**
 * ViewModel for RepositoryDetailActivity and its Fragments.
 */
class RepositoryDetailViewModel(githubRepo: GithubRepository) : BaseViewModel(githubRepo) {

    var repositoryName: String = "repository"

    var commits: LiveData<List<CommitWrapper>> = fetchCommits()

    var branches: LiveData<List<Branch>> = fetchBranches()

    fun refreshCommits() {
        commits = fetchCommits()
    }

    fun refreshBranches() {
        branches = fetchBranches()
    }

    private fun fetchBranches(): LiveData<List<Branch>> {
        return liveData {
            emit(githubRepo.getAllBranchesInRepo(repositoryName))
        }
    }

    private fun fetchCommits(): LiveData<List<CommitWrapper>> {
        return liveData {
            emit(githubRepo.getCommitsInRepo(repositoryName, LIMIT))
        }
    }

    companion object {
        const val LIMIT = 10
    }
}