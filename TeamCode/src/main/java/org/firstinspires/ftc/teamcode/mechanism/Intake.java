package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    private DcMotorEx motorIntake;

    public void init(HardwareMap hwMap) {
        motorIntake = hwMap.get(DcMotorEx.class, "motor_intake");
        motorIntake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorIntake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }

    public void enableIntakeIngest() {
        motorIntake.setPower(1.0);
    }

    public void disableIntake() {
        motorIntake.setPower(0.0);
    }

    public void enableIntakeEgest() {
        motorIntake.setPower(-1.0);
    }


    public void updateIntakeState(boolean intakeIn, boolean intakeOut) {
        if (intakeIn) {
            enableIntakeIngest();
        }
        else if(intakeOut) {
            enableIntakeEgest();
        }
        else{
            disableIntake();
        }
    }

}


