package lesson1.maraphon;

public class MainCross {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Bob"),
                new Cat("Vaska"),new Dog("Tuzik")};
        Obstracle[] obstracles = {new Cross(80),new Wall(5),new Water(3)};
        for(Competitor c: competitors){
            for(Obstracle o:obstracles ){
                o.doIt(c);
                if(!c.isDistance()){
                    break;
                }
            }
        }

        for(Competitor c:competitors){
            c.info();
        }

    }


}
