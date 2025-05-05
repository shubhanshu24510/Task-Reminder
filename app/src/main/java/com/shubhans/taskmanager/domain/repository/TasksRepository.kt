package com.shubhans.taskmanager.domain.repository

import com.shubhans.taskmanager.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TasksRepository {
    suspend fun upsertTask(task: Task)
    suspend fun deleteTask(task: Task)
    fun getTasksList(filter: Int, sortOrder: Int): Flow<List<Task>>
}