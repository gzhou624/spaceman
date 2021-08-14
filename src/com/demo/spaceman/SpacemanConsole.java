package com.demo.spaceman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class SpacemanConsole {
    private Reader reader;
    private Writer writer;
    Spaceman game;

    public SpacemanConsole(Spaceman game){
        this.game = game;
        reader = new InputStreamReader(System.in);
        writer = new PrintWriter(System.out);

    }

    public void runGame(){
	    game.play(this);
    }

    protected void displayCurrentStatus(){
        GameStatus status = game.getGameStatus();
        if (GameStatus.IN_PROGRESS.equals(status)){
            writeMessage(game.getMaskedWord());
            writeMessage("What is your next guess (you have " + game.getNumberOfIncorrectGuessesRemaining() + " of incorrect guesses remaining)?");
        }else if (GameStatus.LOST.equals(status)){
            writeMessage("Sorry you lost!");
            writeMessage("The word was " + game.getWord());
        }else if (GameStatus.WON.equals(status)){
            writeMessage("You are a winner!");
        }
    }

    protected void writeMessage(String message){
        try{
            getWriter().write(message);
            getWriter().write("\n");
            getWriter().flush();
        }catch(IOException ioe){
            //No output
        }
    }

    protected String getInput(){
      BufferedReader br = new BufferedReader(getReader());
      String input = null;
      try {
         while ((input = br.readLine()) == null || input.equals("")) { // while loop begins here
	          System.out.println("Please enter a letter!!");
	      }
      } catch (IOException ioe) {
         System.out.println("IO error trying to read your character!");
         System.exit(1);
      }
      return input;
    }
    
    public char takeGuess() {
	    return getInput().toLowerCase().charAt( 0 );
	}

    public Reader getReader(){
        return reader;
    }

    public void setReader(Reader reader){
        this.reader = reader;
    }

    public Writer getWriter(){
        return writer;
    }

    public void setWriter(Writer writer){
        this.writer = writer;
    }

    public static void main(String[] args){
        if (args.length < 2){
            throw new RuntimeException("Usage: Spaceman.class word numberOfWrongGuesses");
        }
        String word = args[0];
        int numberOfIncorrectGuesses = Integer.parseInt(args[1]);
        SpacemanConsole console = new SpacemanConsole(new SpacemanEngine(word, numberOfIncorrectGuesses));
        console.runGame();
    }
}
