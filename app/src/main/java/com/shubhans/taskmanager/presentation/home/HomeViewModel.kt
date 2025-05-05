package com.shubhans.taskmanager.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhans.taskmanager.domain.model.Task
import com.shubhans.taskmanager.domain.usecases.tasks.AlarmUseCase
import com.shubhans.taskmanager.domain.usecases.tasks.TaskUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.ZoneId
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val tasksUseCases: TaskUseCases,
    private val alarmUseCase: AlarmUseCase,
) : ViewModel() {


    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getTasks()
    }

    fun onEvent(event: HomeEvent) {
        CoroutineScope(Dispatchers.IO).launch {
            when (event) {
                is HomeEvent.UpsertTask -> {
                    val task = event.task
                    upsertTask(task)
                    setAlarm(task)
                }

                is HomeEvent.DeleteTask -> {
                    deleteTask(event.task)
                    cancelAlarm(event.task.id)
                }

                is HomeEvent.UpdateTaskSort -> {
                    _state.value = _state.value.copy(sortOrder = event.sortOrder)
                    getTasks()
                }

                is HomeEvent.UpdateTaskFilter -> {
                    _state.value = _state.value.copy(filter = event.filter)
                    getTasks()
                }
            }
        }
    }

    private fun getTasks() {
        Log.v("TTTOOL", "Filter: ${_state.value.filter} Sort: ${_state.value.sortOrder}")
        tasksUseCases.getTasksList(_state.value.filter, _state.value.sortOrder).onEach { tasks ->
            _state.value = _state.value.copy(tasks = tasks)
        }.launchIn(viewModelScope)
        _state.value = _state.value.copy(isLoading = false)
    }

    private fun setAlarm(task: Task) {
        val taskDateTime = LocalDateTime.of(task.dueDate, task.time)
        val timeInMillis = taskDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
        alarmUseCase.setAlarm(timeInMillis, task = task)
    }

    private fun cancelAlarm(taskId: Int) {
        alarmUseCase.cancelAlarm(taskId)
    }

    private suspend fun upsertTask(task: Task) {
        tasksUseCases.upsertTask(task)
    }

    private suspend fun deleteTask(task: Task) {
        tasksUseCases.deleteTask(task)
    }
}