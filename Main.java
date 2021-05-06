import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("How many months do you want the simulation to run?");
        int simLength = input.nextInt();
        int daysEnd = simLength * 30;
        System.out.println(daysEnd);
        //Creates the colony of fire ants
        Colony fireAnts = new Colony(false, true, simLength, true, true);

        for(int i = 0; i < daysEnd; i++){
            fireAnts.increaseDay();
        }
    }
}
