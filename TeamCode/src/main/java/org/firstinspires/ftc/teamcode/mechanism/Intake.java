package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    private DcMotorEx motorIntake;

    private int injestCounter;
    private int ejestCounter;
    private int intakeDirection;

    private static final int MAX_COUNTER = 5;

    public void init(HardwareMap hwMap) {
        motorIntake = hwMap.get(DcMotorEx.class, "motor_intake");
        motorIntake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorIntake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }

    public void enableIntakeIngest() {
        motorIntake.setPower(1.0);
    }

    public void enableIntakeEgest() {
        motorIntake.setPower(-1.0);
    }

    public void disableIntake() {
        motorIntake.setPower(0.0);
    }

    public void updateIntakeState(boolean intakeIn, boolean intakeOut, boolean intakeStop) {

        if(intakeIn) {
            intakeDirection = 1;
        }
        else if (intakeOut) {
            intakeDirection = -1;
        }
        else if (intakeStop) {
            intakeDirection = -2;
        }
        else {
            intakeDirection = 0;
        }

        if (intakeDirection == 1) {
            ejestCounter = 0;
            if(injestCounter > MAX_COUNTER) {
                enableIntakeIngest();
            }
            else if (injestCounter <= MAX_COUNTER) {
                disableIntake();
                injestCounter++;
            }
        }
        else if (intakeDirection == -1) {
            injestCounter = 0;
            if (ejestCounter > MAX_COUNTER) {
                enableIntakeEgest();
            }
            else if (ejestCounter <= MAX_COUNTER) {
                disableIntake();
                ejestCounter++;
            }
        }
        else if (intakeDirection == -2) {
            disableIntake();
        }
    }

}


