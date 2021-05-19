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
        if(rng.nextInt(1000) == 600){
            this.removePupateFromList(this);
            System.out.println("Pupate has died.");
        }
        if(age == daysToHatch){
            this.removePupateFromList(this);
            this.addAntToList(new Ant());
            System.out.println("Pupate Hatched");
        }
    }
}
