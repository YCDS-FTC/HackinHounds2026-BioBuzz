package org.firstinspires.ftc.teamcode.mechanism;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Config
public class Turret {

    private Servo servoHood, servoTurretSwivel;
    private DcMotorEx motorOuttake;

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
    }

    private void setHoodAngle() {

    }

    private void setTurretAngle() {

    }

    private void setOuttakeSpeed() {

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
