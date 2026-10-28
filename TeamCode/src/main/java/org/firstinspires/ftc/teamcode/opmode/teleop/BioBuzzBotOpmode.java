package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanism.MecanumDrive;
import org.firstinspires.ftc.teamcode.mechanism.Turret;

@TeleOp
public class BioBuzzBotOpmode extends OpMode {

    MecanumDrive drive = new MecanumDrive();
    Turret turret = new Turret();
    double forward, strafe, rotate;
    boolean outtakeOn, outtakeOff;

    @Override
    public void init() {
        drive.init(hardwareMap);
        turret.init(hardwareMap);
        outtakeOn = outtakeOff = false;
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;
        outtakeOn = gamepad1.right_bumper;
        outtakeOff = gamepad1.left_bumper;

        drive.driveRobotRelative(forward, strafe, rotate);
        turret.updateOuttakeState(outtakeOn, outtakeOff);
    }
}