package lesson1.maraphon;

public class Human implements Competitor {
    String name;

    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpHeigth;

    boolean active;

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxSwimDistance = 200;
        this.maxJumpHeigth = 30;
        this.active = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " успешно пробежал");
        } else {
            System.out.println("провал");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxRunDistance) {
            System.out.println(name + " успешно проплыл");
        } else {
            System.out.println("провал");
            active = false;
        }
    }

    @Override
    public void jump(int heigth) {
        if (heigth <= maxRunDistance) {
            System.out.println(name + " успешно перепрыгнул");
        } else {
            System.out.println("провал");
            active = false;
        }
    }

    @Override
    public boolean isDistance() {
        return active;
    }

    @Override
    public void info() {
        System.out.println(name + " " + active);
    }
}
