import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Colony {
    //Colony class for the ants
    private String typeOfAnt;
    //If the ant species is polygynic then this will be true.
    private boolean polygyne;
    private ArrayList<Ant> listOfAnts = new ArrayList<>();
    private ArrayList<Queen> listOfQueens = new ArrayList<>();
    private Queen ColonyQueen;
    //Means there are not workers yet
    private boolean newColony;
    private ArrayList<Egg> listOfEggs = new ArrayList<>();
    private ArrayList<Larvae> listOfLarvae = new ArrayList<>();

    public Colony(String typeOfAnt, boolean polygyne, boolean newColony) {
        this.typeOfAnt = typeOfAnt;
        this.polygyne = polygyne;
        this.newColony = newColony;

        Scanner input = new Scanner(System.in);
        Random rng = new Random();

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
                listOfQueens.add(new Queen(rng.nextInt((9*12))+12));
            }
        }
    }

    public Colony() {
    }
}
