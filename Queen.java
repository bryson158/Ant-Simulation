import java.io.FileNotFoundException;
import java.util.Random;

public class Queen extends Colony{
    //In Months
    private int age;
    private int ageInDays;
    //TODO- add logic and variable to check if the queen is a virgin
    private boolean neverLaidEggs;
    private boolean firstEggsHatched;

    Random rng = new Random();

    //Constructor for the queen
    public Queen(int age) throws FileNotFoundException {
        this.age = age;
        this.neverLaidEggs = true;
        this.ageInDays = rng.nextInt(30);
    }

    //Logic for if and how many eggs the queen will lay
    public int layingEggs(){
        //TODO- add better logic for the amount of eggs the queen lays.
        boolean isEggLayingDay;

        //This will lay the queens first set of eggs.
        if(neverLaidEggs){
            isEggLayingDay = false;
            int eggsToLay = rng.nextInt(5)+10;
            //TODO- remove this when debugging is finished.
            System.out.println("Should lay " + eggsToLay + " eggs this day. This is the first eggs the queen has laid");
            this.neverLaidEggs = false;
            return eggsToLay;
        }
        else if(rng.nextBoolean()){
            if(!this.firstEggsHatched){
                int eggsToLay = rng.nextInt(25-15)+15;

                System.out.println(eggsToLay + " eggs laid");
                //Returns the number of eggs that's to be laid.
                return eggsToLay;
            }
            else {
                int eggsToLay = rng.nextInt(100-50)+50;

                return eggsToLay;
            }
        }
        else {
            return 0;
        }
    }

    public void increaseAge(){
        this.ageInDays++;
        if(ageInDays >= 30){
            this.age++;
            this.ageInDays = 0;
        }
        //TODO-Add logic that the queen dies randomly very small chance.
    }
}