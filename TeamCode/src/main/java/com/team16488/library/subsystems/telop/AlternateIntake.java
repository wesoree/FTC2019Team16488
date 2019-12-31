package com.team16488.library.subsystems.telop;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.team16488.library.subsystems.Subsystem;

/**
 * This is the Alternate Intake, It deals with the hook on the side that we use to
 * move blocks when the Intake is unavailable
 *
 * @author Parham Baghbanbashi: parhambagh@gmail.com
 * @author Ernest Wong
 *
 * <p>github: https://github.com/StrRamsRobotics/SkyStone/tree/Parham-Baghbanbashi</p>
 */
public class AlternateIntake extends Subsystem {
    public DigitalChannel blockDetection;
    public boolean state;
    public boolean ON = false;
    private Servo alternateIntakeRaise, alternateIntakeClose;
    private boolean down;
    private double pos;

    public AlternateIntake(HardwareMap map) {
        blockDetection = map.digitalChannel.get("Block");
        alternateIntakeRaise = map.servo.get("alternate intake raise");
        alternateIntakeClose = map.servo.get("alternate intake close");

        blockDetection.setMode(DigitalChannel.Mode.INPUT);
    }

    @Override
    public void update() {
        if (ON) {
            if (down) {
                pos = 0;
            } else {
                pos = 0.5;
            }
            if (blockDetection.getState()) {
                state = true;
                alternateIntakeClose.setPosition(pos);
            }
            if (!blockDetection.getState()) {
                state = false;
                alternateIntakeClose.setPosition(0.5);
            }
            alternateIntakeRaise.setPosition(pos);
        } else {
            down = true;

        }


    }


    public double getPos() {
        return pos;
    }

    public void setPos(double robopos) {
        this.pos = robopos;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
