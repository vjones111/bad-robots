package frc.robot.things;

public class Fruit extends Food {
    // constructor
    public Fruit(String name) {
        super(name);
    }

    @Override
    public void Eat() {
        System.out.println("what is " + this.name + "? wait it's fruit???? i only eat water");
        this.name = "not an " + this.name;
    }
}
