package com.demo.spaceman;

public interface Spaceman {
    public GuessResult guessLetter(String letter);

    public String getLettersGuessed();

    public String getWord();

    public String getMaskedWord();

    public GameStatus getGameStatus();

    public int getNumberOfIncorrectGuessesRemaining();

	public void play(SpacemanConsole console);
}
