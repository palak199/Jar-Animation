package com.example.animatedlanding.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animatedlanding.data.model.EducationCard

@Composable
fun EducationCardWidget(
    card: EducationCard,
    isExpanded: Boolean,
    hasCollapsed: Boolean
) {
    val targetHeight = when {
        isExpanded -> 400.dp
        hasCollapsed -> 80.dp
        else -> 0.dp
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(targetHeight)
            .animateContentSize()
            .padding(vertical = 2.dp),
        contentAlignment = Alignment.Center
    ) {
        when {
            isExpanded -> EducationCardExpanded(card)
            hasCollapsed -> EducationCardCollapsed(card)
            else -> {} // Empty slot
        }
    }
}
