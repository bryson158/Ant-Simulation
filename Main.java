import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        File myFile = new File("output.txt");

        System.out.println("How many months do you want the simulation to run?");
        int simLength = input.nextInt();
        int daysEnd = simLength * 30;
        //Creates the colony of fire ants
        Colony fireAnts = new Colony(false, simLength, true, true);

        for(int i = 0; i < daysEnd; i++){
            fireAnts.increaseDay();
        }
    }
}
