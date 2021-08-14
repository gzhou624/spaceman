package com.demo.spaceman;

public class HiddenKeyword {
	  private String fValue;
	  private StringBuffer pValue;
	  private int lfoundNumber = 0;
	  
	  public HiddenKeyword(String theWord) {
	    fValue = new String(theWord);
	    pValue = new StringBuffer(initializeMask(theWord));
	  }


	  public boolean found() {
	    System.out.println( "Letters found:" + lfoundNumber + "/" + fValue.length() );
	    return ( lfoundNumber == fValue.length() );
	  }

	  public GuessResult guess( char c ) {
	    int index = fValue.toLowerCase().indexOf( c );
	    if( index == -1 )
	      return GuessResult.BAD_GUESS;
	    else {
	      lfoundNumber = lfoundNumber + findOccurances( c );
	      return GuessResult.GOOD_GUESS;
	    }
	  }

	  private int findOccurances( char c ) {
	    int idx = fValue.toLowerCase().indexOf( c );
	    pValue.setCharAt( idx, fValue.charAt( idx ) );
	    int counter = 1;
	    while( idx != -1 ) {
	      int idxx = fValue.toLowerCase().indexOf( c, idx + 1 );
	      idx = idxx;
	      if( idx != -1 ) {
	        counter++;
	        pValue.setCharAt( idx, fValue.charAt( idx ) );
	      }
	    }
	    return counter;
	  }

	  public String getMaskedWord(){
		  return pValue.toString();
	  }
	  
		public String initializeMask(String theWord) {
			char[] chars = theWord.toCharArray();
			StringBuffer sb = new StringBuffer();
		    for (int i=0; i<chars.length; i++){
		    	if(chars[i] == ' ' || chars[i] == '-'){
		    		sb.append(String.valueOf(chars[i]));	
		    	}else{
		    		sb.append("*");
		    	}
		    	
		    }
			return sb.toString();
		}

}
