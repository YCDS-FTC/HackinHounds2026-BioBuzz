package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Intake {

    private DcMotorEx motorIntake;

//    private int injestCounter;
//    private int ejestCounter;
//    private int intakeDirection;


    enum IntakeState {
        READY,
        INGESTING,
        EGESTING,
        INGEST_TO_EGEST_DELAY,
        EGEST_TO_INGEST_DELAY,
        STOPPING_INGEST,
        STOPPING_EGEST
    }

    private IntakeState currentState;
    private int delayCounter;

    private static final int DIRECTION_CHANGE_DELAY = 5;

    public void init(HardwareMap hwMap) {
        motorIntake = hwMap.get(DcMotorEx.class, "motor_intake");
        motorIntake.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorIntake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        currentState = IntakeState.READY;
        delayCounter = 0;
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
        switch (currentState) {
            case READY:
                if (intakeIn) {
                    currentState = IntakeState.INGESTING;
                    enableIntakeIngest();
                }
                else if (intakeOut) {
                    currentState = IntakeState.EGESTING;
                    enableIntakeEgest();
                }
                break;
            case INGESTING:
                if (intakeStop) {
                    currentState = IntakeState.STOPPING_INGEST;
                    disableIntake();
                    delayCounter = 0;
                }
                else if (intakeOut) {
                    currentState = IntakeState.INGEST_TO_EGEST_DELAY;
                    disableIntake();
                    delayCounter = 0;
                }
                break;
            case EGESTING:
                if (intakeStop) {
                    currentState = IntakeState.STOPPING_EGEST;
                    disableIntake();
                    delayCounter = 0;
                }
                else if (intakeIn) {
                    currentState = IntakeState.EGEST_TO_INGEST_DELAY;
                    disableIntake();
                    delayCounter = 0;
                }
                break;
            case INGEST_TO_EGEST_DELAY:
                delayCounter++;

                if (intakeIn) {
                    currentState = IntakeState.INGESTING;
                    enableIntakeIngest();
                }
                else if (intakeStop) {
                    currentState = IntakeState.STOPPING_INGEST;
                }
                else if (delayCounter > DIRECTION_CHANGE_DELAY) {
                    currentState = IntakeState.EGESTING;
                    enableIntakeEgest();
                }
                break;
            case EGEST_TO_INGEST_DELAY:
                delayCounter++;

                if (intakeOut) {
                    currentState = IntakeState.EGESTING;
                    enableIntakeEgest();
                }
                else if (intakeStop) {
                    currentState = IntakeState.STOPPING_EGEST;
                }
                else if (delayCounter > DIRECTION_CHANGE_DELAY) {
                    currentState = IntakeState.INGESTING;
                    enableIntakeIngest();
                }
                break;
            case STOPPING_INGEST:
                delayCounter++;

                if (intakeIn) {
                   currentState = IntakeState.INGESTING;
                   enableIntakeIngest();
                }
                else if (intakeOut) {
                    currentState = IntakeState.INGEST_TO_EGEST_DELAY;
                }
                else if (delayCounter > DIRECTION_CHANGE_DELAY-1) {
                    currentState = IntakeState.READY;
                }
                break;
            case STOPPING_EGEST:
                delayCounter++;

                if (intakeOut) {
                    currentState = IntakeState.EGESTING;
                    enableIntakeEgest();
                }
                else if (intakeIn) {
                    currentState = IntakeState.EGEST_TO_INGEST_DELAY;
                }
                else if (delayCounter > DIRECTION_CHANGE_DELAY-1) {
                    currentState = IntakeState.READY;
                }
                break;
        }

//
//        if(intakeIn) {
//            intakeDirection = 1;
//        }
//        else if (intakeOut) {
//            intakeDirection = -1;
//        }
//        else if (intakeStop) {
//            intakeDirection = -2;
//        }
//        else {
//            intakeDirection = 0;
//        }
//
//        if (intakeDirection == 1) {
//            ejestCounter = 0;
//            if(injestCounter > MAX_COUNTER) {
//                enableIntakeIngest();
//            }
//            else if (injestCounter <= MAX_COUNTER) {
//                disableIntake();
//                injestCounter++;
//            }
//        }
//        else if (intakeDirection == -1) {
//            injestCounter = 0;
//            if (ejestCounter > MAX_COUNTER) {
//                enableIntakeEgest();
//            }
//            else if (ejestCounter <= MAX_COUNTER) {
//                disableIntake();
//                ejestCounter++;
//            }
//        }
//        else if (intakeDirection == -2) {
//            disableIntake();
//        }
    }

}


