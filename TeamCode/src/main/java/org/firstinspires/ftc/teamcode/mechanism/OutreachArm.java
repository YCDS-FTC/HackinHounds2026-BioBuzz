package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OutreachArm {

    private DcMotor motorArm;

    public void init(HardwareMap hwMap) {
        motorArm = hwMap.get(DcMotor.class, "motor_arm");
        motorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void setMotorSpeed(double speed) {
        motorArm.setPower(speed);
    }
}
