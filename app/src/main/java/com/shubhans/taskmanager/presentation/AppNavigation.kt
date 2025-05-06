package com.shubhans.taskmanager.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.shubhans.taskmanager.presentation.navgraph.Route
import com.shubhans.taskmanager.presentation.navgraph.TasksNavGraph
import com.shubhans.taskmanager.presentation.onboarding.OnBoardingScreen
import com.shubhans.taskmanager.presentation.onboarding.OnBoardingViewModel

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: Route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        navigation<Route.AppStartNavigation>(
            startDestination = Route.OnBoarding
        ) {
            composable<Route.OnBoarding> {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }
        navigation<Route.AppMainNavigation>(
            startDestination = Route.AppNavigatorScreen
        ) {
            composable<Route.AppNavigatorScreen> {
                TasksNavGraph()
            }
        }
    }
}
