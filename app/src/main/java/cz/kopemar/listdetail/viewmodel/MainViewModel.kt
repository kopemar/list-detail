package cz.kopemar.listdetail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.repository.GithubRepository

/**
 * ViewModel for MainActivity and its Fragments.
 */
class MainViewModel(githubRepo: GithubRepository) : BaseViewModel(githubRepo) {

    var repositories: LiveData<List<Repository>> = fetchRepositories()

    fun refreshRepositories() {
        repositories = fetchRepositories()
    }

    private fun fetchRepositories(): LiveData<List<Repository>> {
        return liveData {
            emit(githubRepo.getAllRepos())
        }
    }

}
