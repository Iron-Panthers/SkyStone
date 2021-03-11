package org.firstinspires.ftc.team7316.commands;

import org.firstinspires.ftc.team7316.maps.Hardware;
import org.firstinspires.ftc.team7316.maps.OI;
import org.firstinspires.ftc.team7316.maps.Subsystems;
import org.firstinspires.ftc.team7316.util.Util;
import org.firstinspires.ftc.team7316.util.commands.Command;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystem;

public class RunArm extends Command {

    @Override
    public void init() {
        requires(Subsystems.instance.arm);
    }

    @Override
    public void loop() {
        Subsystems.instance.arm.setArm(.8*OI.instance.gp2.left_stick.getY());
    }

    @Override
    public boolean shouldRemove() {
        return false;
    }

    @Override
    public void end() {}
}
