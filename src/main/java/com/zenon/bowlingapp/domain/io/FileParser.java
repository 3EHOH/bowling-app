package com.zenon.bowlingapp.domain.io;

import com.zenon.bowlingapp.domain.Roll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class FileParser {


    //TODO MOVE THIS AND THE CONVERSION LOGIC INTO ITS OWN ROLL PARSER CLASS
    private static final int FOUL_INT = -1;
    private static final char FOUL_CHAR = 'F';

    //TODO RENAME TO createGameProfile or something
    public HashMap<String, ArrayList<Roll>> parseGameFile(File file) throws Exception {

        BufferedReader buf = null;

        try {
            buf = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String lineJustFetched;
        String[] playerAndScoreArray;

        HashMap<String, ArrayList<Roll>> gameProfiles = new HashMap<>();

        while (true) {
            lineJustFetched = buf.readLine();

            if (lineJustFetched == null) {
                break;
            } else if (!isValidInput(lineJustFetched)) {
                throw new Exception("Invalid file input");
            } else {
                playerAndScoreArray = lineJustFetched.split(" ");
                String playerName = playerAndScoreArray[0];
                int playerScore = ConvertIntoNumeric(playerAndScoreArray[1]);
                Roll aRoll = new Roll(playerScore);

                if (gameProfiles.containsKey(playerName)) {
                    ArrayList<Roll> playerScores = gameProfiles.get(playerName);

                    playerScores.add(aRoll);
                    gameProfiles.put(playerName, playerScores);
                } else {
                    ArrayList<Roll> scores = new ArrayList<>();

                    scores.add(aRoll);
                    gameProfiles.put(playerName, scores);
                }
            }
        }
        buf.close();

        return gameProfiles;
    }


    private static int ConvertIntoNumeric(String bowlingRoll) {

        if (bowlingRoll.charAt(0) == FOUL_CHAR) {
            return FOUL_INT;
        } else {
            return Integer.parseInt(bowlingRoll);
        }
    }

    private static boolean isValidInput(String fileLine) {
        return fileLine.split(" ").length == 2;
    }
}

