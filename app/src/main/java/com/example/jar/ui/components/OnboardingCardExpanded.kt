package com.example.jar.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.jar.data.model.EducationCard
import com.example.jar.ui.utils.safeParseColor

@Composable
fun EducationCardExpanded(card: EducationCard) {
    val context = LocalContext.current
    val resId = context.resources.getIdentifier(card.image, "drawable", context.packageName)
    val imageModel: Any = if (resId != 0) resId else card.image
    Log.d("EducationCard", "Looking for drawable: ${card.image}")
    Log.d("EducationCard", "Resolved id: $resId")

    Card(
        modifier = Modifier
            .padding(vertical = 2.dp)
            .clip(RoundedCornerShape(28.dp))
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    colors = listOf(
                        safeParseColor(card.strokeStartColor).copy(alpha = 0.1f),
                        safeParseColor(card.strokeEndColor).copy(alpha = 0.8f)
                    )
                ),
                shape = RoundedCornerShape(28.dp)
            ),
        colors = CardDefaults.cardColors(
            safeParseColor(card.startGradient).copy(alpha = 0.9f) // ✅ Proper way
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (resId != 0) {
                Image(
                    painter = painterResource(id = resId),
                    contentDescription = card.expandStateText,
                    modifier = Modifier
                        .height(300.dp)
                        .clip(RoundedCornerShape(14.dp))
                )
            } else {
                Text("⚠️ Missing drawable: ${card.image}", color = Color.Red)
            }
            Text(
                text = card.expandStateText,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.width(200.dp).padding(top = 4.dp)
            )
        }
    }
}

