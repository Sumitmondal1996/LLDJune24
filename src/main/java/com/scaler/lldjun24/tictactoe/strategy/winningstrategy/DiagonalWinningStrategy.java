package com.scaler.lldjun24.tictactoe.strategy.winningstrategy;

import com.scaler.lldjun24.tictactoe.models.Board;
import com.scaler.lldjun24.tictactoe.models.Move;
import com.scaler.lldjun24.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy{
    Map<Symbol, Integer> leftDiagMap = new HashMap<>();
    Map<Symbol, Integer> rightDiagMap = new HashMap<>();


    @Override
    public boolean checkwinner(Board board, Move move) {
        int row= move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol sym = move.getPlayer().getSymbol();

        if(row==col)
        {
            // the move is on the left diagnoal
            int freq = leftDiagMap.getOrDefault(sym,0);
            leftDiagMap.put(sym,freq+1);

        }
        if(row+col == board.getSize()-1)
        {
            // right diagonal
            int freq = rightDiagMap.getOrDefault(sym,0);
            rightDiagMap.put(sym, freq+1);
        }
        //return  (leftDiagMap.get(sym)== board.getSize()) || (rightDiagMap.get(sym)== board.getSize());
        if(leftDiagMap.containsKey(sym) && leftDiagMap.get(sym)== board.getSize())
        {
            return true;
        }

        if(rightDiagMap.containsKey(sym) && rightDiagMap.get(sym)== board.getSize())
        {
            return true;
        }
        return false;
    }
}
