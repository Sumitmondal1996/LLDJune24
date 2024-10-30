package com.scaler.lldjun24.tictactoe.strategy.winningstrategy;

import com.scaler.lldjun24.tictactoe.models.Board;
import com.scaler.lldjun24.tictactoe.models.Move;

public interface WinningStrategy {
    boolean checkwinner(Board board, Move move);
}
