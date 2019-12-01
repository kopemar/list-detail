package cz.kopemar.listdetail.viewmodel

import androidx.lifecycle.MediatorLiveData
import cz.kopemar.listdetail.model.Repository

class RepositoriesHolder {
    companion object {
        var repositories: MediatorLiveData<List<Repository>>? = null
    }
}