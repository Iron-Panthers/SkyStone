package org.firstinspires.ftc.team7316.commands;

import org.firstinspires.ftc.team7316.maps.OI;
import org.firstinspires.ftc.team7316.maps.Subsystems;
import org.firstinspires.ftc.team7316.subsystems.ParkSubystem;
import org.firstinspires.ftc.team7316.util.commands.Command;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystem;

public class TeleopPark extends Command {
    @Override
    public void init() {
        Subsystems.instance.park.reset();
    }

    @Override
    public void loop() {
        if( OI.instance.gp2.x_button.pressedState()){
            Subsystems.instance.park.extend();
        }
        else if(OI.instance.gp2.b_button.pressedState()){
            Subsystems.instance.park.reset();
        }
    }

    @Override
    public boolean shouldRemove() {
        return false;
    }

    @Override
    protected void end() {
        Subsystems.instance.park.reset();
    }
}
