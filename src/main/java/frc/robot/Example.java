package frc.robot;

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
    }        
}
