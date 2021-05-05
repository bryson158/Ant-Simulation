import java.util.Random;

public class Queen extends Colony{
    //In Months
    int age;
    //TODO- add logic and variable to check if the queen is a virgin
    boolean neverLaidEggs;

    Random rng = new Random();

    //Constructor for the queen
    public Queen(int age) {
        this.age = age;
        this.neverLaidEggs = true;
    }

    //Logic for if and how many eggs the queen will lay
    private void layingEggs(){
        boolean isEggLayingDay;

        //This will lay the queens first set of eggs.
        if(neverLaidEggs){
            isEggLayingDay = false;
            int eggsToLay = rng.nextInt(6)+10;

            for(int i = 0; i < eggsToLay; i++){
                addEggToEggList(new Egg(0, true));
            }
        }
    }
}