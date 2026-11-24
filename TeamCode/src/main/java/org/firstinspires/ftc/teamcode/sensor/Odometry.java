package org.firstinspires.ftc.teamcode.sensor;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Odometry {

    /*
     * NOTES: FTC Field Coordinates are the standard way to refer to where a robot, or game element,
     * is on the field. They start at the center of the field at 0,0,0. X increases as you move towards
     * the audience, and Y increases as you move towards the blue alliance.
     * */

    // TODO: declare an instance of a GoBildaPinpointDriver

    // xOffset and yOffset are specified in millimeters
    // read goBilda pinpoint documentation for details on how to set these values
    public void init(HardwareMap hwMap, double xOffset, double yOffset, GoBildaPinpointDriver.EncoderDirection xEncoder, GoBildaPinpointDriver.EncoderDirection yEncoder) {
        // TODO: initialize the GoBildaPinpointDriver from the hardware map
        // TODO: set the x and y offsets
        // TODO: set the encoder resolution
        // TODO: set the encoder directions
        // TODO: reset the position and IMU
    }

    // TODO: add void method to resetPosAndIMU

    // TODO: add void method that updates odometry data (call once per cycle)

    // TODO: add a method that sets the position (x, y, and heading)

    // TODO: add getter to get position (x, y, and heading) return as a String

    // TODO: add method to get velocity (x, y, and heading) return as String

}
