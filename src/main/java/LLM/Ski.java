package LLM;

public class Ski {
    public static final int MONO = 0;
    public static final int CARVING = 1;
    public static final int CHILDREN = 2;
    private String name;
    private int length;
    private int type;


    public Ski(String name, int length, int type){
        this.name = name;
        this.length = length;
        this.type = type;
    }
    public int getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }
}