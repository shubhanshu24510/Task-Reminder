package com.shubhans.taskmanager.domain.usecases.app_theme

import com.shubhans.taskmanager.domain.usecases.app_entry.GetAppEntry
import com.shubhans.taskmanager.domain.usecases.app_entry.GetSavedTheme
import com.shubhans.taskmanager.domain.usecases.app_entry.SaveAppEntry

data class ThemeUseCases(
    val saveAppTheme: SaveAppTheme,
    val getAppEntry: GetAppEntry,
    val saveAppEntry: SaveAppEntry,
    val getSavedTheme: GetSavedTheme // Added function to retrieve the saved theme color
)