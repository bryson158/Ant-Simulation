import java.util.Random;

public class Egg extends Ant{
    //Age in days
    private int age;
    private boolean firstEggsLaid;
    private int daysUntilLarvae;

    Random rng = new Random();

    //Egg constructor
    public Egg(int age, boolean firstEggsLaid){
        this.age = age;
        this.firstEggsLaid = firstEggsLaid;
        this.daysUntilLarvae = rng.nextInt(10-7)+7;
    }

    //Increases the age of the eggs
    public void increaseAge(){
        this.age++;
        if(timeToHatch()){
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
