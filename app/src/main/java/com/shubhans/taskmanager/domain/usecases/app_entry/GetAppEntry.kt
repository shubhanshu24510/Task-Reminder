package com.shubhans.taskmanager.domain.usecases.app_entry

import com.shubhans.taskmanager.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class GetAppEntry(
    private val localUserManager: LocalUserManager,
) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}