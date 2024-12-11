package com.example.sampleapp.data.repository

import com.example.sampleapp.data.api.ApiService
import com.example.sampleapp.data.dto.TodoListResponse
import com.example.sampleapp.domain.TodoRepository
import retrofit2.Response
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(private val api: ApiService) : TodoRepository {
    override suspend fun getTodoList(): Response<TodoListResponse> {
        return api.getTodoList()
    }
}