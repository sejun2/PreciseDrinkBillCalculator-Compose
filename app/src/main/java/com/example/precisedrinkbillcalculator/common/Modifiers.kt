package com.example.precisedrinkbillcalculator.common

import androidx.compose.animation.core.EaseInOutQuad
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

fun Modifier.animateOpacityAndTransitionY(
    opacityDelay: Int = 900,
    transitionDelay: Int = 350,
): Modifier =
    composed {
        var isInitialComposition by rememberSaveable { mutableStateOf(true) }

        val opacity by animateFloatAsState(
            targetValue = if (isInitialComposition) 0.0f else 1f,
            animationSpec = tween(
                durationMillis = 900,
                delayMillis = opacityDelay,
                easing = EaseInOutQuad
            ),
            label = "opacity"
        )

        val offsetY by animateDpAsState(
            targetValue = if (isInitialComposition) (-30).dp else 0.dp,
            animationSpec = tween(
                durationMillis = 1200,
                delayMillis = transitionDelay,
                easing = EaseInOutQuad
            ),
            label = "offset"
        )

        LaunchedEffect(Unit) {
            isInitialComposition = false
        }

        Modifier
            .alpha(opacity)
            .offset(y = offsetY)
    }

