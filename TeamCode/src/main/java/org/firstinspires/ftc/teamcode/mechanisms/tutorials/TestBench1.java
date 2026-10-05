package org.firstinspires.ftc.teamcode.mechanisms.tutorials;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TestBench1 {
    private DcMotor motor;
    private DigitalChannel touchSensor;
    private double ticksPerRev;

    public void init(HardwareMap hwMap) {
        motor = hwMap.get(DcMotor.class, "motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ticksPerRev = motor.getMotorType().getTicksPerRev();
        touchSensor = hwMap.get(DigitalChannel.class, "touch_sensor");
        touchSensor.setMode(DigitalChannel.Mode.INPUT);
    }

    public boolean isTouchSensorPressed() {
        return !touchSensor.getState();
    }

    public boolean isTouchSensorReleased() {
        return touchSensor.getState();
    }

    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }
        public double getMotorRevs() {
             return motor.getCurrentPosition() / ticksPerRev;
    }
}
