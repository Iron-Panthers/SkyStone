package org.firstinspires.ftc.team7316.commands;

import org.firstinspires.ftc.team7316.maps.OI;
import org.firstinspires.ftc.team7316.maps.Subsystems;
import org.firstinspires.ftc.team7316.util.commands.Command;

public class TeleopTrayServo extends Command {
    @Override
    public void init() {
        Subsystems.instance.traySubsystem.up();
    }

    @Override
    public void loop() {
        if(OI.instance.gp1.right_bumper.pressedState()){
            Subsystems.instance.traySubsystem.down();
        }
        if(OI.instance.gp1.left_bumper.pressedState()){
            Subsystems.instance.traySubsystem.up();
        }
    }

    @Override
    public boolean shouldRemove() {
        return false;
    }

    @Override
    protected void end() {

    }
}
