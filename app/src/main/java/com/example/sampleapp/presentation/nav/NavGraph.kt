package com.example.sampleapp.presentation.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sampleapp.presentation.nav.home.HomeScreen
import com.example.sampleapp.presentation.nav.todo.TodoListScreen
import com.example.sampleapp.presentation.nav.todo.TodoListViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable("home") {
            HomeScreen(
                modifier = modifier,
                onDisplayAll = { navController.navigate("all_list") },
                onDisplayFalse = { navController.navigate("false_list") },
                onDisplayTest = {})
        }

        composable("all_list") {
            val viewModel: TodoListViewModel =
                hiltViewModel(creationCallback = { factory: TodoListViewModel.TodoListViewModelFactory ->
                    factory.create(isFalseOnly = false)

                })
            val listItem by viewModel.todoList.collectAsStateWithLifecycle()

            TodoListScreen(itemList = listItem, modifier = modifier)
        }

        composable("false_list") {
            val viewModel: TodoListViewModel =
                hiltViewModel(creationCallback = { factory: TodoListViewModel.TodoListViewModelFactory ->
                    factory.create(isFalseOnly = true)

                })
            val listItem by viewModel.todoList.collectAsStateWithLifecycle()

            TodoListScreen(itemList = listItem, modifier = modifier)
        }
    }
}