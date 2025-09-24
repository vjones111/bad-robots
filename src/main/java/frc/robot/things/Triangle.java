package frc.robot.things;

public class Triangle {
    public double x;
    public double y;

    // temu Math.hypot
    public double hypot() {
        return Math.sqrt(x*x + y*y);
    }

    public Triangle(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
