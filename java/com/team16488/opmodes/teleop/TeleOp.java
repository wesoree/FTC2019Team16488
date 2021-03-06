package com.team16488.opmodes.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.team16488.skystone.Robot;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "Tele", group = "teleop")
public class TeleOp extends OpMode {
    private Robot robot;
    double slowmode = 0.8;
    boolean intakeon = false;


    boolean clawOpen;
    public void init(){
        robot = new Robot(this, telemetry);
        robot.start();
    }

    @Override
    public void start(){
    }

    @Override
    public void loop(){
        /*
        robot.drive.setVelocity(-gamepad1.left_stick_x, gamepad1.left_stick_y, -gamepad1.right_stick_x);

        if(gamepad1.left_stick_x == 0 && gamepad1.left_stick_y == 0 && gamepad1.right_stick_x == 0 ){
            robot.drive.setVelocity(-gamepad2.left_stick_x*slowmode, gamepad2.left_stick_y*slowmode, -gamepad2.right_stick_x*slowmode);
        }
        */



            if(gamepad1.y){
                robot.intake.setOn(true);
            }
            if(gamepad1.b)
            {
                robot.intake.setIn(true);
            }
            if(gamepad1.x)
            {
                robot.intake.setIn(false);
            }
            if(gamepad1.a){
                robot.intake.setOn(false);
            }


            if(gamepad1.right_bumper)
            {
                robot.platformHook.setOpen(true);
            }
            if(gamepad1.left_bumper)
            {
                robot.platformHook.setOpen(false);
            }

/*


        if(gamepad2.left_bumper){
            robot.lift.setGoingUp(true);
        }
        if(gamepad2.right_bumper){
            robot.lift.setGoingUp(false);
        }


        if(gamepad2.dpad_up){
            robot.clawHead.setverticalRotation(1.00);
        }
        if(gamepad2.dpad_down){
            robot.clawHead.setverticalRotation(-1.00);
        }
        if(gamepad2.dpad_left){
            robot.clawHead.sethorizontalRotationPosition(1.00);
        }

        if(gamepad2.dpad_right){
            robot.clawHead.sethorizontalRotationPosition(-1);
        }

        robot.arm.setPower(-gamepad2.right_stick_y);



        //swich gampad 1 to gamepad2
        if(gamepad2.a ){
            clawOpen = true;
        }
        if(gamepad2.b){
            clawOpen = false;
        }
        if(clawOpen){
            robot.clawHead.setOpen(true);
        }
        if(!clawOpen){
            robot.clawHead.setOpen(false);
        }

*/


    }

    @Override
    public void stop(){
        robot.stop();
    }

}
