package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.acmerobotics.dashboard.config.Config;

@Config
public class OutreachClaw {

    private Servo servoClaw;

    public static double MIN_ANGLE = 0.735;  // public so they are accessible via FTC Dashboard
    public static double MAX_ANGLE = 0.78;

    public void init(HardwareMap hwMap) {
        servoClaw = hwMap.get(Servo.class, "servo_claw");
        servoClaw.setDirection(Servo.Direction.REVERSE);
        openClaw();
    }

    public void closeClaw() {
        servoClaw.setPosition(MIN_ANGLE);
    }

    public void openClaw() {
        servoClaw.setPosition(MAX_ANGLE);
    }

    public void updatePosition(boolean isButtonPressed) {
        if(isButtonPressed) {
            closeClaw();
        }
        else {
            openClaw();
        }
    }
}

