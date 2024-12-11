package com.example.sampleapp.data.api

import com.example.sampleapp.data.dto.TodoListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("todos")
    suspend fun getTodoList(): Response<TodoListResponse>
}