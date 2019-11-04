package org.firstinspires.ftc.team7316.util.subsystems;

import org.firstinspires.ftc.team7316.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.team7316.util.Scheduler;

/**
 * Every subsystem that needs to be used is placed in here.
 */

public class Subsystems {

    public static Subsystems instance = null;

    public Subsystem[] subsystems;
    public MecanumDriveSubsystem mecanumDriveSubsystem;


    private Subsystems () {
        mecanumDriveSubsystem = new MecanumDriveSubsystem();
        subsystems = new Subsystem[]{mecanumDriveSubsystem};
    }

    public static void createSubsystems() {
        instance = new Subsystems();

        Scheduler.instance.addDefaultCommands();

        instance.resetSubsystems();
    }

    public void resetSubsystems() {
        for(Subsystem s : subsystems) {
            s.reset();
        }
    }
}