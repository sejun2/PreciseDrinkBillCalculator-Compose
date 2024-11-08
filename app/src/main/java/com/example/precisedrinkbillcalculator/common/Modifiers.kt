package com.example.precisedrinkbillcalculator.common

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInOutQuad
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

fun Modifier.animateOpacityAndTransitionY(
    opacityDelay: Int = 900,
    transitionDelay: Int = 350,
): Modifier =
    composed {
        val opacityAnimatable = rememberSaveable(
            saver = mapSaver(
                save = {
                    mapOf(
                        "opacity" to it.value
                    )
                },
                restore = {
                    Animatable(initialValue = 1.0f)
                }
            )
        ) {
            Animatable(
                initialValue = 0.0f,
            )
        }

        val transitionYAnimatable = rememberSaveable(
            saver = mapSaver(
                save = {
                    mapOf(
                        "transitionY" to it.value
                    )
                },
                restore = {
                    Animatable(initialValue = 0.0f)
                }
            )
        ) {
            Animatable(
                initialValue = -25f,
            )
        }

        LaunchedEffect(Unit) {
            launch {
                transitionYAnimatable.animateTo(
                    0f, animationSpec = TweenSpec(
                        delay = transitionDelay,
                        durationMillis = 1200,
                        easing = EaseInOutQuad
                    )
                )
            }
            launch {
                opacityAnimatable.animateTo(
                    1f, animationSpec = TweenSpec(
                        delay = opacityDelay,
                        durationMillis = 900,
                        easing = EaseInOutQuad
                    )
                )
            }
        }

        Modifier
            .alpha(opacityAnimatable.value)
            .offset(y = transitionYAnimatable.value.dp)
    }

