package org.firstinspires.ftc.teamcode.mechanism;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

@Config
public class Turret {

    //private Servo servoHood, servoTurretSwivel;
    private DcMotorEx motorOuttake;

    private  double outtakeSpeed;
    //private int overCurrentCount;

    //private static final double MAX_CURRENT = 5.0;
    private static final int MAX_OVERCURRENT_COUNT = 5;
    public static double MAX_SWIVEL_ANGLE = 90.0;
    public static double MIN_SWIVEL_ANGLE = 0.0;
    public static double HOME_SWIVEL_ANGLE = 0.0;
    public static double MAX_HOOD_ANGLE = 90.0;
    public static double MIN_HOOD_ANGLE = 0.0;
    public static double HOME_HOOD_ANGLE = 0.0;
    public static double MAX_OUTTAKE_SPEED = 1.0;

    public void init(HardwareMap hwMap) {
       // servoHood = hwMap.get(Servo.class, "servo_hood");
       // servoTurretSwivel = hwMap.get(Servo.class, "servo_turret_swivel");
        motorOuttake = hwMap.get(DcMotorEx.class, "motor_outtake");
        motorOuttake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorOuttake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        //motorOuttake.setCurrentAlert(MAX_CURRENT, CurrentUnit.AMPS);
        //overCurrentCount = 0;
    }

//    private void setHoodAngle() {
//        servoHood.setPosition();
//    }

//    private void setHoodHome() {
//        servoHood.setPosition(HOME_HOOD_ANGLE);
//    }

//    private void setTurretAngle() {
//        servoTurretSwivel.setPosition();
//    }
//    private void setTurretHome(){
//        servoTurretSwivel.setPosition(HOME_SWIVEL_ANGLE);
//    }

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
        if (outtakeOff) {
            disableOuttake();
        }
        else if (outtakeOn) {
            enableOuttake();
        }
        else {
            disableOuttake();
        }
    }
}
