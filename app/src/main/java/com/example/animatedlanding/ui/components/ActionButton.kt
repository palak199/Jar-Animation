package com.example.animatedlanding.ui.components

import android.R.attr.onClick
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.LottieConstants
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animatedlanding.data.model.SaveBtn
import com.example.animatedlanding.ui.utils.safeParseColor

@Composable
fun ActionButton(saveBtnCta: SaveBtn, lottie: String) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Url(lottie))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 24.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(
            onClick = { saveBtnCta.deeplink },
            colors = ButtonDefaults.buttonColors(
                containerColor = safeParseColor(saveBtnCta.backgroundColor)
            ),
            shape = RoundedCornerShape(28.dp),
            modifier = Modifier
                .height(52.dp)
                .widthIn(min = 132.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = saveBtnCta.text,
                    color = safeParseColor(saveBtnCta.textColor),
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                LottieAnimation(
                    composition = composition,
                    progress = progress,
                    modifier = Modifier.size(36.dp).graphicsLayer(scaleY = -1f)
                )
            }
        }
    }
}
