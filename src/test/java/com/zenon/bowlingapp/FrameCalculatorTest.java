package com.zenon.bowlingapp;

import com.zenon.bowlingapp.domain.frame.Frame;
import com.zenon.bowlingapp.domain.roll.Roll;
import com.zenon.bowlingapp.domain.frame.Spare;
import com.zenon.bowlingapp.domain.frame.Strike;
import com.zenon.bowlingapp.calculator.FrameCalculator;
import junit.framework.TestCase;

import java.util.ArrayList;


public class FrameCalculatorTest extends TestCase {

    public void testPointsCalculated() {

        //setup - todo refactor with Mockito
        Roll roll0frame0 = new Roll(7);
        Roll roll1frame0 = new Roll(2);
        Frame frame0 = new Frame(roll0frame0, roll1frame0);

        Roll roll0frame1 = new Roll(7);
        Roll roll1frame1 = new Roll(3);
        Frame frame1 = new Spare(roll0frame1, roll1frame1);

        Roll roll0frame2 = new Roll(5);
        Roll roll1frame2 = new Roll(0);
        Frame frame2 = new Frame(roll0frame2, roll1frame2);

        Roll roll0frame3 = new Roll(10);
        Frame frame3 = new Strike(roll0frame3);

        Roll roll0frame4 = new Roll(2);
        Roll roll1frame4 = new Roll(2);
        Frame frame4 = new Frame(roll0frame4, roll1frame4);


        ArrayList<Frame> frames = new ArrayList<>();

        frames.add(frame0);
        frames.add(frame1);
        frames.add(frame2);
        frames.add(frame3);
        frames.add(frame4);

        //check regular frame
        assertTrue(FrameCalculator.frameTotalScore(frame0, frames) == 9);
        //check spare
        assertTrue(FrameCalculator.frameTotalScore(frame1, frames) == 15);
        //check strike
        assertTrue(FrameCalculator.frameTotalScore(frame3, frames) == 14);
    }
}
