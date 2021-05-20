import java.io.FileNotFoundException;

public class Worker extends Ant{
    //in days
    private int age;

    public Worker() throws FileNotFoundException {
    }

    public void increaseAge(){
        this.age++;
        //TODO-add logic that kills the ant randomly the older the ant the more likely they are to die.
        //TODO- possibly kill the ant if it reaches a certain age.
    }
}
