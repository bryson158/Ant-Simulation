import java.io.FileNotFoundException;
import java.util.Random;

public class Egg extends Colony{
    //Age in days
    private int age;
    private int daysUntilLarvae;
    private boolean nanitic;

    Random rng = new Random();

    //Egg constructor
    public Egg(boolean nanitic) throws FileNotFoundException {
        this.age = 0;
        this.daysUntilLarvae = rng.nextInt(10-7)+7;
        this.nanitic = nanitic;
    }

    //Increases the age of the eggs.
    /*public void increaseAge() throws FileNotFoundException {
        //System.out.println("Age up");
        this.age++;
        if(timeToHatch()){
            this.makeNewLarvae();;
            this.removeEggFromList(this);
        }
        else if(rng.nextInt(1000) == 600){
            this.removeEggFromList(this);
        }
    }*/

    //Checks if it's time for the egg to hatch
    public boolean timeToHatch(){
        if(this.age == this.daysUntilLarvae){
            return true;
        }
        else {
            return false;
        }
    }

    //Checks if the egg will have a random death currently is 1 in 1000 chance of random death
    public boolean randomDeath(){
        if(rng.nextInt(1000) == 600){
            return true;
        }
        return false;
    }

    public boolean isNanitic(){
        return this.nanitic;
    }
}
