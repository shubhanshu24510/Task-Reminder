package com.shubhans.taskmanager.domain.usecases.app_theme

import com.shubhans.taskmanager.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class GetAppTheme(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke(): Flow<String>{
        return localUserManager.readAppTheme()
    }
}