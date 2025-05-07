package com.shubhans.taskmanager.presentation.settings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubhans.taskmanager.domain.usecases.app_theme.ThemeUseCases
import com.shubhans.taskmanager.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val themeUseCases: ThemeUseCases,
) : ViewModel() {

    var selectedTheme by mutableStateOf<Color>(Color(0xFF6200EE))
        private set

    var startDestination by mutableStateOf<Route?>(null)
        private set

    init {
        getAppEntry()
        loadSavedTheme() // Load the saved theme at initialization
    }

    private fun getAppEntry() {
        themeUseCases.getAppEntry().onEach {
            startDestination =
                (if (it) Route.AppMainNavigation else Route.AppStartNavigation)
        }.launchIn(viewModelScope)
    }

    private fun loadSavedTheme() {
        viewModelScope.launch {
            val savedTheme = themeUseCases.getSavedTheme() // Use case to get the saved theme
            selectedTheme = savedTheme ?: Color(0xFF6200EE) // Use saved theme or default
        }
    }

    fun updateTheme(appTheme: Color) {
        selectedTheme = appTheme // Update the current theme
        viewModelScope.launch {
            themeUseCases.saveAppTheme(appTheme) // Save the theme to persistent storage
        }
    }
}