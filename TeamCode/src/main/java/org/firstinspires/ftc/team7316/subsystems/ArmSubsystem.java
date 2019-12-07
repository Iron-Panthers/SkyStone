package org.firstinspires.ftc.team7316.subsystems;

import org.firstinspires.ftc.team7316.commands.RunArm;
import org.firstinspires.ftc.team7316.maps.Hardware;
import org.firstinspires.ftc.team7316.util.commands.Command;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystem;

public class ArmSubsystem extends Subsystem {

    @Override
    public void reset() {
        Hardware.instance.lArmMotor.setPower(0);
        Hardware.instance.rArmMotor.setPower(0);
    }

    @Override
    public Command defaultAutoCommand() {
        return null;
    }

    @Override
    public Command defaultTeleopCommand() {
        return new RunArm();
    }

    public void setArm(double power) {
        Hardware.instance.lArmMotor.setPower(power);
        Hardware.instance.rArmMotor.setPower(power);
    }
}
