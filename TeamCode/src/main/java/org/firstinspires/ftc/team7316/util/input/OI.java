package org.firstinspires.ftc.team7316.util.input;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.team7316.commands.ClimbForPosition;
import org.firstinspires.ftc.team7316.commands.MovePlateServo;
import org.firstinspires.ftc.team7316.util.Constants;

/**
 * Created by andrew on 10/18/17.
 */

public class OI {

    public static OI instance = null;

    public GamepadWrapper gp1;
    public GamepadWrapper gp2;

    private OI(Gamepad gamepad1, Gamepad gamepad2) {

        gp1 = new GamepadWrapper(gamepad1);
        gp2 = new GamepadWrapper(gamepad2);

    }

    public static void createInputs(Gamepad gamepad1, Gamepad gamepad2) {
        instance = new OI(gamepad1, gamepad2);

        instance.gp2.a_button.onPressed(new MovePlateServo(true));
        instance.gp2.b_button.onPressed(new MovePlateServo(false));
        instance.gp2.x_button.onPressed(new ClimbForPosition(Constants.CLIMB_MOTOR_COMPACTED));
        instance.gp2.y_button.onPressed(new ClimbForPosition(Constants.CLIMB_MOTOR_EXTENDED));
    }

}
