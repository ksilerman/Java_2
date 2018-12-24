package lesson1.maraphon;

public class Cat extends Animal {
    public Cat(String name) {
        super("Кот", name, 200, 0, 20);
    }

    @Override
    public void swim(int dist) {
        System.out.println("Коты не умеют плавать");
    }
}
