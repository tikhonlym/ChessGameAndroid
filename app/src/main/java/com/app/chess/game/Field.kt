package com.app.chess.game

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.chess.game.ui.theme.BoardColor
import com.app.chess.game.ui.theme.DarkPlayerFigureColor
import com.app.chess.game.ui.theme.GreenFieldColor
import com.app.chess.game.ui.theme.WhiteFieldColor
import com.app.chess.game.ui.theme.WhitePlayerFigureColor


@Composable
fun Field(
    modifier: Modifier = Modifier,
    game: ChessGame,
) {
    val cells = List(64) { index ->
        if ((index / 8 + index % 8) % 2 == 0) WhiteFieldColor else GreenFieldColor
    }
    Column {

        WoodPiece()

        Layout(
            content = {
                cells.forEachIndexed { index, color ->
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(color)
                    ) {
                        val state = game.fieldsState[index]
                        var offset by remember { mutableStateOf(Offset(0f, 0f)) }
                        var animOffset by remember { mutableStateOf(0f) }
                        val animatedOffset by animateDpAsState(
                            targetValue = if (animOffset > 0f) 10.dp else 0.dp,
                            animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
                        )

                        Text(
                            text = state.figure.text,
                            modifier = Modifier
                                .align(Alignment.Center)
                                .graphicsLayer {
                                    translationY = animatedOffset.toPx() + offset.y
                                    translationX = offset.x
                                }
                                .pointerInput(Unit) {
                                    detectTransformGestures { _, pan, zoom, _ ->
                                        // Use pan to move the element
                                        offset = Offset(
                                            offset.x + pan.x,
                                            offset.y + pan.y
                                        )
                                    }
                                    detectTapGestures(
                                        onPress = {
                                            animOffset = 10f
                                            awaitRelease()
                                            animOffset = 0f
                                        }
                                    )
                                },
                            fontSize = 40.sp,
                            color = if (state.player == Player.DarkPlayer) DarkPlayerFigureColor else WhitePlayerFigureColor
                        )
                    }
                }
            },
            modifier = modifier
        ) { measurables, constraints ->
            val cellSize = constraints.maxWidth / 8
            val totalHeight = cellSize * 8
            layout(constraints.maxWidth, totalHeight) {
                measurables.forEachIndexed { index, measurable ->
                    val row = index / 8
                    val col = index % 8
                    val x = col * cellSize
                    val y = row * cellSize
                    val placeable = measurable.measure(
                        constraints.copy(
                            minWidth = cellSize,
                            minHeight = cellSize,
                            maxWidth = cellSize,
                            maxHeight = cellSize
                        )
                    )
                    placeable.placeRelative(x, y)
                }
            }
        }

        WoodPiece()
    }
}

@Composable
fun WoodPiece(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .fillMaxWidth()
            .height(16.dp)
            .background(color = BoardColor)
    )
}

@Preview
@Composable
private fun FieldPreview() {
    Field(
        game = ChessGame()
    )
}

