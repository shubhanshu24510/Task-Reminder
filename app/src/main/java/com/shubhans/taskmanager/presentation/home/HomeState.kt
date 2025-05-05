package com.shubhans.taskmanager.presentation.home

import com.shubhans.taskmanager.domain.model.Task

data class HomeState(
    val isLoading: Boolean = true,
    val taskCount: Int = 0,
    val completedTasks: Int = 0,
    val tasks: List<Task> = mutableListOf(),
    val sortOrder: Int = 0,
    val filter: Int = 0
)