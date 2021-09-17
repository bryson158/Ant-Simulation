import java.io.FileNotFoundException;
import java.util.Random;

public class Larvae extends Ant{
    //Age in days
    private int age;
    //In days
    private int daysToEndOfLarvae;
    private boolean nanitic;

    Random rng = new Random();

    //Constructor for the larvae class
    public Larvae(Boolean nanitic) throws FileNotFoundException {
        this.age = 0;
        //Uses rng to determine when the larvae will hatch
        this.daysToEndOfLarvae = rng.nextInt(12-6)+6;
        this.nanitic = nanitic;
    }

    //TODO-remove debugging information when finished debugging.
    //Increases the age of the larvae
    public void increaseAge(){
        this.age++;
        if(this.age == daysToEndOfLarvae){
            this.removeLarvaeFromList(this);
            //System.out.println("Larvae Stage Ended");
        }
    }

    //Returns a boolean based on if it's time for the larvae to become a pupate.
    public boolean timeToPupate(){
        if(this.age == this.daysToEndOfLarvae){
            return true;
        }
        else {
            return false;
        }
    }

    //Random chance of the larvae dying
    public boolean randomDeath(){
        if(rng.nextInt(1000) == 600){
            return true;
        }
        return false;
    }

    //Get/Set methods as needed

    public boolean isNanitic(){
        return this.nanitic;
    }
}