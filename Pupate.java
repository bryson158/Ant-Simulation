import java.io.FileNotFoundException;
import java.util.Random;

public class Pupate extends Ant{
    private int age;
    private int daysToHatch;
    private boolean nanitic;

    Random rng = new Random();

    //Constructor for the pupate
    public Pupate(boolean nanitic) throws FileNotFoundException {
        this.age = 0;
        //TODO- add logic to determine a range of days in which the pupate may become an ant
        this.daysToHatch = rng.nextInt();
        this.nanitic = nanitic;
    }

    public void increaseAge() throws FileNotFoundException {
        this.age++;
    }

    public boolean timeToHatch(){
        if(age == daysToHatch){
            return true;
        }
        return false;
    }

    public boolean randomDeath(){
        if(rng.nextInt(1000) == 600){
            return true;
        }
        return false;
    }

    public boolean isNanitic(){
        return nanitic;
    }
}
