import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.jar.data.model.EducationCard
import com.example.jar.ui.components.EducationCardCollapsed
import com.example.jar.ui.components.EducationCardExpanded

@Composable
fun OnboardingCardWidget(
    card: EducationCard,
    isExpanded: Boolean,
    hasCollapsed: Boolean,
    isActive: Boolean,
    index: Int
) {
    val density = LocalDensity.current
    val startOffset = with(density) { 300.dp.toPx() }

    // Translation animation
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
        } else if (isActive) {
            translationY.snapTo(0f)
        }
    }

    // Scale & alpha animations
    val scale by animateFloatAsState(targetValue = if (isExpanded) 1f else 0.9f)
    val alpha by animateFloatAsState(targetValue = if (isExpanded) 1f else 0.7f)

    // Tilt animation: start tilted, then straighten
    val rotation = remember { Animatable(0f) }
    LaunchedEffect(isActive) {
        if (isActive) {
            val startTilt = if (hasCollapsed) -15f else 15f
            rotation.snapTo(startTilt) // start tilted
            rotation.animateTo(
                targetValue = 0f,      // straighten
                animationSpec = tween(
                    durationMillis = 800,
                    easing = LinearOutSlowInEasing
                )
            )
        } else {
            rotation.snapTo(0f)
        }
    }

    Box(
        modifier = Modifier
            .graphicsLayer(
                translationY = translationY.value,
                rotationZ = rotation.value,
                scaleX = scale,
                scaleY = scale,
                alpha = alpha,
                transformOrigin = TransformOrigin(0.5f, 0f) // tilt from top
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
