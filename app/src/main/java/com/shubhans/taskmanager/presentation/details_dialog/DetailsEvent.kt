package com.shubhans.taskmanager.presentation.details_dialog

import com.shubhans.taskmanager.domain.model.Task

sealed class DetailsEvent {
    data class UpsertTask(val task: Task): DetailsEvent()
    data class DeleteTask(val task: Task): DetailsEvent()
}