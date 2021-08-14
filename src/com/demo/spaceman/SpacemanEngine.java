package com.demo.spaceman;

public class SpacemanEngine implements Spaceman {
    private String word;
    private int numberOfIncorrectGuesses;
    
    private HiddenKeyword hiddenKeyword;
	private LetterBox letterBox;
	
	private GameStatus status;

    public SpacemanEngine(String word, int numberOfIncorrectGuesses){
        this.word = word;
        this.numberOfIncorrectGuesses = numberOfIncorrectGuesses;
        hiddenKeyword = new HiddenKeyword(word);
	    letterBox = new LetterBox();
	    status = GameStatus.IN_PROGRESS;
    }

    public GuessResult guessLetter(String letter){
    	GuessResult result = hiddenKeyword.guess(letter.charAt(0));
    	if( result != GuessResult.GOOD_GUESS ) {
    		numberOfIncorrectGuesses--;
	    }
        checkstatus();
	        
	    return result;
    }

    public String getLettersGuessed() {
        return letterBox.getLettersGuessed();
    }

    public GameStatus getGameStatus(){
        return status;
    }
    
    public void setStatus(GameStatus status) {
		this.status = status;
	}

    public String getWord() {
        return word;
    }

    public String getMaskedWord(){
    	return hiddenKeyword.getMaskedWord();
    }

    public int getNumberOfIncorrectGuessesRemaining(){
    	return numberOfIncorrectGuesses;
    }

	@Override
	public void play(SpacemanConsole console) {

	    boolean bool = true;
	    setStatus(GameStatus.IN_PROGRESS);
	    while( true ) {
	      bool = true;
	      printState();
	      console.displayCurrentStatus();
	      char ch = console.takeGuess();
	      //you've already used letter..
	      if( letterBox.contains(ch) ) {
	        System.out.println( "Try again, you've already used letter " + ch + ". Guesses are treated case-insensitively.." );
	        bool = false;
	      }
	      
	      //keep guessing
	      if( bool ) {
	    	  guessLetter(String.valueOf(ch));
	      }
	    } 
		
	}

	public void checkstatus() {
		if( numberOfIncorrectGuesses < 1 )
		  gameOver();

		if( hiddenKeyword.found() )
		  congratulations();
	}
	
	  public void congratulations() {
		  setStatus(GameStatus.WON);
		  System.out.println( "Congratulations, you found the word: " + word);
	  }

	  public void gameOver() {
		  setStatus(GameStatus.LOST);
		  System.out.println( "Sorry, this time you lose!" );
	  }
	  
	  private void printState() {
	    letterBox.print();
//	    System.out.println("Hidden word--> " + hiddenKeyword.getMaskedWord());
	    System.out.println( "Tries left: " + numberOfIncorrectGuesses);
	    System.out.println( "Guess next letter -->" );
	  }
}
