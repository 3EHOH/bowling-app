package com.zenon.bowlingapp.scoring;

import com.zenon.bowlingapp.Roll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class FileParser {

    public static final int FOUL_INT = -1;
    public static final char FOUL_CHAR = 'F';


    public  HashMap<String,ArrayList<Roll>> readScore() throws IOException {

        BufferedReader buf = null;

        try {
            buf = new BufferedReader(new FileReader("src/main/java/com/zenon/bowlingapp/game.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

            String lineJustFetched;
            String[] playerAndScoreArray;

            HashMap<String,ArrayList<Roll>> playerProfs = new HashMap<>();

            while(true){
                lineJustFetched = buf.readLine();

                if (lineJustFetched == null) {

                    break;

                } else {
                    playerAndScoreArray = lineJustFetched.split(" ");
                    String playerName = playerAndScoreArray[0];
                    int playerScore = ConvertIntoNumeric(playerAndScoreArray[1]);
                    Roll aRoll = new Roll(playerScore);

                    if (playerProfs.containsKey(playerName) ) {
                        ArrayList<Roll> playerScores = playerProfs.get(playerName);

                        playerScores.add(aRoll);
                        playerProfs.put(playerName, playerScores);
                    } else {
                        ArrayList<Roll> scores = new ArrayList<>();

                        scores.add(aRoll);
                        playerProfs.put(playerName, scores);
                    }

                }
            }


            buf.close();


            return playerProfs;

    }


    private static int ConvertIntoNumeric(String xVal)
    {

        if (xVal.charAt(0) == FOUL_CHAR) {
            return FOUL_INT;
        } else {
            return Integer.parseInt(xVal);
        }
    }

}

