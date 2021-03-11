package org.firstinspires.ftc.team7316.maps;

import org.firstinspires.ftc.team7316.subsystems.ArmSubsystem;
import org.firstinspires.ftc.team7316.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.team7316.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.team7316.subsystems.ParkSubystem;
import org.firstinspires.ftc.team7316.util.Scheduler;
import org.firstinspires.ftc.team7316.util.subsystems.Subsystem;

/**
 * Every subsystem that needs to be used is placed in here.
 */

public class Subsystems {

    public static Subsystems instance = null;

    public Subsystem[] subsystems;
    public MecanumDriveSubsystem mecanumDriveSubsystem;
    public ArmSubsystem arm;
    public IntakeSubsystem intake;
    public ParkSubystem park;


    private Subsystems () {
        mecanumDriveSubsystem = new MecanumDriveSubsystem();
        arm = new ArmSubsystem();
        intake = new IntakeSubsystem();
        park = new ParkSubystem();

        subsystems = new Subsystem[] {mecanumDriveSubsystem, arm, intake,park};
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