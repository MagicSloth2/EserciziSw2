package LLM;

public class Rental{
    private Ski ski;
    private int days;
    public Rental(Ski ski, int days){
        this.ski = ski;
        this.days = days;
    }
    public int getDays(){
        return days;
    }
    public Ski getSki(){
        return ski;
    }
}