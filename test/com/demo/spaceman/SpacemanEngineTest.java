package com.demo.spaceman;

public class SpacemanEngineTest extends AbstractSpacemanTest {

    public void testGameWinning() throws Exception{
        SpacemanEngine spaceman = new SpacemanEngine("Google", 2);
        assertEquals("******", spaceman.getMaskedWord());
        testNonGameEndingGuess(spaceman, "g");
        testNonGameEndingGuess(spaceman, "o");
        testNonGameEndingGuess(spaceman, "l");
        testGameWinningGuess(spaceman, "e");
    }
    
    public void testGameLosing() throws Exception{
        SpacemanEngine spaceman = new SpacemanEngine("YouTube", 2);
        assertEquals("*******", spaceman.getMaskedWord());
        testNonGameEndingGuess(spaceman, "o");
        testNonGameEndingGuess(spaceman, "x");
        testGameLosingGuess(spaceman, "z");
    }
    
    public void testMask() throws Exception{
        SpacemanEngine spaceman = new SpacemanEngine("New York-City", 2);
        assertEquals("*** ****-****", spaceman.getMaskedWord());
        testNonGameEndingGuess(spaceman, "b");
        testGameLosingGuess(spaceman, "z");
    }

}
