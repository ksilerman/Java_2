package lesson1.maraphon;

public class Team {

   private String name;
   private Competitor[] competitors;

   public Team (String name, Competitor... competitors){
       this.name = name;
       this.competitors = competitors;
   }


    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void showResult () {
        System.out.println(name + " " + active);
       return ;
    }
}



