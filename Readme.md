Spaceman or hangman  
A command line spaceman game. A general description of how the game is played, can be found here. 

The game play requirements are as follows:

- The game is to be started from the command line.
- The user can specify the word to guess and the number of incorrect guesses that can be made before the game is over.
- The game has three states:  
    - LOST: The user has made too many incorrect guesses. There is no limit to the number of guesses a user can make, but they can make only a finite number of INCORRECT guesses.
    - WON: The user has guessed all the letters of the word before the game has reached the LOST state.
    - IN_PROGRESS: The user has neither WON nor LOST the game. 
  
- There is no limit on the number characters in the word.
- A user can only input a single alphabetical character at a time for their guess.
- The word will only contain characters, spaces, and hyphens. Spaces and hyphens should be displayed as is to the user (e.g. a user is not allowed to guess spaces or hyphens).
- The system will display the current status of the game. If the word is "CAT", at the start of the game, the display will show "***". 
As a user guesses letters correctly, the display will update. 
If the user guesses "C", the display will show "C**". 
If the user selects "Z", the display will continue to show "D**"
- Guesses are treated case-insensitively but the word to be guessed should always maintain its entered case when any portion of it is displayed. 
For example, if the word is "San Jose", and the user makes a first guess of 'A', "*a* ****" should be displayed.
If there are any input or validation errors, the system will provide useful feedback about that error to the user.