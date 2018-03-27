package com.zenon.bowlingapp;

import com.zenon.bowlingapp.scoring.FileParser;
import com.zenon.bowlingapp.scoring.GameBuilder;
import com.zenon.bowlingapp.scoring.GameCalculator;
import junit.framework.TestCase;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GameCalculatorTest extends TestCase {

    public void testRegularGameCalculations() {


        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("game.txt").getFile());

        FileParser fp = new FileParser();

        HashMap<String, ArrayList<Roll>> allPlayersAndRolls = new HashMap<>();

        try {
            allPlayersAndRolls = fp.parseGameFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Game> allGames = GamesBuilder.buildGame(allPlayersAndRolls);


        ArrayList<Frame> framesJeff = allGames.get(0).getAllFrames();

        assertTrue(framesJeff.get(0).getTotalScore() == 20);
        assertTrue(framesJeff.get(1).getTotalScore() == 39);
        assertTrue(framesJeff.get(2).getTotalScore() == 48);
        assertTrue(framesJeff.get(3).getTotalScore() == 66);
        assertTrue(framesJeff.get(4).getTotalScore() == 74);
        assertTrue(framesJeff.get(5).getTotalScore() == 84);
        assertTrue(framesJeff.get(6).getTotalScore() == 90);
        assertTrue(framesJeff.get(7).getTotalScore() == 120);
        assertTrue(framesJeff.get(8).getTotalScore() == 148);
        assertTrue(framesJeff.get(9).getTotalScore() == 167);

        assertFalse(framesJeff.get(0).getFirstRoll().isFault());
        assertFalse(framesJeff.get(1).getFirstRoll().isFault());
        assertFalse(framesJeff.get(2).getFirstRoll().isFault());
        assertFalse(framesJeff.get(3).getFirstRoll().isFault());
        assertFalse(framesJeff.get(4).getFirstRoll().isFault());
        assertFalse(framesJeff.get(5).getFirstRoll().isFault());
        assertTrue(framesJeff.get(6).getFirstRoll().isFault());
        assertFalse(framesJeff.get(7).getFirstRoll().isFault());
        assertFalse(framesJeff.get(8).getFirstRoll().isFault());
        assertFalse(framesJeff.get(9).getFirstRoll().isFault());

        assertTrue(framesJeff.get(0).isStrike());
        assertTrue(framesJeff.get(1).isSpare());
        assertFalse(framesJeff.get(2).isSpare() || framesJeff.get(2).isSpare());
        assertTrue(framesJeff.get(3).isStrike());
        assertFalse(framesJeff.get(4).isSpare() || framesJeff.get(4).isSpare());
        assertTrue(framesJeff.get(5).isSpare());
        assertFalse(framesJeff.get(6).isSpare() || framesJeff.get(6).isSpare());
        assertTrue(framesJeff.get(7).isStrike());
        assertTrue(framesJeff.get(8).isStrike());
        assertTrue(framesJeff.get(9).isStrike());

        ArrayList<Frame> framesJohn = allGames.get(1).getAllFrames();

        assertTrue(framesJohn.get(0).getTotalScore() == 16);
        assertTrue(framesJohn.get(1).getTotalScore() == 25);
        assertTrue(framesJohn.get(2).getTotalScore() == 44);
        assertTrue(framesJohn.get(3).getTotalScore() == 53);
        assertTrue(framesJohn.get(4).getTotalScore() == 82);
        assertTrue(framesJohn.get(5).getTotalScore() == 101);
        assertTrue(framesJohn.get(6).getTotalScore() == 110);
        assertTrue(framesJohn.get(7).getTotalScore() == 124);
        assertTrue(framesJohn.get(8).getTotalScore() == 132);
        assertTrue(framesJohn.get(9).getTotalScore() == 151);

        assertFalse(framesJohn.get(0).getFirstRoll().isFault());
        assertFalse(framesJohn.get(1).getFirstRoll().isFault());
        assertFalse(framesJohn.get(2).getFirstRoll().isFault());
        assertFalse(framesJohn.get(3).getFirstRoll().isFault());
        assertFalse(framesJohn.get(4).getFirstRoll().isFault());
        assertFalse(framesJohn.get(5).getFirstRoll().isFault());
        assertFalse(framesJohn.get(6).getFirstRoll().isFault());
        assertFalse(framesJohn.get(7).getFirstRoll().isFault());
        assertFalse(framesJohn.get(8).getFirstRoll().isFault());
        assertFalse(framesJohn.get(9).getFirstRoll().isFault());

        assertTrue(framesJohn.get(0).isSpare());
        assertFalse(framesJohn.get(1).isStrike() || framesJohn.get(1).isSpare());
        assertTrue(framesJohn.get(2).isStrike());
        assertFalse(framesJohn.get(3).isStrike() || framesJohn.get(3).isSpare());
        assertTrue(framesJohn.get(4).isStrike());
        assertTrue(framesJohn.get(5).isStrike());
        assertFalse(framesJohn.get(6).isStrike() || framesJohn.get(6).isSpare());
        assertTrue(framesJohn.get(7).isSpare());
        assertFalse(framesJohn.get(8).isStrike() || framesJohn.get(8).isSpare());
        assertTrue(framesJohn.get(9).isStrike());
    }

    public void testAllStrikesGameCalculations() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("game_all_strikes.txt").getFile());

        FileParser fp = new FileParser();

        HashMap<String, ArrayList<Roll>> allPlayersAndRolls = new HashMap<>();

        try {
            allPlayersAndRolls = fp.parseGameFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Game> allGames = GamesBuilder.buildGame(allPlayersAndRolls);


        ArrayList<Frame> frames = allGames.get(0).getAllFrames();

        assertTrue(frames.get(0).getTotalScore() == 30);
        assertTrue(frames.get(1).getTotalScore() == 60);
        assertTrue(frames.get(2).getTotalScore() == 90);
        assertTrue(frames.get(3).getTotalScore() == 120);
        assertTrue(frames.get(4).getTotalScore() == 150);
        assertTrue(frames.get(5).getTotalScore() == 180);
        assertTrue(frames.get(6).getTotalScore() == 210);
        assertTrue(frames.get(7).getTotalScore() == 240);
        assertTrue(frames.get(8).getTotalScore() == 270);
        assertTrue(frames.get(9).getTotalScore() == 300);

        for(int i = 0; i < 10; i++){
            assertTrue(frames.get(i).isStrike());
            assertFalse(frames.get(i).isSpare());
            assertFalse(frames.get(i).getFirstRoll().isFault());
        }

    }

    public void testAllFaultsGameCalculations() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("game_all_faults.txt").getFile());

        FileParser fp = new FileParser();

        HashMap<String, ArrayList<Roll>> allPlayersAndRolls = new HashMap<>();

        try {
            allPlayersAndRolls = fp.parseGameFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Game> allGames = GamesBuilder.buildGame(allPlayersAndRolls);


        ArrayList<Frame> frames = allGames.get(0).getAllFrames();

        assertTrue(frames.get(0).getTotalScore() == 0);
        assertTrue(frames.get(1).getTotalScore() == 0);
        assertTrue(frames.get(2).getTotalScore() == 0);
        assertTrue(frames.get(3).getTotalScore() == 0);
        assertTrue(frames.get(4).getTotalScore() == 0);
        assertTrue(frames.get(5).getTotalScore() == 0);
        assertTrue(frames.get(6).getTotalScore() == 0);
        assertTrue(frames.get(7).getTotalScore() == 0);
        assertTrue(frames.get(8).getTotalScore() == 0);
        assertTrue(frames.get(9).getTotalScore() == 0);

        for(int i = 0; i < 10; i++){
            assertFalse(frames.get(i).isStrike());
            assertFalse(frames.get(i).isSpare());
            assertTrue(frames.get(i).getFirstRoll().isFault());
            assertTrue(frames.get(i).getSecondRoll().isFault());
        }

    }

}
