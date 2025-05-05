package com.shubhans.taskmanager.presentation.onboarding

sealed class OnBoardingEvent {
    data object SaveAppEntry : OnBoardingEvent()
}