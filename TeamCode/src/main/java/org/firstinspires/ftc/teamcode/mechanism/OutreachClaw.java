package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class OutreachClaw {

    private Servo servoClaw;
    private static final double MAX_ANGLE = 0.333333333333333;//1.0/30.0 of 5 turns

    public void init(HardwareMap hwMap){
        servoClaw = hwMap.get(Servo.class, "servo_claw");
        servoClaw.scaleRange(0, MAX_ANGLE);//change when figure out what is bad or not
    }

    public void setServoPosClaw(boolean isButtonPressed){
        if(isButtonPressed){
            servoClaw.setPosition(1.0);
        }
        else{
            servoClaw.setPosition(0.0);
        }
    }
}

