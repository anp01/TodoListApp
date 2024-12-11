package com.example.sampleapp.domain.mapper

import com.example.sampleapp.data.dto.Todo
import com.example.sampleapp.presentation.nav.todo.TodoState

fun Todo.toTodoState(): TodoState {
    return TodoState(
        todo = todo.orEmpty(),
        isCompleted = completed ?: false
    )
}