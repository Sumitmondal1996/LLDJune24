package com.scaler.lldjun24.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size;
        board = new ArrayList<List<Cell>>();
        for(int i = 0; i < size; i++) {
            board.add(new ArrayList<>());// creating an empty board
            for(int j=0; j<size; j++)
            {
                board.get(i).add(new Cell(i, j));  //creating a cell obj
            }
        }
    }

    public void printboard()
    {
        for(List<Cell> row : board)
        {
            for(Cell cell : row)
            {
                if(cell.is_empty())
                {
                    System.out.print("|  |");
                }
                else
                {
                    System.out.print("| "+cell.getPlayer().getSymbol().getCh() + " | ");
                }
            }
            System.out.println();
        }

    }
}
