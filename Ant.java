import java.util.Random;

public class Ant extends Colony{
    private int age;

    Random rng = new Random();

    public Ant(){
        this.age = 0;
    }

    public void increaseAge(){
        this.age++;
        if(rng.nextInt(100) == 50 | this.age > ){

        }
    }
}
