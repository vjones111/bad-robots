package frc.robot;

// all of them
import frc.robot.things.*;

public class Example {
    private static long square(long a) {
        return a * a;
    }
    public static void main(String[] argv) {
        for (String arg : argv) {
            System.out.println("argv has " + arg);
        }

        for (long i = 0; i < 100; i += ++i) {
            System.out.println("my number:" + (i + square(i)));
        }

        Tomfoolery ta = new Tomfoolery();
        Tomfoolery tb = new Tomfoolery(10);
        System.out.println(
            "hello world but again!! " +
            tb.CubeMe() +
            " but " +
            ta.Add(tb).CubeMe()
        );

        
        Triangle tri = new Triangle(5, 12);
        System.out.println(
            "hypot of " +
            tri.x + ", " +
            tri.y + ": " +
            tri.hypot()
        );
    }        
}
