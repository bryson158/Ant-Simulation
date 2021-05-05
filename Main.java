import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Colony fireAnts = new Colony("Fire Ant", false, true);
        System.out.println("How many months do you want the simulation to run?");
        int simLength = input.nextInt();

        int days = simLength * 30;
    }
}
