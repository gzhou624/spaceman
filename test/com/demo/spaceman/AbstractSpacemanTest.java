package com.demo.spaceman;

import junit.framework.Assert;
import junit.framework.TestCase;

public abstract class AbstractSpacemanTest extends TestCase{

    protected void testInvalidLetter(Spaceman game, String letter) throws Exception{
    	GuessResult result = game.guessLetter(letter);
    	Assert.assertEquals(GuessResult.INVALID_LETTER, result);
    }

    protected void testAlreadyGuessedLetter(Spaceman game, String letter) throws Exception{
    	GuessResult result = game.guessLetter(letter);
    	Assert.assertEquals(GuessResult.ALREADY_GUESSED, result);
    }

    protected void testNonGameEndingGuess(Spaceman game, String letter) throws Exception{
    	game.guessLetter(letter);
        Assert.assertEquals(GameStatus.IN_PROGRESS, game.getGameStatus());
    }

    protected void testGameLosingGuess(Spaceman game, String letter) throws Exception{
    	game.guessLetter(letter);
        Assert.assertEquals(GameStatus.LOST, game.getGameStatus());
    }

    protected void testGameWinningGuess(Spaceman game, String letter) throws Exception{
    	game.guessLetter(letter);
        Assert.assertEquals(GameStatus.WON, game.getGameStatus());
    }

}
