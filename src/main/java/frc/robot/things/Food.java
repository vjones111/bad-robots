package frc.robot.things;

public class Food {
    private String name;

    public String getName() {
        return this.name;
    }

    public Food(String name) {
        this.name = name;
    }

    public void Eat() {
        System.out.println("mmm yummy " + this.name);
        this.name = null;
    }
}
