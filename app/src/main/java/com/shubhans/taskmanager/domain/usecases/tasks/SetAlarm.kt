package com.shubhans.taskmanager.domain.usecases.tasks

import com.shubhans.taskmanager.domain.model.Task
import com.shubhans.taskmanager.domain.repository.AlarmScheduler

class SetAlarm(
    private val alarmScheduler: AlarmScheduler
) {
    operator fun invoke(triggerAtMillis: Long,task: Task){
        alarmScheduler.schedule(triggerAtMillis,task)
    }
}