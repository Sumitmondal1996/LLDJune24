package com.scaler.lldjun24.tictactoe.models;

import com.scaler.lldjun24.tictactoe.factory.BotPlayingStrategyFactory;
import com.scaler.lldjun24.tictactoe.strategy.botplayingstrategy.BotPlayingStrategy;
import com.scaler.lldjun24.tictactoe.strategy.botplayingstrategy.EasyBotPlayingStrategy;

public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;
    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }



    public Bot(String name, Long id, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(name, id, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategyFactory(botDifficultyLevel);


    }

    @Override
    public Move makemove(Board board) { // overriding this behaviour so that it doesn't depend on the human playing strategy
        Move botmove = botPlayingStrategy.makemove(board);
        botmove.setPlayer(this);
        return botmove;
    }


}
