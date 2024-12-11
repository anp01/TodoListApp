package com.example.sampleapp.data.dto


import com.google.gson.annotations.SerializedName

data class Todo(
    @SerializedName("completed")
    val completed: Boolean?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("todo")
    val todo: String?,
    @SerializedName("userId")
    val userId: Int?
)