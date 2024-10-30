package com.scaler.lldjun24.tictactoe.strategy.winningstrategy;

import com.scaler.lldjun24.tictactoe.models.Board;
import com.scaler.lldjun24.tictactoe.models.Move;
import com.scaler.lldjun24.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{

    Map<Integer, Map<Symbol, Integer>> rowMap = new HashMap<>();


    @Override
    public boolean checkwinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Symbol sym = move.getPlayer().getSymbol();
        if(!rowMap.containsKey(row))
        {
            Map<Symbol, Integer> internalrowmap = new HashMap<>();
            internalrowmap.put(sym, 1);
            rowMap.put(row, internalrowmap);
        }
        else {
            Map<Symbol, Integer> internalrowmap = rowMap.get(row);
            //Now check if the symbol is present in internalrowmap:

            int freq = internalrowmap.getOrDefault(sym,0);
            internalrowmap.put(sym, freq+1);
            rowMap.put(row, internalrowmap);
        }

        // Now check the check rowwise for Row-wise-winner:

        Map<Symbol, Integer> integerMap = rowMap.get(row);
        if(integerMap.get(sym)==board.getSize())
        {
            return true;
        }
        return false;
    }
}
