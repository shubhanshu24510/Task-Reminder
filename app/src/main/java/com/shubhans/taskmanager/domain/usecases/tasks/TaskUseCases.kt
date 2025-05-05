package com.shubhans.taskmanager.domain.usecases.tasks

data class TaskUseCases(
    val upsertTask: UpsertTask,
    val deleteTask: DeleteTask,
    val getTasksList: GetTasksList
)