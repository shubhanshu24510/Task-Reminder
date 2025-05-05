package com.shubhans.taskmanager.domain.usecases.app_theme

import com.shubhans.taskmanager.domain.manager.LocalUserManager

class SaveAppTheme(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(appTheme: String){
        localUserManager.saveAppTheme(appTheme)
    }
}