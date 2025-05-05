package com.shubhans.taskmanager.domain.usecases.tasks

import com.shubhans.taskmanager.domain.model.Task
import com.shubhans.taskmanager.domain.repository.TasksRepository
import kotlinx.coroutines.flow.Flow

class GetTasksList(
    private val tasksRepository: TasksRepository
) {
    operator fun invoke(filter: Int, sortOrder: Int): Flow<List<Task>> {
        return tasksRepository.getTasksList(filter,sortOrder)
    }
}