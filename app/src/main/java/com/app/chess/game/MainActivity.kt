package com.app.chess.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.chess.game.ui.theme.ChessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChessAppTheme {
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp)
                ) {
                    Field(
                        modifier = Modifier
                            .matchParentSize()
                            .align(Alignment.Center),
                        game = ChessGame()
                    )
                }
            }
        }
    }
}

