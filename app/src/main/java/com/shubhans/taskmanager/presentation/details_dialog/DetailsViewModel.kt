package com.shubhans.taskmanager.presentation.details_dialog

import androidx.lifecycle.ViewModel
import com.shubhans.taskmanager.domain.model.Task
import com.shubhans.taskmanager.domain.usecases.tasks.AlarmUseCase
import com.shubhans.taskmanager.domain.usecases.tasks.TaskUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val taskUseCases: TaskUseCases,
    private val alarmUseCase: AlarmUseCase
) : ViewModel() {

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.UpsertTask -> {
                upsertTask(event.task)
            }
            is DetailsEvent.DeleteTask -> {
                deleteTask(event.task)
            }
        }
    }
    private fun upsertTask(task: Task) {
        CoroutineScope(Dispatchers.IO).launch {
            taskUseCases.upsertTask(task)
        }
    }

    private fun deleteTask(task: Task){
        CoroutineScope(Dispatchers.IO).launch {
            taskUseCases.deleteTask(task)
        }
        alarmUseCase.cancelAlarm(task.id)
    }
}