package org.firstinspires.ftc.teamcode.opmodes.tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class VariableClass extends OpMode {

    @Override
    public void init() {
        int teamNumber = 21324;
        double motorSpeed = 0.75;
        boolean clawClosed = true;
        String teamName = "hacking hound";
        int motorAngle = 0;

        telemetry.addData("Team Number", teamNumber);
        telemetry.addData("motor speed", motorSpeed);
        telemetry.addData("claw closed", clawClosed);
        telemetry.addData("Name", teamName);
        telemetry.addData("motor angle", motorAngle);
    }

    @Override
    public void loop() {

    }
}
