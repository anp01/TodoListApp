package com.example.sampleapp.domain

import com.example.sampleapp.data.dto.TodoListResponse
import retrofit2.Response

interface TodoRepository {
    suspend fun getTodoList(): Response<TodoListResponse>
}