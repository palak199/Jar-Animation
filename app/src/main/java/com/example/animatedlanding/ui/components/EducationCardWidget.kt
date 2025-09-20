package com.example.animatedlanding.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.animatedlanding.data.model.EducationCard

@Composable
fun EducationCardWidget(
    card: EducationCard,
    isExpanded: Boolean,
    hasCollapsed: Boolean,
    isActive: Boolean,
    index: Int // for stacking
) {
    val density = LocalDensity.current
    val startOffset = with(density) { 300.dp.toPx() }

    val translationY = remember { Animatable(startOffset) }

    LaunchedEffect(isActive) {
        if (isActive && !hasCollapsed) {
            translationY.animateTo(
                targetValue = 0f,
                animationSpec = tween(
                    durationMillis = 600,
                    easing = FastOutSlowInEasing
                )
            )
        } else if(isActive) {
            translationY.snapTo(0f)
        }
    }

    // Tilt animation
    val rotation by animateFloatAsState(
        targetValue = if (isExpanded) 0f else if (!hasCollapsed) 8f else 0f,
        animationSpec = tween(400, easing = LinearOutSlowInEasing)
    )

    // Scale & alpha
    val scale by animateFloatAsState(targetValue = if (isExpanded) 1f else 0.9f)
    val alpha by animateFloatAsState(targetValue = if (isExpanded) 1f else 0.7f)

    Box(
        modifier = Modifier
            .graphicsLayer(
                translationY = translationY.value,
                rotationZ = rotation,
                scaleX = scale,
                scaleY = scale,
                alpha = alpha
            )
            .zIndex(if (hasCollapsed) (100 - index).toFloat() else 0f)
            .padding(vertical = 8.dp)
    ) {
        if (isExpanded) {
            EducationCardExpanded(card)
        } else if (hasCollapsed) {
            EducationCardCollapsed(card)
        }
    }
}
