import java.util.Arrays;

public class Minions {

    private String name;
    private double height;
    private int numberEvilDeeds;

    public Minions(String name){
        this.setName(name);
        this.height = 0;
        this.numberEvilDeeds = 0;
    }

    public Minions(String name, double height){
        this.setName(name);
        this.setHeight(height);
        this.numberEvilDeeds = 0;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public int getNumberEvilDeeds() {
        return numberEvilDeeds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setNumberEvilDeeds(int numberEvilDeeds) {
        this.numberEvilDeeds = numberEvilDeeds;
    }

    @Override
    public String toString() {
        return "Minions{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", numberEvilDeeds=" + numberEvilDeeds +
                '}';
    }

    //    public static void main(String[] args){
//        String name = "steve rogers";
//        Minions steve = new Minions(name);
//        System.out.println(steve.getName());
//    }

}
