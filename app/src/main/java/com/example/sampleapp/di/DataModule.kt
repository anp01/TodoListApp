package com.example.sampleapp.di

import com.example.sampleapp.data.repository.TodoRepositoryImpl
import com.example.sampleapp.domain.TodoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface DataModule {

    @Binds
    @ViewModelScoped
    fun bindTodoRepository(todoRepositoryImpl: TodoRepositoryImpl): TodoRepository
}