package com.scaler.lldjun24.tictactoe;

import com.scaler.lldjun24.tictactoe.controller.GameController;
import com.scaler.lldjun24.tictactoe.exceptions.InvalidPlayerCountException;
import com.scaler.lldjun24.tictactoe.exceptions.MultipleBotExcption;
import com.scaler.lldjun24.tictactoe.exceptions.SameSymbolException;
import com.scaler.lldjun24.tictactoe.models.*;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import static com.scaler.lldjun24.tictactoe.models.BotDifficultyLevel.EASY;
import static com.scaler.lldjun24.tictactoe.models.PlayerType.BOT;
import static com.scaler.lldjun24.tictactoe.models.PlayerType.HUMAN;

public class Tictactoe {
    public static void main(String[] args) throws MultipleBotExcption, InvalidPlayerCountException, SameSymbolException {
        System.out.println("Welcome to Tictactoe!");
        System.out.println("Give the dimension: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        GameController gameController= new GameController();
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(
                new Player("Sumit", 1L, new Symbol('x'), HUMAN)
        );
        players.add(
                new Bot("Rambo", 2L, new Symbol('o'), BOT, EASY)
        );

        Game game = gameController.startGame(size, players);
        gameController.displayboard(game);

        while(game.getGamestate() == Gamestate.IN_PROG)
        {

            //gameController.makeMove(game);
            game.makemove(game.getBoard());
            gameController.displayboard(game);

        }
        if(game.getGamestate()== Gamestate.DRAWN)
        {
            System.out.println("Game has drawn");
        }
        else
        {
            System.out.println(game.getWinner().getName() +" has won the game");
        }
    }
}
