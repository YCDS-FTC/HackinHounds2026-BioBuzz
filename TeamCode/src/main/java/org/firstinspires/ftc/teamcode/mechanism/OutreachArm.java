package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OutreachArm {

    private DcMotorEx motorArm;

    public void init(HardwareMap hwMap) {
        motorArm = hwMap.get(DcMotorEx.class, "motor_arm");
        motorArm.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorArm.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorArm.
    }

    private void setMotorPower(double power) {
        motorArm.setPower(power);
    }

    public void armExtend(){
        setMotorPower(1.0);
    }
    public void armRetract(){
        setMotorPower(-1.0);
    }

    public void armStop(){
        setMotorPower(0.0);
    }
}
