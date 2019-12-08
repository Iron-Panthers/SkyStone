package org.firstinspires.ftc.team7316.subsystems;

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
        Hardware.instance.rightTrayServo.setPosition(Constants.trayServoDown);
        Hardware.instance.leftTrayServo.setPosition(Constants.trayServoDown);
    }
    public void up(){
        Hardware.instance.rightTrayServo.setPosition(Constants.trayServoUp);
        Hardware.instance.leftTrayServo.setPosition(Constants.trayServoUp);
    }
}
