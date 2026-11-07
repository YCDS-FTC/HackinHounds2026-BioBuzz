package org.firstinspires.ftc.teamcode.mechanism;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

@Config
public class Turret {

    private Servo servoHood, servoTurretSwivel;
    private DcMotorEx motorOuttake;

    private  double outtakeSpeed;
    //private int overCurrentCount;

    enum shooterState {
        ON,
        OFF,
    }
    private shooterState currentShooterState;

    //private static final double MAX_CURRENT = 5.0;
    private static final int MAX_OVERCURRENT_COUNT = 5;
    public static double MAX_SWIVEL_ANGLE = 90.0;
    public static double MIN_SWIVEL_ANGLE = 0.0;
    public static double MAX_HOOD_ANGLE = 90.0;
    public static double MIN_HOOD_ANGLE = 0.0;
    public static double MAX_OUTTAKE_SPEED = 1.0;

    public void init(HardwareMap hwMap) {
        servoHood = hwMap.get(Servo.class, "servo_hood");
        servoTurretSwivel = hwMap.get(Servo.class, "servo_turret_swivel");
        motorOuttake = hwMap.get(DcMotorEx.class, "motor_outtake");
        motorOuttake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorOuttake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        currentShooterState = shooterState.OFF;
        //motorOuttake.setCurrentAlert(MAX_CURRENT, CurrentUnit.AMPS);
        //overCurrentCount = 0;
    }

    public void setHoodAngle(double hoodAngle) {
        servoHood.setPosition(hoodAngle);
    }

    public void setTurretAngle(double swivelAngle) {
        servoTurretSwivel.setPosition(swivelAngle);
    }

    private void setOuttakeSpeed() {
//        if (motorOuttake.isOverCurrent() || overCurrentCount > MAX_OVERCURRENT_COUNT) {
//            overCurrentCount++;
//            motorOuttake.setPower(0.0);
//        }
//        else {
            motorOuttake.setPower(outtakeSpeed);
//        }
    }

    public void enableOuttake() {
        motorOuttake.setPower(MAX_OUTTAKE_SPEED);
    }

    public void disableOuttake() {
        motorOuttake.setPower(0.0);
    }

    public void updateOuttakeState(boolean outtakeOn, boolean outtakeOff) {
        switch (currentShooterState) {
            case ON:
                if (outtakeOff) {
                    currentShooterState = shooterState.OFF;
                    disableOuttake();
                }
                break;
            case OFF:
                if (outtakeOn) {
                    currentShooterState = shooterState.ON;
                    enableOuttake();
                }
                break;
        }


//        if (outtakeOff) {
//            disableOuttake();
//        }
//        else if (outtakeOn) {
//            enableOuttake();
//        }
//        else {
//            disableOuttake();
//        }
    }
}
