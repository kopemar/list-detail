package cz.kopemar.listdetail.model

import com.google.gson.annotations.SerializedName

data class Repository (@SerializedName("id") val id: Int,
                       @SerializedName("name") val name: String,
                       @SerializedName("updated_at") val updated: String)
