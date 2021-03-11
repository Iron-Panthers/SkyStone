package org.firstinspires.ftc.team7316.subsystems;

import org.firstinspires.ftc.team7316.commands.TeleopPark;
import org.firstinspires.ftc.team7316.maps.Hardware;
import org.firstinspires.ftc.team7316.util.commands.Command;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystem;

public class ParkSubystem extends Subsystem {

    @Override
    public void reset() {
        Hardware.instance.parkServo.setPosition(1);
    }
    public void  extend(){
        Hardware.instance.parkServo.setPosition(0);
    }
    @Override
    public Command defaultAutoCommand() {
        return null;
    }

    @Override
    public Command defaultTeleopCommand() {
        return new TeleopPark();
    }
}
