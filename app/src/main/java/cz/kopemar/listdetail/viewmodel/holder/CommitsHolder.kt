package cz.kopemar.listdetail.viewmodel.holder

import androidx.lifecycle.MediatorLiveData
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.model.Repository

class CommitsHolder {
    companion object {
        var repo: String? = null
        var commits: MediatorLiveData<List<CommitWrapper>>? = null
    }
}