package lesson1.maraphon;

public class Cross extends Obstracle {
    int length;

    public Cross(int length) {
        this.length = length;
    }


    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}
