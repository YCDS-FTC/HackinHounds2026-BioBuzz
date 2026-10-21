package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class OutreachArm {

    private DcMotorEx motorArm;
//    private static final double MAX_CURRENT = 5.0;

    public void init(HardwareMap hwMap) {
        motorArm = hwMap.get(DcMotorEx.class, "motor_arm");
        motorArm.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorArm.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//        motorArm.setCurrentAlert(MAX_CURRENT, CurrentUnit.AMPS);
    }

    private void setMotorPower(double power) {
//        if (motorArm.isOverCurrent()) {
//            motorArm.setPower(0.0);
//        } else {
            motorArm.setPower(power);
//        }
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

    public double getMotorCurrent() {
        return motorArm.getCurrent(CurrentUnit.AMPS);
    }
}
