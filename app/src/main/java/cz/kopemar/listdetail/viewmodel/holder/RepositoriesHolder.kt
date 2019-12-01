package cz.kopemar.listdetail.viewmodel.holder

import androidx.lifecycle.MediatorLiveData
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.model.Repository

class RepositoriesHolder {
    companion object {
        var repositories: MediatorLiveData<List<Repository>>? = null
        var commits: MediatorLiveData<List<CommitWrapper>>? = null
    }
}