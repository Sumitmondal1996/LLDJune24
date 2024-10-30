package com.scaler.lldjun24.tictactoe.models;

import com.scaler.lldjun24.tictactoe.exceptions.InvalidPlayerCountException;
import com.scaler.lldjun24.tictactoe.exceptions.MultipleBotExcption;
import com.scaler.lldjun24.tictactoe.exceptions.SameSymbolException;
import com.scaler.lldjun24.tictactoe.strategy.winningstrategy.ColumnWinningStrategy;
import com.scaler.lldjun24.tictactoe.strategy.winningstrategy.DiagonalWinningStrategy;
import com.scaler.lldjun24.tictactoe.strategy.winningstrategy.RowWinningStrategy;
import com.scaler.lldjun24.tictactoe.strategy.winningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class  Game {
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public Gamestate getGamestate() {
        return gamestate;
    }

    public void setGamestate(Gamestate gamestate) {
        this.gamestate = gamestate;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    private Board board;
    private List<Player> players;
    private Player winner;
    private int nextPlayerMoveIndex;
    private Gamestate gamestate;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;


    private Game(int dimension, List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.nextPlayerMoveIndex = 0;
        this.moves = new ArrayList<Move>();
        gamestate = Gamestate.IN_PROG;
        winningStrategies= List.of(new ColumnWinningStrategy(), new RowWinningStrategy(), new DiagonalWinningStrategy());
    }

    public static Builder getBuilder()
    {
        return new Builder();
    }



    public static class Builder
    {
        private int size;
        private List<Player> players;

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public int getSize() {
            return size;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Game build() throws InvalidPlayerCountException, SameSymbolException, MultipleBotExcption {
            //Validations
            validategame(size, players);
            return new Game(size, players);
        }
        private void validategame(int size, List<Player> players) throws InvalidPlayerCountException, SameSymbolException, MultipleBotExcption {
            validatecount(size, players);
            validateuniquesymbols(players);
            validatebotcount(players);

        }
        private void validatecount(int size,List<Player> players) throws InvalidPlayerCountException {
            if(players.size() != size-1)
            {
                throw new InvalidPlayerCountException("Invalid player count");

            }


        }
        private void validateuniquesymbols(List<Player> players) throws SameSymbolException {
            HashSet<Character> hssym = new HashSet<>();
            for(Player player: players)
            {
                if(hssym.contains(player.getSymbol().getCh()))
                {
                    throw new SameSymbolException("No two players can have same symbol");
                }
                hssym.add(player.getSymbol().getCh());
            }

        }

        private void validatebotcount(List<Player> players) throws MultipleBotExcption {
            int botcount=0;
            for(Player player: players)
            {
                if(player.getPlayerType().equals(PlayerType.BOT))
                {
                    botcount++;
                }

            }
            if(botcount>1)
            {
                throw new MultipleBotExcption("Only one bot is allowed");
            }
        }




    }

    public void makemove(Board board)
    {
        Player currplayer = players.get(nextPlayerMoveIndex);
        System.out.println(currplayer.getName() + "'s move");
        Move move = currplayer.makemove(board);
        if(!validatemove(move, board))
        {
            System.out.println("Filled or Wrong cell");
            gamestate= Gamestate.ENDED;
        }

        //place the move in cell
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setPlayer(currplayer);
        cell.setCellState(CellState.FILLED);

        Move finalmove = new Move(currplayer, cell);
        moves.add(finalmove);

        //check the winner
        if(checkWinner(board,finalmove))
        {
            winner= currplayer;
            gamestate= Gamestate.ENDED;

        }

        else if(moves.size()== board.getSize()* board.getSize())
        {
            gamestate= Gamestate.DRAWN;
        }
        nextPlayerMoveIndex+=1;
        nextPlayerMoveIndex%=players.size();

    }

    public boolean  validatemove(Move move, Board board)
    {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cell = board.getBoard().get(row).get(col);
        return cell.is_empty()&&row>=0&&col>=0&&row<board.getSize()&&col<board.getSize();
    }

    public boolean checkWinner(Board board, Move move)
    {
        for(WinningStrategy winningStrategy: winningStrategies)
        {
            if(winningStrategy.checkwinner(board,move))
            {
                winner= players.get(nextPlayerMoveIndex);
                return true;
            }

        }

        return false;
    }
}
