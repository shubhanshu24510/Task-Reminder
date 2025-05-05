package com.shubhans.taskmanager.domain.usecases.tasks

import com.shubhans.taskmanager.domain.model.Task
import com.shubhans.taskmanager.domain.repository.TasksRepository

class DeleteTask(
    private val tasksRepository: TasksRepository,
) {
    suspend operator fun invoke(task: Task) {
        tasksRepository.deleteTask(task)
    }
}