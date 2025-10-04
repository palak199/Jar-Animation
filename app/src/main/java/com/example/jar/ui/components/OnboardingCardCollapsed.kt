package com.example.jar.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.jar.data.model.EducationCard
import com.example.jar.ui.utils.safeParseColor

@Composable
fun EducationCardCollapsed(card: EducationCard) {
    val context = LocalContext.current

    val resId = context.resources.getIdentifier(card.image, "drawable", context.packageName)

    val imageModel: Any = if (resId != 0) resId else card.image
    Card(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .padding(vertical = 2.dp, horizontal = 12.dp)
                .clip(RoundedCornerShape(28.dp))
                .border(
                    width = 1.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            safeParseColor(card.strokeStartColor).copy(alpha = 0.8f),
                            safeParseColor(card.strokeEndColor).copy(alpha = 0.1f)
                        )
                    ),
                    shape = RoundedCornerShape(28.dp)
                ),
            colors = CardDefaults.cardColors(
                containerColor = safeParseColor(card.startGradient).copy(alpha = 0.08f)
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 0.dp
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 8.dp)
            ) {
                if (resId != 0) {
                    Image(
                        painter = painterResource(id = resId),
                        contentDescription = card.expandStateText,
                        modifier = Modifier
                            .height(72.dp)
                            .width(56.dp)
                            .clip(RoundedCornerShape(30.dp)),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Text("⚠️ Missing drawable: ${card.image}", color = Color.Red)
                }
                Spacer(Modifier.width(10.dp))
                Text(
                    text = card.collapsedStateText,
                    textAlign = TextAlign.Left,
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall
                )
                Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "Toggle", tint = Color.White)
            }
        }
    }

