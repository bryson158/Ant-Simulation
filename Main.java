import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        File myFile = new File("output.txt");

        File output = new File("output.txt");
        FileWriter writer = new FileWriter(output);

        if(!myFile.exists()){
            myFile.createNewFile();
        }

        System.out.println("How many months do you want the simulation to run?");
        int simLength = input.nextInt();
        int daysEnd = simLength * 30;
        //Creates the colony of fire ants
        Colony fireAnts = new Colony(false, simLength, true, true);

        //Increases the day for the colony
        for(int i = 0; i < daysEnd; i++){
            fireAnts.increaseDay(i,writer);
        }

        writer.flush();
    }
}
