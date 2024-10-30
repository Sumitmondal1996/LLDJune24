package com.scaler.lldjun24.tictactoe.strategy.botplayingstrategy;

import com.scaler.lldjun24.tictactoe.models.Board;
import com.scaler.lldjun24.tictactoe.models.Cell;
import com.scaler.lldjun24.tictactoe.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makemove(Board board) {
        for(List<Cell> cells : board.getBoard())
        {
            for(Cell cell:cells)
            {
                if (cell.is_empty())
                {
                    return new Move(null, cell);
                }

            }
        }

        return null;
    }
}
