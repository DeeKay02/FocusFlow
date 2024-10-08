package com.learn.focusflow.domain.model

import androidx.compose.ui.graphics.Color
import com.learn.focusflow.presentation.theme.gradient1
import com.learn.focusflow.presentation.theme.gradient2
import com.learn.focusflow.presentation.theme.gradient3
import com.learn.focusflow.presentation.theme.gradient4
import com.learn.focusflow.presentation.theme.gradient5

data class Topic(
    val name: String,
    val goalHours: Float,
    val colors: List<Color>,
    val topicId: Int
) {
    companion object {
        val topicCardColors = listOf(gradient1, gradient2, gradient3, gradient4, gradient5)
    }
}
