package com.zenon.bowlingapp;

import com.zenon.bowlingapp.builder.FrameBuilder;
import com.zenon.bowlingapp.domain.frame.Frame;
import com.zenon.bowlingapp.domain.frame.Spare;
import com.zenon.bowlingapp.domain.frame.Strike;
import com.zenon.bowlingapp.domain.roll.Roll;
import junit.framework.TestCase;

import java.util.ArrayList;

public class FrameBuilderTest extends TestCase {

    public void testFramePointsCalculated() {

        //setup
        Roll roll0frame0 = new Roll(7);
        Roll roll1frame0 = new Roll(2);
        Frame frame0 = new Frame(roll0frame0, roll1frame0);

        Roll roll0frame1 = new Roll(7);
        Roll roll1frame1 = new Roll(3);
        Frame frame1 = new Spare(roll0frame1, roll1frame1);

        Roll roll0frame2 = new Roll(10);
        Frame frame2 = new Strike(roll0frame2);


        //check regular frame
        assertFalse(FrameBuilder.buildFrameTypeAndPoints(frame0, 9).isSpare());
        assertFalse(FrameBuilder.buildFrameTypeAndPoints(frame0, 9).isStrike());
        //check spare
        assertTrue(FrameBuilder.buildFrameTypeAndPoints(frame1, 10).isSpare());
        //check strike
        assertTrue(FrameBuilder.buildFrameTypeAndPoints(frame2, 10).isStrike());


    }

}
