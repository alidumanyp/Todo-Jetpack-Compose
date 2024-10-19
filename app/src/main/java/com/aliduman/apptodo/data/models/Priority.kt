package com.aliduman.apptodo.data.models

import androidx.compose.ui.graphics.Color
import com.aliduman.apptodo.ui.theme.HighPriorityColor
import com.aliduman.apptodo.ui.theme.LowPriorityColor
import com.aliduman.apptodo.ui.theme.MediumPriorityColor
import com.aliduman.apptodo.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}
