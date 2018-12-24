package lesson1.maraphon;

public class Cource {

  private Obstracle[] c = {new Cross(80),new Wall(5),new Water(3)};

    public void doIt(Team team){
        for (Competitor competitor : team.getCompetitors()) {
            for (Obstracle obstracle : c)
            {
                if (competitor.isDistance())
                {
                obstracle.doIt(competitor);
                }
            }
        }
    }
}

