package org.firstinspires.ftc.team7316.subsystems;

import org.firstinspires.ftc.team7316.commands.TeleopIntake;
import org.firstinspires.ftc.team7316.maps.Hardware;
import org.firstinspires.ftc.team7316.util.commands.Command;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystem;

public class IntakeSubsystem extends Subsystem {
    @Override
    public void reset() {
        Hardware.instance.lIntakeMotor.setPower(0);
        Hardware.instance.rIntakeMotor.setPower(0);
    }
    public void intake(){
        Hardware.instance.rIntakeMotor.setPower(1);
        Hardware.instance.lIntakeMotor.setPower(1);
    }
    public void outtake(){
        Hardware.instance.lIntakeMotor.setPower(-1);
        Hardware.instance.rIntakeMotor.setPower(-1);
    }

    @Override
    public Command defaultAutoCommand() {
        return null;
    }

    @Override
    public Command defaultTeleopCommand() {
        return new TeleopIntake();
    }
}
