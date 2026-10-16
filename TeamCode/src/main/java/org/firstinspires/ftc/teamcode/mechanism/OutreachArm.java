package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OutreachArm {

    private DcMotor motorArm;

    public void init(HardwareMap hwMap) {
        motorArm = hwMap.get(DcMotor.class, "motor_arm");
        motorArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
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
