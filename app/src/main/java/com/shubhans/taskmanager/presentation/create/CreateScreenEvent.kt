package com.shubhans.taskmanager.presentation.create

import com.shubhans.taskmanager.domain.model.Task

sealed class CreateScreenEvent{
    data class UpsertTask(val task: Task): CreateScreenEvent()
}