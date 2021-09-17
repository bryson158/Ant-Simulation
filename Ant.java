import java.io.FileNotFoundException;
import java.util.Random;

public class Ant extends Colony{
    //In days
    private int age;
    private boolean nanitic;

    Random rng = new Random();

    public Ant(boolean nanitic) throws FileNotFoundException {
        this.age = 0;
        this.nanitic = nanitic;
    }

    //Empty constructor
    public Ant() {
    }

    //Logic for a random death of the ant
    public boolean randomDeath(){
        //TODO- check if the ant randomly dies add logic to check if the ant is a nanitic and has an increased
        // likelihood of death
        return false;
    }
}
