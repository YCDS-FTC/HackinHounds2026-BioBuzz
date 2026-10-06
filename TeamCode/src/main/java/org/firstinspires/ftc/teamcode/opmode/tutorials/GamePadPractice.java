package org.firstinspires.ftc.teamcode.opmode.tutorials;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp
public class GamePadPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {

        double speedForward = -gamepad1.left_stick_y / 2;

        telemetry.addData("left x", gamepad1.left_stick_x);
        telemetry.addData("left y", speedForward);
        telemetry.addData("a button", gamepad1.a);
        telemetry.addData("right x", gamepad1.right_stick_x);
        telemetry.addData("right y", gamepad1.right_stick_y);
        telemetry.addData("b button", gamepad1.b);
        telemetry.addData("difference between left x and right x", gamepad1.left_stick_x - gamepad1.right_stick_x);
        telemetry.addData("sum of both rear triggers", gamepad1.left_trigger + gamepad1.right_trigger);
    }
}
