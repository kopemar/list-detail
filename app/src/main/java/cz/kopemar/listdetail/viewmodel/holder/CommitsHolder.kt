package cz.kopemar.listdetail.viewmodel.holder

import androidx.lifecycle.MediatorLiveData
import cz.kopemar.listdetail.model.Branch
import cz.kopemar.listdetail.model.CommitWrapper

class CommitsHolder {
    companion object {
        var repo: String? = null
        var commits: MediatorLiveData<List<CommitWrapper>>? = null
        var branches: MediatorLiveData<List<Branch>>? = null
    }
}