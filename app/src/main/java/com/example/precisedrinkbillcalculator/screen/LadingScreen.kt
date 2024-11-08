package com.example.precisedrinkbillcalculator.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.precisedrinkbillcalculator.common.animateOpacityAndTransitionY

@Composable
fun LandingScreen(modifier: Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Heading()
        Spacer(modifier = Modifier.weight(1f))
        StartButton()
    }
}

@Composable
fun Heading(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(start = 40.dp, top = 50.dp)
    ) {
        Text("정밀한 술값을", modifier = Modifier.animateOpacityAndTransitionY(), style = TextStyle(
            fontSize = MaterialTheme.typography.displaySmall.fontSize,
        ))
        Spacer(modifier = Modifier.padding(vertical = 4.dp))
        Text(
            "계산 해 보세요", style = TextStyle(
                fontSize = MaterialTheme.typography.displayMedium.fontSize
            ), modifier = Modifier.animateOpacityAndTransitionY(transitionDelay = 650, opacityDelay = 1300)
        )

    }
}

@Composable
fun StartButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp)
            .animateOpacityAndTransitionY(
                opacityDelay = 1700,
                transitionDelay = 900
            )
    ) {
        Text("시작하기")
    }
}
