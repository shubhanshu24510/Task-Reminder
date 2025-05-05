package com.shubhans.taskmanager.domain.model

import androidx.compose.ui.graphics.Color
import com.shubhans.taskmanager.ui.theme.HighPriorityColor
import com.shubhans.taskmanager.ui.theme.LowPriorityColor
import com.shubhans.taskmanager.ui.theme.MediumPriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
}