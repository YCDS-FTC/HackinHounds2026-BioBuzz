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
    double hoodAngle, swivelAngle;

    boolean intakeIn, intakeOut, intakeStop;
    boolean outtakeOn, outtakeOff;

    @Override
    public void init() {
        drive.init(hardwareMap);
        intake.init(hardwareMap);
        intakeIn = intakeOut = false;
        transfer.init(hardwareMap);
        turret.init(hardwareMap);
        outtakeOn = outtakeOff = false;
        hoodAngle = swivelAngle = 0.0;
    }

    @Override
    public void start() {
        // if on BLUE and robot is starting on audience side, set to 90º
        // if on RED and robot is starting on audience side, set to -90º
        // otherwise set to 0
        // for other starting positions, figure it out.
        drive.setHeadingOffset(Math.toRadians(0));
    }

    @Override
    public void loop() {
        forward = -gamepad1.left_stick_y;
        strafe = gamepad1.left_stick_x;
        rotate = gamepad1.right_stick_x;

        outtakeOn = gamepad1.right_bumper;
        outtakeOff = gamepad1.left_bumper;

        hoodAngle = gamepad1.right_trigger;
        swivelAngle = gamepad1.left_trigger;

        intakeIn = gamepad1.x;
        intakeOut = gamepad1.a;
        intakeStop = gamepad1.dpad_down;

        drive.driveFieldRelative(forward, strafe, rotate);
        intake.updateIntakeState(intakeIn, intakeOut, intakeStop);
        transfer.updateTransferState(intake.getState());
        turret.updateOuttakeState(outtakeOn, outtakeOff);
        turret.setHoodAngle(hoodAngle);
        turret.setTurretAngle(swivelAngle);
    }
}