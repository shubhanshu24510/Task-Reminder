package com.shubhans.taskmanager.presentation.navgraph

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object Setting : Route

    @Serializable
    data object OnBoarding : Route

    @Serializable
    data object AppStartNavigation : Route

    @Serializable
    data object AppMainNavigation : Route

    @Serializable
    data object AppNavigatorScreen : Route
}