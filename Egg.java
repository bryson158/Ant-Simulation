import java.util.Random;

public class Egg extends Ant{
    //Age in days
    private int age;
    private int daysUntilLarvae;

    Random rng = new Random();

    //Egg constructor
    public Egg(){
        this.age = 0;
        this.daysUntilLarvae = rng.nextInt(10-7)+7;
    }

    //Increases the age of the eggs
    public void increaseAge(){
        System.out.println("Age up");
        this.age++;
        if(timeToHatch()){
            this.makeNewLarvae(new Larvae());
            System.out.println("Egg has hatched");
            this.removeEggFromList(this);
        }
        else if(rng.nextInt(1000) == 600){
            System.out.println("Egg has died.");
            this.removeEggFromList(this);
        }
    }

    //Checks if it's time for the egg to hatch
    private boolean timeToHatch(){
        if(this.age == this.daysUntilLarvae){
            return true;
        }
        else {
            return false;
        }
    }
}
