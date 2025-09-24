package frc.robot.things;

// this was some random prep due 1/10/25
public class RocketShip {
    private double speed;

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double to) {
        this.speed = to;
    }

    public void Launch() {
        System.out.println("@ speed " + this.speed);
        System.out.println("Liftoff!");

        if (this.speed >= 100.) {
            System.out.println("rocket exploded");
        } 
    }
}
