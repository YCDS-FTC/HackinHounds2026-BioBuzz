package org.firstinspires.ftc.teamcode.opmode.tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class IfPractice extends OpMode {

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        double leftY = gamepad1.left_stick_y;

        if (leftY < 0.1 && leftY > -0.1) {
            telemetry.addData("Left Stick", "In Dead Zone");
        }

        telemetry.addData("Left Stick value", leftY);
    }
}
