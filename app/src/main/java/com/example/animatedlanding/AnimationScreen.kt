import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.animatedlanding.data.model.EducationCard
import com.example.animatedlanding.data.model.EducationCardState
import com.example.animatedlanding.ui.components.ActionButton
import com.example.animatedlanding.data.model.EducationData
import com.example.animatedlanding.ui.components.EducationCardCollapsed
import com.example.animatedlanding.ui.components.EducationCardExpanded
import com.example.animatedlanding.ui.components.EducationCardWidget
import com.example.animatedlanding.ui.components.IntroSection
import com.example.animatedlanding.ui.components.SaveButtonComponent
import com.example.animatedlanding.ui.components.ToolBarSection
import com.example.animatedlanding.ui.utils.safeParseColor
import kotlinx.coroutines.delay

@Composable
fun AnimationScreen(data: EducationData) {

    // We have 3 states, 1 intro screen, then each card which can be collapsed/expanded
    val introExpanded = remember { mutableStateOf(false) }
    val currentCardIndex = remember { mutableIntStateOf(0) }
    var cardStates by remember {
        mutableStateOf(data.educationCardList.mapIndexed { index, _ -> EducationCardState(id = index) })
    }
    val currentCard by remember {
        derivedStateOf { data.educationCardList.getOrNull(currentCardIndex.intValue) }
    }

    LaunchedEffect(Unit) {
        // step1 intro screen
        delay(data.collapseExpandIntroInterval.toLong())
        introExpanded.value = true
        delay(data.expandCardStayInterval.toLong())
        introExpanded.value = false
        // cards time
        while(true) {
            if(currentCardIndex.intValue == data.educationCardList.size) {
                introExpanded.value = true
                cardStates.forEach {
                        card -> card.hasCollapsed = false
                    card.isExpanded = false
                }
                break
            }
            else {
                cardStates[currentCardIndex.intValue].isExpanded = true
                delay(data.expandCardStayInterval.toLong())
                cardStates[currentCardIndex.intValue].isExpanded = false
                delay(data.collapseCardTiltInterval.toLong())
                cardStates[currentCardIndex.intValue].hasCollapsed = true
            }
            currentCardIndex.intValue = (currentCardIndex.intValue + 1)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(colors = listOf(safeParseColor(currentCard?.startGradient), safeParseColor(currentCard?.endGradient))
                )
            )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .animateContentSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (introExpanded.value) {
            IntroSection(
                data.introTitle,
                data.introSubtitle,
                "#201929",
                expanded = true
            )
        } else {
            ToolBarSection(currentCard?.backGroundColor)
            Spacer(modifier = Modifier.height(10.dp))
            data.educationCardList.forEachIndexed { index, card ->
                EducationCardWidget(
                    card = card,
                    isExpanded = cardStates[index].isExpanded,
                    hasCollapsed = cardStates[index].hasCollapsed
                )
            }
            ActionButton(data.ctaLottie)
            SaveButtonComponent(data.saveButtonCta)
        }
    }
}





