package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    private DcMotorEx motorIntake;

    public void init(HardwareMap hwMap) {
        motorIntake = hwMap.get(DcMotorEx.class, "motor_arm");
        motorIntake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorIntake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }

    public void enableIntakeIn() {
        motorIntake.setPower(1.0);
    }

    public void disableIntakeOut() {
        motorIntake.setPower(-1.0);
    }

    public void updateIntakeState(boolean intakeIn, boolean intakeOut) {
        if (intakeIn) {
            enableIntakeIn();
        }
        else if(intakeOut) {
            disableIntakeOut();
        }
    }

}


