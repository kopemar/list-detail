package cz.kopemar.listdetail.model

import com.google.gson.annotations.SerializedName

/**
 * Wrapper class for [Commit] (includes things like sha in JSON response).
 */
data class CommitWrapper(
    @SerializedName("commit") val commit: Commit
) : AbstractEntity()