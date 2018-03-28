package com.zenon.bowlingapp;

import com.zenon.bowlingapp.domain.game.Game;
import com.zenon.bowlingapp.domain.roll.Roll;
import com.zenon.bowlingapp.io.FileParser;
import com.zenon.bowlingapp.util.FileParserTestUtil;
import junit.framework.TestCase;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

public class FileParserTest extends TestCase {

    public void testValidFile() throws Exception {

        File file = new File("src/test/resources/game.txt");

        FileParser fp = new FileParser();
        HashMap<String, ArrayList<Roll>> allPlayersAndRolls = new HashMap<>();

        try {
            allPlayersAndRolls = fp.parseGameFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertTrue(allPlayersAndRolls.containsKey("Jeff"));
        assertTrue(allPlayersAndRolls.containsKey("John"));
        assertTrue(allPlayersAndRolls.size() == 2);
        assertTrue(allPlayersAndRolls.get("Jeff").size() == 17);
        assertTrue(allPlayersAndRolls.get("John").size() == 18);

    }

    public void testInvalidFile() throws Exception {
        File file = new File("src/test/resources/game_invalid.txt");

        FileParser fp = new FileParser();
        HashMap<String, ArrayList<Roll>> allPlayersAndRolls = new HashMap<>();

        try {
            allPlayersAndRolls = fp.parseGameFile(file);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(e.getMessage().contains("Invalid file input"));
        }
    }
}
