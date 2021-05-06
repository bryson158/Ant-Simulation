import java.util.Random;

public class Pupate extends Ant{
    private int age;
    private int daysToHatch;

    Random rng = new Random();

    //Constructor for the pupate
    public Pupate(){
        this.age = 0;
        this.daysToHatch = rng.nextInt();
    }

    public void increaseAge(){
        this.age++;
        if(rng.nextInt(1000) == 600){
            this.removePupateFromList(this);
        }
        if(age == daysToHatch){
            this.
        }
    }
}
