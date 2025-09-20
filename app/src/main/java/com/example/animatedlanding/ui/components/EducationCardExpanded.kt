package com.example.animatedlanding.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.animatedlanding.data.model.EducationCard
import com.example.animatedlanding.ui.utils.safeParseColor

@Composable
fun EducationCardExpanded(card: EducationCard) {
    Card(
        modifier = Modifier
            .padding(vertical = 2.dp)
            .clip(RoundedCornerShape(28.dp))
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(
                    colors = listOf(
                        safeParseColor(card.startGradient).copy(alpha = 0.8f),
                        safeParseColor(card.endGradient).copy(alpha = 0.1f)
                    )
                ),
                shape = RoundedCornerShape(28.dp)
            ),
        colors = CardDefaults.cardColors(
            Color.White.copy(alpha = 0.1f) // ✅ Proper way
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = card.image,
                contentDescription = card.expandStateText,
                modifier = Modifier
                    .height(300.dp)
                    .clip(RoundedCornerShape(14.dp)),
            )
            Text(
                text = card.expandStateText,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.width(200.dp).padding(top = 2.dp)
            )
        }
    }
}

