package org.firstinspires.ftc.team7316.commands;

import org.firstinspires.ftc.team7316.util.Util;
import org.firstinspires.ftc.team7316.util.commands.Command;
import org.firstinspires.ftc.team7316.maps.OI;
import org.firstinspires.ftc.team7316.maps.Subsystems;

public class JoystickDrive extends Command {

    @Override
    public void init() {
        requires(Subsystems.instance.mecanumDriveSubsystem);
    }

    @Override
    public void loop() {
        double y = OI.instance.gp1.left_stick.getY();
        double x = OI.instance.gp1.left_stick.getX();
        double turn = OI.instance.gp1.right_stick.getX();

        double magnitude = Math.sqrt(y*y + x*x);
        double angle = Util.getAngleFromPoint(x,y);

        //rotates the axis of the joystick by 45 degrees so that x and y are proportional to the powers to be given
        //to the mecanum axis. This arises from mecanum wheels exerting force at a diagonal to the direction they are pointing.
        double potentialRotatedAngle = angle - 45;
        double rotatedAngle = (potentialRotatedAngle >= 0) ? potentialRotatedAngle : potentialRotatedAngle + 2 * Math.PI;
        double rotatedX = Math.cos(rotatedAngle);
        double rotatedY = Math.sin(rotatedAngle);


        if(rotatedX > rotatedY) {
            rotatedY = magnitude * rotatedY/rotatedX;
            rotatedX = magnitude;
        }

        else {
            rotatedX = magnitude * rotatedX/rotatedY;
            rotatedY = magnitude;
        }

        Subsystems.instance.mecanumDriveSubsystem.setMotors(rotatedY + turn, rotatedX - turn,
                rotatedX + turn, rotatedY - turn);
    }

    @Override
    public boolean shouldRemove() {
        return false;
    }

    @Override
    public void end() {}
}
