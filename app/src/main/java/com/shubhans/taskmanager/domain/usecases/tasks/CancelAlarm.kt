package com.shubhans.taskmanager.domain.usecases.tasks

import com.shubhans.taskmanager.domain.repository.AlarmScheduler

class CancelAlarm(
    private val alarmScheduler: AlarmScheduler
) {
    operator fun invoke(taskId: Int){
        alarmScheduler.cancelTaskAlarm(taskId)
    }
}