package com.zenon.bowlingapp.util.io;

import com.zenon.bowlingapp.domain.Roll;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static com.zenon.bowlingapp.util.Constants.FOUL_CHAR;
import static com.zenon.bowlingapp.util.Constants.FOUL_INT;

public class FileParser {


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

