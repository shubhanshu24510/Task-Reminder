package com.shubhans.taskmanager.domain.usecases.app_entry

import androidx.compose.ui.graphics.Color
import com.shubhans.taskmanager.domain.manager.LocalUserManager
import javax.inject.Inject

class GetSavedTheme @Inject constructor(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(): Color? {
        return localUserManager.readAppTheme() // Fetch the saved theme color as Compose Color
    }
}