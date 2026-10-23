package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanism.MecanumDrive;
import org.firstinspires.ftc.teamcode.mechanism.OutreachArm;
import org.firstinspires.ftc.teamcode.mechanism.OutreachClaw;

@TeleOp
public class OutreachBotOpmode extends OpMode {

    MecanumDrive drive = new MecanumDrive();
    OutreachClaw claw = new OutreachClaw();
    OutreachArm arm = new OutreachArm();
    double forward, strafe, rotate;
    double leftTrigger, rightTrigger;
    boolean rightBumper;

    @Override
    public void init() {
        drive.init(hardwareMap);
        claw.init(hardwareMap);
        arm.init(hardwareMap);
        leftTrigger = rightTrigger = 0.0;
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;
        leftTrigger = gamepad1.left_trigger;
        rightTrigger = gamepad1.right_trigger;
        rightBumper = gamepad1.right_bumper;

        drive.driveRobotRelative(forward, strafe, rotate);
        arm.updateArmPosition(leftTrigger, rightTrigger);
        claw.updatePosition(rightBumper);

        // put all telemetry outputs here
        telemetry.addData("arm motor current", arm.getMotorCurrent());
        telemetry.addData("arm over extend count", arm.getOverExtendedCount());
        telemetry.addData("are over retracted count", arm.getOverRetractedCount());

    }
}