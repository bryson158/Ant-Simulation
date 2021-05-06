import java.util.Random;

public class Queen extends Colony{
    //In Months
    private int age;
    private int ageInDays;
    //TODO- add logic and variable to check if the queen is a virgin
    private boolean neverLaidEggs;

    Random rng = new Random();

    //Constructor for the queen
    public Queen(int age) {
        this.age = age;
        this.neverLaidEggs = true;
        this.ageInDays = rng.nextInt(30);
    }

    //Logic for if and how many eggs the queen will lay
    private void layingEggs(){
        boolean isEggLayingDay;

        //This will lay the queens first set of eggs.
        if(neverLaidEggs){
            isEggLayingDay = false;
            int eggsToLay = rng.nextInt(5)+10;

            for(int i = 0; i < eggsToLay; i++){
                addEggToEggList(new Egg(0, true));
            }
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