package com.shubhans.taskmanager.domain.repository

import com.shubhans.taskmanager.domain.model.Task

interface AlarmScheduler {
    fun schedule(triggerAtMillis: Long, task: Task)
    fun cancelTaskAlarm(taskId: Int)
}