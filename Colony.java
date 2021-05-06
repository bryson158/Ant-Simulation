import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Colony {

    //If the ant species is polygynic then this will be true.
    private boolean polygyne;
    private ArrayList<Ant> listOfAnts = new ArrayList<>();
    private ArrayList<Queen> listOfQueens = new ArrayList<>();
    private Queen ColonyQueen;
    //Means there are not workers yet
    private boolean newColony;
    //Lists of objects
    private ArrayList<Egg> listOfEggs = new ArrayList<>();
    private ArrayList<Larvae> listOfLarvae = new ArrayList<>();
    private ArrayList<Pupate> listOfPupates = new ArrayList<>();
    private ArrayList<Worker> listOfWorkers = new ArrayList<>();
    boolean speciesHasMajors;
    boolean speciesHasSuperMajors;
    private int currentDay;
    private int currentMonth;
    private int endDay;
    private int endMonth;
    private boolean activeFoodSupply;

    public Colony(boolean polygyne, boolean newColony, int endMonth, boolean speciesHasSuperMajors,
                  boolean speciesHasMajors) {
        this.polygyne = polygyne;
        this.newColony = newColony;
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
            this.ColonyQueen = queen;
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

    public void increaseDay(){
        //Loops through the list of queens
        for(int i = 0; i < listOfQueens.size(); i++){
            listOfQueens.get(i).increaseAge();
        }
        System.out.println(listOfEggs.size());
        for(int i = 0; i < listOfEggs.size(); i++){
            listOfEggs.get(i).increaseAge();
            System.out.println(listOfEggs.size());
        }
        for(int i = 0; i < listOfLarvae.size(); i++){
            listOfLarvae.get(i).increaseAge();
        }
        for(int i = 0; i < listOfPupates.size(); i++){
            listOfPupates.get(i).increaseAge();
        }
    }

    public void increaseHour(){

    }

    public Colony() {
    }

    //Helper methods for the various Arraylists in the class.
    public int getEggListSize(){
        return listOfEggs.size();
    }

    public void addEggToEggList(Egg egg){
        listOfEggs.add(egg);
    }

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

    public void removeAntFromList(Ant ant){
        listOfAnts.remove(ant);
    }

    public void makeNewAnt(){
        //TODO- Add logic to determine the type of ant being added major super major or worker
        listOfAnts.add(new Ant());
    }

    public void makeNewLarvae(Larvae larvae){
        listOfLarvae.add(larvae);
    }

    public void makeNewPupate(Pupate pupate){
        listOfPupates.add(pupate);
    }

    //Get/set methods added as needed
    public boolean getActiveFoodSupply(){
        return this.activeFoodSupply;
    }
}
