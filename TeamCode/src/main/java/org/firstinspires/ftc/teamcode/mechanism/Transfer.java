package org.firstinspires.ftc.teamcode.mechanism;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Transfer {

    private DcMotorEx motorTransfer;

    public void init(HardwareMap hwMap) {
        motorTransfer = hwMap.get(DcMotorEx.class, "motor_transfer");
        motorTransfer.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motorTransfer.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
    }


    public void updateTransferState(boolean transferIn, boolean transferOut) {
        if (transferIn) {
            enableTransferIn();
        }
        else if (transferOut) {
            enableTransferOut();
        }
        else {
            stopTransfer();
        }
    }

    public void enableTransferIn() {
        motorTransfer.setPower(1.0);
    }

    public void enableTransferOut() {
        motorTransfer.setPower(-1.0);
    }

    public void stopTransfer() {
        motorTransfer.setPower(0.0);
    }
}