import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Colony {

    //If the ant species is polygynic then this will be true.
    private boolean polygyne;
    private ArrayList<Ant> listOfAnts = new ArrayList<>();
    private ArrayList<Queen> listOfQueens = new ArrayList<>();
    //Lists of objects
    private ArrayList<Egg> listOfEggs = new ArrayList<>();
    private ArrayList<Larvae> listOfLarvae = new ArrayList<>();
    private ArrayList<Pupate> listOfPupates = new ArrayList<>();
    private ArrayList<Worker> listOfWorkers = new ArrayList<>();
    private boolean speciesHasMajors;
    private boolean speciesHasSuperMajors;
    private int endDay;
    private int endMonth;
    private boolean activeFoodSupply;

    Random rng = new Random();

    public Colony(boolean polygyne, int endMonth, boolean speciesHasSuperMajors, boolean speciesHasMajors)
            throws FileNotFoundException {
        this.polygyne = polygyne;
        this.endMonth = endMonth;
        //Converts the end month into the number of days that the sim will run
        this.endDay = 30*endMonth;
        this.activeFoodSupply = false;
        this.speciesHasSuperMajors = speciesHasSuperMajors;
        this.speciesHasMajors = speciesHasMajors;

        Scanner input = new Scanner(System.in);
        Random rng = new Random();

        //If the colony only has one queen this will not create more
        if(polygyne == false){
            Queen queen = new Queen(12);
            listOfQueens.add(queen);
        }
        else {
            System.out.println("How many queens are in the colony?");
            int queens = input.nextInt();

            for(int i = 0; i < queens; i++){
                //Sets the months of the age of the queen to not go over 9 years and not be less than a year
                // old in total
                listOfQueens.add(new Queen(1));
            }
        }
    }

    //Increases the day for all ants in the colony
    //TODO- Consider making this multithreaded
    //TODO- remove the debugging stuff here as needed.
    public void increaseDay(int day, FileWriter writer) throws IOException {
        int eggsToLay = 0;

        writer.write("Day: " + day+1 + "\n");

        int eggsHatchedToday = 0;
        int eggsDiedToday = 0;
        //Loops through the list of queens
        for (Queen listOfQueen : listOfQueens) {
            listOfQueen.increaseAge();
            eggsToLay += listOfQueen.layingEggs();
        }
        //Lays the eggs
        layEggs(eggsToLay);

        //TODO- make lists for the objects that need to be deleted and then loop through them and remove them from the lists

        //Ages up the eggs
        for(int i = 0; i < listOfEggs.size()-1; i++){
            listOfEggs.get(i).increaseAge();
            //Hatches an egg if needed
            if(listOfEggs.get(i).timeToHatch()){
                makeNewLarvae();
                eggsHatchedToday++;
                listOfEggs.remove(listOfEggs.get(i));
                //System.out.println("Egg Hatched");
            }
            //Determines if the egg randomly dies
            else if(listOfEggs.get(i).randomDeath()){
                eggsDiedToday++;
                listOfEggs.remove(listOfEggs.get(i));
                //System.out.println("Egg died");
            }
        }

        //Writes information to the output file
        writer.write(eggsHatchedToday + "- Eggs hatched today \n");
        System.out.println(eggsHatchedToday + "- eggs hatched today");

        //This was added for efficiency of memory
        if(eggsDiedToday > 0){
            writer.write(eggsDiedToday + "- Eggs Died today \n");
        }
        writer.write(listOfEggs.size() + "- Eggs in the colony \n");

        int larvaeHatchedToday = 0;
        int larvaeDiedToday = 0;

        //Increases the age for the larvae
        for(int i = 0; i < listOfLarvae.size()-1; i++){
            listOfLarvae.get(i).increaseAge();
            //Checks if it is time for a larvae to become a pupate
            if(listOfLarvae.get(i).timeToPupate()){
                makeNewPupate();
                larvaeHatchedToday++;
                listOfLarvae.remove(listOfLarvae.get(i));
                continue;
            }
            //logic for a random death of a larvae
            if(listOfLarvae.get(i).randomDeath()){
                larvaeDiedToday++;
                listOfLarvae.remove(listOfLarvae.get(i));
            }
        }

        //TODO- make the file writer work properly and uncomment this as needed
        //writer.write(larvaeHatchedToday + "- became pupates \n");
        System.out.println(larvaeHatchedToday + "- larvae hatched");
        //Checks if there was any larvae that died
        if(larvaeDiedToday > 0){
            //TODO- make the file writer work properly and uncomment this as needed
            //writer.write(larvaeDiedToday + "- larvae died");
            System.out.println(larvaeDiedToday + "- larvae died today");
        }
        //Checks if there is any larvae in the list for efficiency
        if(listOfLarvae.size() > 0){
            //TODO- make the file writer work properly and uncomment this as needed
            //writer.write(listOfLarvae.size() + "- larvae in the colony\n");
            System.out.println(listOfLarvae.size() + "- larvae in the colony");
        }

        int pupateToAnts = 0;
        int pupatesDied = 0;

        //Increases the ages for the pupates
        for(int i = 0; i < listOfPupates.size()-1; i++){
            listOfPupates.get(i).increaseAge();
            if(listOfPupates.get(i).timeToHatch()){
                pupateToAnts++;
                makeNewAnt();
                listOfPupates.remove(listOfPupates.get(i));
                continue;
            }
            if(listOfPupates.get(i).randomDeath()){
                pupatesDied++;
                listOfPupates.remove(listOfPupates.get(i));
            }
        }

        writer.write(pupateToAnts + "- pupate(s) became ants\n");

        if(pupatesDied > 0){
            //TODO- make the file writer work properly and uncomment this as needed
            //writer.write(pupatesDied + "- pupate(s) died\n");
            System.out.println(pupatesDied + " pupates died today");
        }
        //Debugging information for the sim
        if(listOfPupates.size() > 0){
            //TODO- make the file writer work properly and uncomment this as needed
            //writer.write(listOfPupates.size() + "- pupates in the colony");
            System.out.println(listOfPupates.size() + " pupates in the colony");
        }

        writer.flush();
    }

    public Colony(){
    }

    //Lays the number of eggs the queens are laying for the day
    private void layEggs(int num) throws FileNotFoundException {
        for(int i = 0; i < num; i++){
            listOfEggs.add(new Egg());
        }
    }



    //Helper methods
    public void removeEggFromList(Egg egg){
        listOfEggs.remove(egg);
    }

    public void removeLarvaeFromList(Larvae larvae){
        listOfLarvae.remove(larvae);
    }

    public void removePupateFromList(Pupate pupate){
        listOfPupates.remove(pupate);
    }

    public void addAntToList(Ant ant){
        listOfAnts.add(ant);
    }

    public void makeNewAnt() throws FileNotFoundException{
        //TODO- Add logic to determine the type of ant being added major super major or worker
        listOfAnts.add(new Ant());
    }

    public void makeNewLarvae() throws FileNotFoundException {
        listOfLarvae.add(new Larvae());
    }

    public void makeNewPupate() throws FileNotFoundException {
        listOfPupates.add(new Pupate());
    }

    //Get/set methods added as needed
    public boolean getActiveFoodSupply(){
        return this.activeFoodSupply;
    }
}