package com.amroid.dose.ui.component


import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.amroid.dose.utils.px

@Composable
fun LoadingRecipeListShimmer(
){
  BoxWithConstraints(
    modifier = Modifier.fillMaxSize()
  ) {
    val cardWidthPx =  (maxWidth - 32.dp).value.px
    val cardHeightPx = 150
    val gradientWidth: Float = (0.2f * cardHeightPx)

    val infiniteTransition = rememberInfiniteTransition()
    val xCardShimmer = infiniteTransition.animateFloat(
      initialValue = 0f,
      targetValue = (cardWidthPx + gradientWidth),
      animationSpec = infiniteRepeatable(
        animation = tween(
          durationMillis = 1300,
          easing = LinearEasing,
          delayMillis = 300
        ),
        repeatMode = RepeatMode.Restart
      )
    )
    val yCardShimmer = infiniteTransition.animateFloat(
      initialValue = 0f,
      targetValue = (cardHeightPx + gradientWidth),
      animationSpec = infiniteRepeatable(
        animation = tween(
          durationMillis = 1300,
          easing = LinearEasing,
          delayMillis = 300
        ),
        repeatMode = RepeatMode.Restart
      )
    )

    val colors = listOf(
      Color.LightGray.copy(alpha = .9f),
      Color.LightGray.copy(alpha = .3f),
      Color.LightGray.copy(alpha = .9f),
    )

    LazyColumn {
      items(5){
        ShimmerCard(
          colors = colors,
          xShimmer = xCardShimmer.value,
          yShimmer = yCardShimmer.value,
          cardHeight = 150.dp,
          gradientWidth = gradientWidth,
          padding = 16.dp
        )
      }
    }
  }


}