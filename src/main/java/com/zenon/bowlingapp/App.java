package com.zenon.bowlingapp;


import com.zenon.bowlingapp.domain.Game;
import com.zenon.bowlingapp.util.io.FileParser;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;


public class App {

    public static void main( String[] args ) {

        FileParser fp = new FileParser();

        HashMap<String, ArrayList<Integer>> allPlayersAndScores;

        try {
            allPlayersAndScores = fp.readScore();

//            Map.Entry<String, ArrayList<Integer>> entry = allPlayersAndScores.entrySet().iterator().next();

            for (Object o : allPlayersAndScores.entrySet()) {
                Map.Entry pair = (Map.Entry) o;
                System.out.println(pair.getKey() + " = " + pair.getValue());

                String bowlerName = pair.getKey().toString();
                ArrayList<Integer> rolls = (ArrayList<Integer>) pair.getValue();

                Game aGame = new Game(bowlerName, rolls);

                String listString = "";

                for (int s : aGame.getBowlerRolls()){
                    listString += Integer.toString(s) + " ";
                }


                System.out.println(aGame.getBowler() + " " + listString);
//                it.remove(); // avoids a ConcurrentModificationException
            }

        } catch (Exception e) {

            e.printStackTrace();
        }



    }

    static class PlayerProfile {

        String playerName;
        List<Integer> playerScores;

        public PlayerProfile(String name) {
            this.playerName = name;
            this.playerScores = Collections.emptyList();
        }


    }


//    HashMap<String, ArrayList<Integer>> playerProf = new HashMap<String, ArrayList<Integer>>();
//
//    public synchronized void addToList(String mapKey, Integer myItem) {
//        ArrayList<Integer> itemsList = playerProf.get(mapKey);
//
//        // if list does not exist create it
//        if(itemsList == null) {
//            itemsList = new ArrayList<Integer>();
//            itemsList.add(myItem);
//            playerProf.put(mapKey, itemsList);
//        } else {
//            // add if item is not already in list
//            if(!itemsList.contains(myItem)) itemsList.add(myItem);
//        }
//    }
}
