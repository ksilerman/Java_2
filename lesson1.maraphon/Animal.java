package lesson1.maraphon;

public class Animal implements Competitor {
    String type;
    String name;

    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpHeigth;

    boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxSwimDistance, int maxJumpHeigth) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeigth = maxJumpHeigth;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance){
            System.out.println(type + " " +name+ " успешно пробежал");
        }else {
            System.out.println("провал");
            onDistance = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxRunDistance){
            System.out.println(type + " " +name+ " успешно проплыл");
        }else {
            System.out.println("провал");
            onDistance = false;
        }
    }

    @Override
    public void jump(int heigth) {
        if (heigth <= maxRunDistance){
            System.out.println(type + " " +name+ " успешно перепрыгнул");
        }else {
            System.out.println("провал");
            onDistance = false;
        }
    }

  /*  @Override
    public boolean isDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(type + " " +name+ " "+ onDistance);
    }
    */
}
