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

        // tomfoolery
        for (long i = 0; i < 100; i += ++i) {
            System.out.println("my number:" + (i + square(i)));
        }

        System.out.println(); // ouchie i broke the line

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

        System.out.println(); // ouchie i broke the line

        Food food = new Food("water");
        System.out.println("The food is the " + food.getName());
        food.Eat();
        System.out.println("The food is now " + food.getName());
    }
}
