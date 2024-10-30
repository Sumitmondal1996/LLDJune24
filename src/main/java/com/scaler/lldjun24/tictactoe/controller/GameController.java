package com.scaler.lldjun24.tictactoe.controller;

import com.scaler.lldjun24.tictactoe.exceptions.InvalidPlayerCountException;
import com.scaler.lldjun24.tictactoe.exceptions.MultipleBotExcption;
import com.scaler.lldjun24.tictactoe.exceptions.SameSymbolException;
import com.scaler.lldjun24.tictactoe.models.Game;
import com.scaler.lldjun24.tictactoe.models.Gamestate;
import com.scaler.lldjun24.tictactoe.models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int size, List<Player> players) throws MultipleBotExcption, InvalidPlayerCountException, SameSymbolException {

        return Game.getBuilder()
                .setSize(size)
                .setPlayers(players)
                .build();
    }

    public void makeMove(Game game)
    {
       // game.makemove();

    }

    public Player checkWinner(Game game, List<Player> players)
    {
        return null;
    }
    public void undo(Game game)
    {
        return;
    }
    public void displayboard(Game game)
    {
        game.getBoard().printboard();

    }

    public Gamestate getGameState(Game game)
    {
        return  game.getGamestate();
    }


}
