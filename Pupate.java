import java.io.FileNotFoundException;
import java.util.Random;

public class Pupate extends Ant{
    private int age;
    private int daysToHatch;

    Random rng = new Random();

    //Constructor for the pupate
    public Pupate() throws FileNotFoundException {
        this.age = 0;
        this.daysToHatch = rng.nextInt();
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
}
