package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class OutreachArm {

    private DcMotorEx motorArm;

    private static final double MAX_CURRENT = 5.0;
    private static final int MAX_OVERCURRENT_COUNT = 5;
    private int overExtendedCount, overRetractedCount;

    public void init(HardwareMap hwMap) {
        motorArm = hwMap.get(DcMotorEx.class, "motor_arm");
        motorArm.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorArm.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        motorArm.setCurrentAlert(MAX_CURRENT, CurrentUnit.AMPS);
        overExtendedCount = overRetractedCount = 0;
    }

    private void setMotorPower(double power) {
        motorArm.setPower(power);
    }

    public void armExtend(double extensionSpeed) {
        if (motorArm.isOverCurrent() || (overExtendedCount > MAX_OVERCURRENT_COUNT)) {
            overExtendedCount++;
            setMotorPower(0.0);
        } else {
            overRetractedCount = 0;
            setMotorPower(extensionSpeed);
        }
    }

    public void armRetract(double retractionSpeed) {
        if (motorArm.isOverCurrent() || (overRetractedCount > MAX_OVERCURRENT_COUNT)) {
            overRetractedCount++;
            setMotorPower(0.0);
        } else {
            overExtendedCount = 0;
            setMotorPower(-retractionSpeed);
        }
    }

    public void armStop() {
        setMotorPower(0.0);
    }

    public void updateArmPosition(double retractionSpeed, double extensionSpeed) {
        if(extensionSpeed > 0.1) {
            armExtend(extensionSpeed);
        }
        else if (retractionSpeed > 0.1) {
            armRetract(retractionSpeed);
        }
        else {
            armStop();
        }
    }

    public double getMotorCurrent() {
        return motorArm.getCurrent(CurrentUnit.AMPS);
    }

    public int getOverExtendedCount() {
        return overExtendedCount;
    }

    public int getOverRetractedCount() {
        return overRetractedCount;
    }
}
