package org.firstinspires.ftc.team7316;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.team7316.util.Constants;
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

    public DcMotor centermotor;
    public DcMotor climbmotor1;

    public DcMotor climbmotor2;

    public DcMotor extendmotorleft;
    public DcMotor extendmotorright;

    public Servo plateServo;
    public Servo trayAngleServo;
    public CRServo intakeServo;
    public BNO055IMU imu;
    public TouchSensor climbSwitch;

    public DCMotorWrapper frontLeftMotorWrapper;
    public DCMotorWrapper frontRightMotorWrapper;
    public DCMotorWrapper backLeftMotorWrapper;
    public DCMotorWrapper backRightMotorWrapper;
    public DCMotorWrapper centermotorWrapper;
    public GyroWrapper gyroWrapper;
    public DCMotorWrapper extendmotorleftWrapper;
    public DCMotorWrapper extenmotorrightWrapper;

    //Create all the hardware fields
    public final String frontLeftMotorName = "flmotor";
    public final String frontRightMotorName = "frmotor";
    public final String backLeftMotorName = "blmotor";
    public final String backRightMotorName = "brmotor";
    public final String centerMotorName = "cmotor";
    public final String climbMotor1Name = "clmotor1";
    public final String climbMotor2Name = "clmotor2";
    public final String plateServoName = "bservo";
    public final String trayExtendServoLeftName= "tlservo";
    public final String trayExtendServoRightName= "trservo";
    public final String trayAngleServoName= "taservo";
    public final String extendMotorLeftName = "elmotor";
    public final String ExtendMotorRightName = "ermotor";
    public final String imuname = "gyro";
    public final String intakeServoName = "iservo";
    public final String climbSwitchName = "clswitch";

    /**
     * Initialize all the hardware fields here
     */
    public Hardware (HardwareMap map) {
        frontLeftMotor = map.dcMotor.get(frontLeftMotorName);
        frontRightMotor= map.dcMotor.get(frontRightMotorName);
        backLeftMotor = map.dcMotor.get(backLeftMotorName);
        backRightMotor= map.dcMotor.get(backRightMotorName);
        centermotor=map.dcMotor.get(centerMotorName);
        climbmotor1=map.dcMotor.get(climbMotor1Name);
        climbmotor2=map.dcMotor.get(climbMotor2Name);
        extendmotorleft=map.dcMotor.get(extendMotorLeftName);
        extendmotorright=map.dcMotor.get(ExtendMotorRightName);


        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        centermotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        climbmotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        climbmotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //leftmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        extendmotorright.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        extendmotorleft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        centermotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        climbmotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        climbmotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        extendmotorright.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extendmotorleft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        plateServo=map.servo.get(plateServoName);
        intakeServo=map.crservo.get(intakeServoName);

        trayAngleServo=map.servo.get(trayAngleServoName);
        BNO055IMU.Parameters gyroParams = new BNO055IMU.Parameters();
        climbSwitch = map.touchSensor.get(climbSwitchName);
        gyroParams.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        gyroParams.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        gyroParams.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        gyroParams.loggingEnabled      = true;
        gyroParams.loggingTag          = "IMU";
        gyroParams.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu = map.get(BNO055IMU.class, imuname);
        imu.initialize(gyroParams);
        gyroWrapper = new GyroWrapper(imu);

        frontLeftMotorWrapper = new DCMotorWrapper(frontLeftMotor, new PID(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D, Constants.DRIVE_M_LEFT, Constants.DRIVE_B_LEFT, 0));
        frontRightMotorWrapper = new DCMotorWrapper(frontRightMotor, new PID(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D, Constants.DRIVE_M_RIGHT, Constants.DRIVE_B_RIGHT, 0));
        backLeftMotorWrapper = new DCMotorWrapper(backLeftMotor, new PID(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D, Constants.DRIVE_M_LEFT, Constants.DRIVE_B_LEFT, 0));
        backRightMotorWrapper = new DCMotorWrapper(backRightMotor, new PID(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D, Constants.DRIVE_M_RIGHT, Constants.DRIVE_B_RIGHT, 0));
        centermotorWrapper = new DCMotorWrapper(centermotor, new PID(Constants.DRIVE_P, Constants.DRIVE_I, Constants.TURN_D, Constants.TURN_M, Constants.TURN_B, 0));
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