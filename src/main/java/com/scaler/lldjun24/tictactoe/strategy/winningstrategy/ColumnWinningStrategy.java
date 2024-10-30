package com.scaler.lldjun24.tictactoe.strategy.winningstrategy;

import com.scaler.lldjun24.tictactoe.models.Board;
import com.scaler.lldjun24.tictactoe.models.Move;
import com.scaler.lldjun24.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy{

    Map<Integer, Map<Symbol, Integer>> colMap = new HashMap<>();


    @Override
    public boolean checkwinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol sym = move.getPlayer().getSymbol();
        if(!colMap.containsKey(col))
        {
            Map<Symbol, Integer> internalrowmap = new HashMap<>();
            internalrowmap.put(sym, 1);
            colMap.put(col, internalrowmap);
        }
        else {
            Map<Symbol, Integer> internalrowmap = colMap.get(col);
            //Now check if the symbol is present in internalrowmap:

            int freq = internalrowmap.getOrDefault(sym,0);
            internalrowmap.put(sym, freq+1);
            colMap.put(col, internalrowmap);
        }

        // Now check the check rowwise for Row-wise-winner:

        Map<Symbol, Integer> integerMap = colMap.get(col);
        if(integerMap.get(sym)==board.getSize())
        {
            return true;
        }
        return false;
    }
}
