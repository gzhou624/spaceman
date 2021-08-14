package com.demo.spaceman;

public class LetterBox {
	  private char[] lbox = new char[24];
	  private int counter = 0;

	  public boolean contains( char c ) {
	    for( int i = 0; i < counter; i++ ) {
	      if( lbox[i] == c )
	        return true;
	    }
	    lbox[counter] = c;
	    counter++;
	    return false;
	  }

	  public void print() {
	    System.out.print( "\nWhat you've guessed so far:" );
	    for( int i = 0; i < counter; i++ ) {
	      System.out.print( lbox[i] );
	    }
	    System.out.println( "" );
	  }
	  
	  public String getLettersGuessed(){
		  StringBuffer sb = new StringBuffer();
		  for( int i = 0; i < counter; i++ ) {
		      System.out.print( lbox[i] );
		      sb.append(lbox[i]);
		  }
		  return sb.toString();
	  }
}
