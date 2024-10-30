package com.scaler.lldjun24.tictactoe.strategy.botplayingstrategy;

import com.scaler.lldjun24.tictactoe.models.Board;
import com.scaler.lldjun24.tictactoe.models.Move;

public interface BotPlayingStrategy {
    Move makemove(Board board);
}
