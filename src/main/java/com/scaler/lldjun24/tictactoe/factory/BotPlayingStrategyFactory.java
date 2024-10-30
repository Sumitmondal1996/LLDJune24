package com.scaler.lldjun24.tictactoe.factory;

import com.scaler.lldjun24.tictactoe.models.BotDifficultyLevel;
import com.scaler.lldjun24.tictactoe.strategy.botplayingstrategy.BotPlayingStrategy;
import com.scaler.lldjun24.tictactoe.strategy.botplayingstrategy.EasyBotPlayingStrategy;
import com.scaler.lldjun24.tictactoe.strategy.botplayingstrategy.HardBotPlayingStrategy;
import com.scaler.lldjun24.tictactoe.strategy.botplayingstrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyFactory(BotDifficultyLevel difficultyLevel)
    {
        if(difficultyLevel== BotDifficultyLevel.EASY)
        {
            return new EasyBotPlayingStrategy();
        }
        else if(difficultyLevel==BotDifficultyLevel.MEDIUM)
        {
            return  new MediumBotPlayingStrategy();
        }
        else if(difficultyLevel== BotDifficultyLevel.HARD)
        {
            return new HardBotPlayingStrategy();
        }
        return null;
    }
}
