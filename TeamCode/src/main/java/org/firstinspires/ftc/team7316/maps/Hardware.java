package org.firstinspires.ftc.team7316.maps;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.team7316.util.GyroWrapper;
import org.firstinspires.ftc.team7316.util.PID;
import org.firstinspires.ftc.team7316.util.motorwrappers.DCMotorWrapper;

/**
 * Contains all the hardware names and actual hardware objects
 */

public class Hardware {

    public static Hardware instance = null;

    public static final String tag = "IronPanthers";

    public static Telemetry telemetry;

    public DcMotor frontLeftMotor;
    public DcMotor frontRightMotor;
    public DcMotor backLeftMotor;
    public DcMotor backRightMotor;
    public Servo leftTrayServo;
    public Servo rightTrayServo;
    public GyroWrapper gyroWrapper;

    public DcMotor lArmMotor;
    public DcMotor rArmMotor;
    public DcMotor lIntakeMotor;
    public DcMotor rIntakeMotor;

    public BNO055IMU imu;
    public DCMotorWrapper frontLeftMotorWrapper;
    public DCMotorWrapper frontRightMotorWrapper;
    public DCMotorWrapper backLeftMotorWrapper;
    public DCMotorWrapper backRightMotorWrapper;
    //Create all the hardware fields
    public final String frontLeftMotorName = "flmotor";
    public final String frontRightMotorName = "frmotor";
    public final String backLeftMotorName = "blmotor";
    public final String backRightMotorName = "brmotor";
    public final String lArmMotorName = "larmmotor";
    public final String rArmMotorName = "rarmmotor";
    public final String lIntakeMotorName = "lintakemotor";
    public final String rIntakeMotorName = "rintakemotor";
    public final String leftTrayServoName = "ltservo";
    public final String rightTrayServoName= "rtservo";
    public final String imuname = "gyro";


    /**
     * Initialize all the hardware fields here
     */
    public Hardware (HardwareMap map) {
        frontLeftMotor = map.dcMotor.get(frontLeftMotorName);
        frontRightMotor= map.dcMotor.get(frontRightMotorName);
        backLeftMotor = map.dcMotor.get(backLeftMotorName);
        backRightMotor= map.dcMotor.get(backRightMotorName);
        leftTrayServo=map.servo.get(leftTrayServoName);
        rightTrayServo=map.servo.get(rightTrayServoName);

        lArmMotor = map.dcMotor.get(lArmMotorName);
        rArmMotor = map.dcMotor.get(rArmMotorName);
        lIntakeMotor = map.dcMotor.get(lIntakeMotorName);
        rIntakeMotor = map.dcMotor.get(rIntakeMotorName);

        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //leftmotor.setDirection(DcMotorSimple.Direction.REVERSE);


        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



//        BNO055IMU.Parameters gyroParams = new BNO055IMU.Parameters();
////        climbSwitch = map.touchSensor.get(climbSwitchName);
////        gyroParams.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
////        gyroParams.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
////        gyroParams.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
////        gyroParams.loggingEnabled      = true;
////        gyroParams.loggingTag          = "IMU";
////        gyroParams.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
////
////        imu = map.get(BNO055IMU.class, imuname);
////        imu.initialize(gyroParams);
////        gyroWrapper = new GyroWrapper(imu);

        frontLeftMotorWrapper = new DCMotorWrapper(frontLeftMotor, new PID(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D, Constants.MAX_TICKS_SPEED), true);
        frontRightMotorWrapper = new DCMotorWrapper(frontRightMotor, new PID(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D, Constants.MAX_TICKS_SPEED), false);
        backLeftMotorWrapper = new DCMotorWrapper(backLeftMotor, new PID(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D, Constants.MAX_TICKS_SPEED), false);
        backRightMotorWrapper = new DCMotorWrapper(backRightMotor, new PID(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D, Constants.MAX_TICKS_SPEED), false);
    }

    public static void setHardwareMap(HardwareMap map) {
        instance = new Hardware(map);
    }

    public static void setTelemetry(Telemetry telemetry) {
        Hardware.telemetry = telemetry;
    }

    public static void log(String caption, Object value) {
        if (telemetry != null) {
            telemetry.addData(caption, value);
        }
    }
}