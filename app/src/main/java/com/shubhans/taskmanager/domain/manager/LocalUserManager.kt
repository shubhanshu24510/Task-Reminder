package com.shubhans.taskmanager.domain.manager

import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    suspend fun saveAppTheme(appTheme: Color) // Use Compose Color
    suspend fun saveAppEntry()
    fun readAppEntry(): Flow<Boolean>
    suspend fun readAppTheme(): Color? // Use Compose Color
}