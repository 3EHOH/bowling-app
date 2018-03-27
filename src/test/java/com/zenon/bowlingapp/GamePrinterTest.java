//package com.zenon.bowlingapp;
//
//import com.zenon.bowlingapp.scoring.FileParser;
//import com.zenon.bowlingapp.scoring.FrameBuilder;
//import com.zenon.bowlingapp.scoring.GameCalculator;
//import junit.framework.TestCase;
//import org.junit.After;
//import org.junit.Before;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class GamePrinterTest extends TestCase {
//
//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
//
//    @Before
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//        System.setErr(new PrintStream(errContent));
//    }
//
//    @After
//    public void restoreStreams() {
//        System.setOut(System.out);
//        System.setErr(System.err);
//    }
//
//    public void testPrintedGame() {
//
//        ClassLoader classLoader = getClass().getClassLoader();
//        File file = new File(classLoader.getResource("game_all_strikes.txt").getFile());
//
//
//        FileParser fp = new FileParser();
//
//        HashMap<String, ArrayList<Roll>> allPlayersAndRolls = new HashMap<>();
//
//        try {
//            allPlayersAndRolls = fp.parseGameFile(file);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        ArrayList<Game> allGames = new ArrayList<>();
//
//        for (Object o : allPlayersAndRolls.entrySet()) {
//            Map.Entry pair = (Map.Entry) o;
//            String bowlerName = pair.getKey().toString();
//            ArrayList<Roll> bowlerRolls = (ArrayList<Roll>) pair.getValue();
//            Game aGame = FrameBuilder.parseFramesFromRolls(bowlerName, bowlerRolls);
//            Game calculatedGame = GameCalculator.calculateGame(aGame);
//
//            allGames.add(calculatedGame);
//        }
//
////        PrintStream save_out= System.out;
////        final ByteArrayOutputStream out = new ByteArrayOutputStream();
////        System.setOut(new PrintStream(out));
//
//        GamePrinter.printAllGames(allGames);
//
//        System.out.print("Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10");
//
//        assertEquals("Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10", outContent.toString());
//
//
//
//    }
//}
