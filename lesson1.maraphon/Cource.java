package lesson1.maraphon;

public class Cource {

    Obstracle[] c = {new Cross(80),new Wall(5),new Water(3)};

    public void doIt(Team team){
        for (Competitor competitor : team.getCompetitors()) {
            for (Obstracle obstracle : obstracles)
            { if (competitor.isDistance())
            { obstracle.doIt(competitor); } } } }
    }
}
