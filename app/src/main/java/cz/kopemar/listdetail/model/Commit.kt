package cz.kopemar.listdetail.model

import com.google.gson.annotations.SerializedName

data class CommitWrapper(
    @SerializedName("sha") val sha: String,
    @SerializedName("commit") val commit: Commit
) : AbstractEntity()

data class Commit(
    @SerializedName("message") val message: String,
    @SerializedName("committer") val committer: Committer
) : AbstractEntity()
