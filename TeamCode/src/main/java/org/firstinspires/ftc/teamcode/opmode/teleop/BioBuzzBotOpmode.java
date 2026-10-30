package org.firstinspires.ftc.teamcode.opmode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanism.Intake;
import org.firstinspires.ftc.teamcode.mechanism.MecanumDrive;
import org.firstinspires.ftc.teamcode.mechanism.Turret;
import org.firstinspires.ftc.teamcode.mechanism.Transfer;

@TeleOp
public class BioBuzzBotOpmode extends OpMode {

    MecanumDrive drive = new MecanumDrive();
    Intake intake = new Intake();
    Transfer transfer = new Transfer();
    Turret turret = new Turret();

    double forward, strafe, rotate;

    boolean intakeIn, intakeOut;
    boolean transferIn, transferOut;
    boolean outtakeOn, outtakeOff;

    @Override
    public void init() {
        drive.init(hardwareMap);
        transfer.init((hardwareMap));
        transferIn = transferOut = false;
        // turret.init(hardwareMap);
        outtakeOn = outtakeOff = false;
    }

    @Override
    public void loop() {
        forward = gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;
        outtakeOn = gamepad1.right_bumper;
        outtakeOff = gamepad1.left_bumper;
        intakeIn = gamepad1.x;
        intakeOut = gamepad1.a;
        transferIn = gamepad1.y;
        transferOut = gamepad1.b;

        drive.driveRobotRelative(forward, strafe, rotate);
        intake.updateIntakeState(intakeIn, intakeOut);
        transfer.updateTransferState(transferIn, transferOut);
        // turret.updateOuttakeState(outtakeOn, outtakeOff);


    }
}