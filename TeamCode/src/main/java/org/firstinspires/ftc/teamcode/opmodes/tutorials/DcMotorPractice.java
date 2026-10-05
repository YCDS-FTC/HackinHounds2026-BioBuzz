package org.firstinspires.ftc.teamcode.opmodes.tutorials;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.tutorials.TestBench1;

@TeleOp
public class DcMotorPractice extends OpMode {

    TestBench1 bench = new TestBench1();

    @Override
    public void init() {
        bench.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (bench.isTouchSensorPressed()) {
            bench.setMotorSpeed(0.5);
        }
        else {
            bench.setMotorSpeed(0.0);
        }
        telemetry.addData("Motor Revs", bench.getMotorRevs());
    }
}
