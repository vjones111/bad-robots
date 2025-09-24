package frc.robot.things;

public class Tomfoolery {
    long a;

    public long CubeMe() {
        return this.a * this.a * this.a;
    }

    public Tomfoolery Add(Tomfoolery rhs) {
        return new Tomfoolery(this.a + rhs.a);
    }

    public Tomfoolery() {
        this.a = 123;
    }

    public Tomfoolery(long g) {
        this.a = g;
    }       
}