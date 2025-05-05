package com.shubhans.taskmanager.data.repository

import com.shubhans.taskmanager.data.local.TasksDao
import com.shubhans.taskmanager.domain.model.Task
import com.shubhans.taskmanager.domain.repository.TasksRepository
import kotlinx.coroutines.flow.Flow

class TasksRepositoryImpl(
    private val tasksDao: TasksDao,
) : TasksRepository {
    override suspend fun upsertTask(task: Task) {
        tasksDao.insertTask(task)
    }

    override suspend fun deleteTask(task: Task) {
        tasksDao.deleteTask(task)
    }

    override fun getTasksList(filter: Int, sortOrder: Int): Flow<List<Task>> {
        return tasksDao.getTasksList(filter,sortOrder)
    }
}