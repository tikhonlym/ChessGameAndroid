package com.app.chess.game

enum class ChessPieces(val text: String) {
    Pawn(text = "♟"),
    Rook(text = "♜"),
    Knight(text = "♞"),
    Bishop(text = "♝"),
    Queen(text = "♛"),
    King(text = "♚"),
    NoFigure(text = ""),
}