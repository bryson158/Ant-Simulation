import java.io.FileNotFoundException;
import java.util.Random;

public class Ant extends Colony{
    //In days
    private int age;

    Random rng = new Random();

    public Ant() throws FileNotFoundException {
        this.age = 0;
    }
}
