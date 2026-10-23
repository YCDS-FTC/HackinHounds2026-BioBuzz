package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class OutreachArm {

    private DcMotorEx motorArm;

    private static final double MAX_CURRENT = 5.0;
    private boolean isOverExtended, isOverRetracted;

    public void init(HardwareMap hwMap) {
        motorArm = hwMap.get(DcMotorEx.class, "motor_arm");
        motorArm.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorArm.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorArm.setCurrentAlert(MAX_CURRENT, CurrentUnit.AMPS);
        isOverExtended = isOverRetracted = false;
    }

    private void setMotorPower(double power) {
        motorArm.setPower(power);
    }

    public void armExtend() {
        if (motorArm.isOverCurrent() || isOverExtended) {
            isOverExtended = true;
            setMotorPower(0.0);
        } else {
            isOverRetracted = false;
            setMotorPower(1.0);
        }
    }

    public void armRetract() {
        if (motorArm.isOverCurrent() || isOverRetracted) {
            isOverRetracted = true;
            setMotorPower(0.0);
        } else {
            isOverExtended = false;
            setMotorPower(-1.0);
        }
    }

    public void armStop() {
        setMotorPower(0.0);
    }

    public double getMotorCurrent() {
        return motorArm.getCurrent(CurrentUnit.AMPS);
    }
}
