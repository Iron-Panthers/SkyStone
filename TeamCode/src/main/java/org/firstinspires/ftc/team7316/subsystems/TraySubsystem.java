package org.firstinspires.ftc.team7316.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.team7316.commands.TeleopTrayServo;
import org.firstinspires.ftc.team7316.maps.Constants;
import org.firstinspires.ftc.team7316.maps.Hardware;
import org.firstinspires.ftc.team7316.util.commands.Command;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystem;

public class TraySubsystem extends Subsystem {
    @Override
    public void reset() {

    }

    @Override
    public Command defaultAutoCommand() {
        return null;
    }

    @Override
    public Command defaultTeleopCommand() {
        return new TeleopTrayServo();
    }
    public void down(){
        Hardware.instance.leftTrayServo.setPower(.6);
        Hardware.instance.leftTrayServo.setPower(.6);
    }
    public void up(){
        Hardware.instance.rightTrayServo.setPower(-.6);
        Hardware.instance.leftTrayServo.setPower(-.6);
    }
}
