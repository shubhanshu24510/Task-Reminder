package com.shubhans.taskmanager.domain.usecases.app_theme

import androidx.compose.ui.graphics.Color
import com.shubhans.taskmanager.domain.manager.LocalUserManager

class SaveAppTheme(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(appTheme: Color){
        localUserManager.saveAppTheme(appTheme)
    }
}