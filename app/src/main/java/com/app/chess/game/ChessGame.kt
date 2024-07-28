package com.app.chess.game

class ChessGame() {

    var _fieldsState = emptyList<FieldState>()
    val fieldsState get() = _fieldsState

    init {
        _fieldsState = getInitialFieldState()
    }

    private fun getInitialFieldState(): List<FieldState> {
        val initialState = mutableListOf<FieldState>()
        for (index in 0..63) {
            when (index) {

                // FOR DARK PLAYER ---------------------------------------------------->

                // Pawn`s for DarkPlayer ♟
                in 48..55 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.DarkPlayer,
                            figure = ChessPieces.Pawn
                        )
                    )
                }

                // Rook for DarkPlayer ♜
                56 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.DarkPlayer,
                            figure = ChessPieces.Rook
                        )
                    )
                }
                63 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.DarkPlayer,
                            figure = ChessPieces.Rook
                        )
                    )
                }

                // Bishop for DarkPlayer ♝
                57 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.DarkPlayer,
                            figure = ChessPieces.Bishop
                        )
                    )
                }
                62 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.DarkPlayer,
                            figure = ChessPieces.Bishop
                        )
                    )
                }

                // Knight for DarkPlayer ♞
                58 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.DarkPlayer,
                            figure = ChessPieces.Knight
                        )
                    )
                }
                61 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.DarkPlayer,
                            figure = ChessPieces.Knight
                        )
                    )
                }

                // King for DarkPlayer ♚
                59 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.DarkPlayer,
                            figure = ChessPieces.King
                        )
                    )
                }

                // Queen for DarkPlayer ♛
                60 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.DarkPlayer,
                            figure = ChessPieces.Queen
                        )
                    )
                }

                // FOR WHITE PLAYER ---------------------------------------------------->

                // Pawn`s for WhitePlayer ♟
                in 8..15 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.WhitePlayer,
                            figure = ChessPieces.Pawn
                        )
                    )
                }
                // Rook for DarkPlayer ♜
                0 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.WhitePlayer,
                            figure = ChessPieces.Rook
                        )
                    )
                }
                7 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.WhitePlayer,
                            figure = ChessPieces.Rook
                        )
                    )
                }

                // Bishop for DarkPlayer ♝
                1 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.WhitePlayer,
                            figure = ChessPieces.Bishop
                        )
                    )
                }
                6 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.WhitePlayer,
                            figure = ChessPieces.Bishop
                        )
                    )
                }

                // Knight for DarkPlayer ♞
                2 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.WhitePlayer,
                            figure = ChessPieces.Knight
                        )
                    )
                }
                5 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.WhitePlayer,
                            figure = ChessPieces.Knight
                        )
                    )
                }

                // King for DarkPlayer ♚
                3 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.WhitePlayer,
                            figure = ChessPieces.King
                        )
                    )
                }

                // Queen for DarkPlayer ♛
                4 -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.WhitePlayer,
                            figure = ChessPieces.Queen
                        )
                    )
                }

                else -> {
                    initialState.add(
                        createFieldByParams(
                            player = Player.NoPlayerEmptyField,
                            figure = ChessPieces.NoFigure
                        )
                    )
                }
            }
        }
        return initialState
    }

    private fun createFieldByParams(player: Player, figure: ChessPieces): FieldState {
        return FieldState(figure = figure, player = player)
    }
}

data class FieldState(
    val figure: ChessPieces,
    val player: Player,
)

enum class Player {
    WhitePlayer, DarkPlayer, NoPlayerEmptyField
}