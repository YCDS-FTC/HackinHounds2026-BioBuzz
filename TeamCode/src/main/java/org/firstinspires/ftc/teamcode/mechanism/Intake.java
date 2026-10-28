package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    private DcMotorEx motorIntake;

    public void init(HardwareMap hwMap) {
        motorIntake = hwMap.get(DcMotorEx.class, "motor_arm");
        motorIntake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorIntake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }

    private void setMotorPower(double power) {
        motorIntake.setPower(power);
    }
}
