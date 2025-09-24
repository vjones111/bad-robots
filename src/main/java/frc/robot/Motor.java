package frc.robot;

import java.util.function.Function;

import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;

/**
 * our own diy wrapper around any motor class.
 * the spec said specifically a PWMVictorSPX, but i decided to be a little more useful
 *
 * the motor class interface is actually pretty nice.
 * so, if anyone ends up making pointless wrappers like this in production code, they need mental help
 */
public class Motor<M extends PWMMotorController> {
    private final M motor;

    // we don't actually need a power property, becuase this is just a shitty wrapper around a sane interface
    public double getPower() {
        return this.motor.get();
    }

    public void setPower(double power) {
        System.out.println("DEBUG: power set to " + power);
        this.motor.set(power);
    }
    
    // "motorFactory" god help us
    public Motor(Function<Integer, ? extends M> motorFactory, int channel) {
        this.motor = motorFactory.apply(channel);
    }
}
