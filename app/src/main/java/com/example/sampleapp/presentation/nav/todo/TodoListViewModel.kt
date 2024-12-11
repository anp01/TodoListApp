package com.example.sampleapp.presentation.nav.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapp.domain.GetTodoListUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = TodoListViewModel.TodoListViewModelFactory::class)
class TodoListViewModel @AssistedInject constructor(
    private val getTodoListUseCase: GetTodoListUseCase,
    @Assisted private val isFalseOnly: Boolean
) : ViewModel() {

    private val _todoList: MutableStateFlow<List<TodoState>> = MutableStateFlow(emptyList())
    val todoList = _todoList.onStart {
        getTodoList()
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

    private fun getTodoList() {
        viewModelScope.launch {
            _todoList.emit(getTodoListUseCase(isFalseOnly = isFalseOnly))
        }
    }

    @AssistedFactory
    interface TodoListViewModelFactory {
        fun create(isFalseOnly: Boolean): TodoListViewModel
    }
}

