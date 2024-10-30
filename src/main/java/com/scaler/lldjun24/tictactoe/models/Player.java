package com.scaler.lldjun24.tictactoe.models;

import java.util.Scanner;

public class    Player {
    private String name;
    public Long id;
    private Symbol symbol;
    public PlayerType playerType;
    public Scanner scanner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Player(String name, Long id, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.playerType = playerType;
        scanner = new Scanner(System.in);
    }

    public Move makemove(Board board)
    {
        System.out.println("Please enter row where you want to make the move: ");
        int row = scanner.nextInt();
        System.out.println("Please enter col where you want to make the move: ");
        int col = scanner.nextInt();
        Cell cell = board.getBoard().get(row).get(col);

        return new Move(this, new Cell(row, col));

    }
}
