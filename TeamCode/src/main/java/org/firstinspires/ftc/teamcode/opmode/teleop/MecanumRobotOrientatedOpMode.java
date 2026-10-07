package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanism.MecanumDrive;

@TeleOp
public class MecanumRobotOrientatedOpMode extends OpMode {

    MecanumDrive drive = new MecanumDrive();
    double forward, strafe, rotate;

    @Override
    public void init() {
        drive.init(hardwareMap);
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        drive.driveRobotRelative(forward, strafe, rotate);
    }
}