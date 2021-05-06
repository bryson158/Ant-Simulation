import java.util.Random;

public class Larvae extends Ant{
    //Age in days
    private int age;
    //In days
    private int daysToEndOfLarvae;

    Random rng = new Random();

    public Larvae(){
        this.age = 0;
        //Uses rng to determine when the larvae will hatch
        this.daysToEndOfLarvae = rng.nextInt(12-6)+6;
    }

    //Increases the age of the larvae
    public void increaseAge(){
        this.age++;
        if(rng.nextInt(1000) == 600){
            this.removeLarvaeFromList(this);
        }
    }
}
