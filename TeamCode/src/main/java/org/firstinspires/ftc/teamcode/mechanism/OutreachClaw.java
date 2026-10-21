package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.acmerobotics.dashboard.config.Config;

@Config
public class OutreachClaw {

    private Servo servoClaw;

    public static double MIN_ANGLE = 0.735;
    public static double MAX_ANGLE = 0.78;

    public void init(HardwareMap hwMap){
        servoClaw = hwMap.get(Servo.class, "servo_claw");
        servoClaw.setDirection(Servo.Direction.REVERSE);
    }

    public void setServoPosClaw(boolean isButtonPressed){
        if(isButtonPressed){
            servoClaw.setPosition(MAX_ANGLE);
        }
        else{
            servoClaw.setPosition(MIN_ANGLE);
        }
    }
}

