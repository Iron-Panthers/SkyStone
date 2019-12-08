package org.firstinspires.ftc.team7316.maps;

import org.firstinspires.ftc.team7316.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.team7316.subsystems.TraySubsystem;
import org.firstinspires.ftc.team7316.util.Scheduler;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystem;

/**
 * Every subsystem that needs to be used is placed in here.
 */

public class Subsystems {

    public static Subsystems instance = null;

    public Subsystem[] subsystems;
    public MecanumDriveSubsystem mecanumDriveSubsystem;
    public TraySubsystem traySubsystem;


    private Subsystems () {
        mecanumDriveSubsystem = new MecanumDriveSubsystem();
        traySubsystem=new TraySubsystem();
        subsystems = new Subsystem[]{mecanumDriveSubsystem,traySubsystem};
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