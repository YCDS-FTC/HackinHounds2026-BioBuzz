package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class OutreachClaw {

    private Servo servoClaw;

    public void init(HardwareMap hwMap){
      //  servoArm = hwMap.get(Servo.class, "servo_arm");
      //  servoArm.scaleRange(0,1.0);//change when figure out what is bad or not
        servoClaw = hwMap.get(Servo.class, "servo_claw");
        servoClaw.scaleRange(0,1.0);//change when figure out what is bad or not
    }

   // public void setServoPosArm(double angle){
      //  servoArm.setPosition(angle);
  //  }

    public void setServoPosClaw(double angle){
        servoClaw.setPosition(angle);
    }
}

