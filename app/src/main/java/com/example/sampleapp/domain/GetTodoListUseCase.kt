package com.example.sampleapp.domain

import com.example.sampleapp.domain.mapper.toTodoState
import com.example.sampleapp.presentation.nav.todo.TodoState
import javax.inject.Inject

class GetTodoListUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    suspend operator fun invoke(isFalseOnly: Boolean = false): List<TodoState> {
        val response = repository.getTodoList()
        return if (response.isSuccessful) {
            response.body()?.todos
                ?.filter {
                    if (isFalseOnly) {
                        it.completed == false
                    } else true
                }
                ?.map {
                    it.toTodoState()
                } ?: emptyList()
        } else {
            emptyList()
        }
    }
}