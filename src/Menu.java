import java.util.List;
import java.util.Scanner;

public class Menu {
    private String title = "CMPT 213 MENU NEW LENGTH";
    private String[] options = {
            /*1*/"List minions",
            /*2*/"Add a new minion",
            /*3*/"Remove Minion",
            /*4*/"Attribute an evil deed to a minion",
            /*5*/"Debug dump of minion details",
            /*6*/"exit"};
    private List<Minions> listOfMinions;


    public Menu(List<Minions> listOfMinions){
        this.listOfMinions = listOfMinions;
        Scanner input = new Scanner(System.in);
        int option;

        while( true ){
            printMenu();
            System.out.print("Enter an option: ");
            option = input.nextInt();
            switch (option){
                case 1:
                    listMinions(listOfMinions);
                    break;
                case 2:
                    addMinion(listOfMinions);
                    break;
                case 3:
                    if (listOfMinions.isEmpty()) System.out.println("No minions found.");
                    removeMinion(listOfMinions);

                    break;
                case 4:
                    attributeEvilDeed(listOfMinions);
                    break;
                case 5:
                    debugMinionDetails(listOfMinions);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("INVALID OPTION.");
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void printMenu(){
        printTitle();
        printOptions();
    }

    private void printOptions(){
        int numOfOptions = options.length+1;
        for ( int i = 1; i < numOfOptions; i++ ){
            System.out.println("[" + i +"] " + options[i-1]);
        }
    }

    private void listMinions(List<Minions> listOfMinions){
        int minionNumber = 1;
        for (Minions minion: listOfMinions){
            System.out.println("List of Minions:");
            System.out.println("****************");
            System.out.println(
                    minionNumber +
                            ". Name: " + minion.getName() +
                            " Height: " + minion.getHeight() +
                            " # Evil Deeds: " + minion.getNumberEvilDeeds());
            minionNumber++;
        }
    }

    private void addMinion(List<Minions> listOfMinions){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter Height: ");
        double height = input.nextDouble();
        listOfMinions.add(new Minions(name,height));
    }

    private void removeMinion(List<Minions> listOfMinions){
        listMinions(listOfMinions);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Minion Number: ");
        int minionNumber = input.nextInt();
        while ( minionNumber < 0 ) {
            System.out.println("Please enter valid minion number greater than 0 or 0 to cancel.");
            minionNumber = input.nextInt();
        }
        if (minionNumber > 0 ) listOfMinions.remove(minionNumber-1);
        else printMenu();
    }

    private void attributeEvilDeed(List<Minions> listOfMinions){
        listMinions(listOfMinions);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Minion Number: ");
        int minionNumber = input.nextInt();
        while ( minionNumber < 0 ) {
            System.out.println("Please enter valid minion number greater than 0 or 0 to cancel.");
            minionNumber = input.nextInt();
        }
        if (minionNumber > 0 ) {
            Minions minion = listOfMinions.get(minionNumber - 1);
            minion.setNumberEvilDeeds(minion.getNumberEvilDeeds() + 1);
        }
    }

    private void debugMinionDetails(List<Minions> listOfMinions){
        System.out.println(listOfMinions.toString());
    }

    private void printTitle(){
        int length = title.length()+4;
        for ( int i = 0; i < length; i++ ){
            System.out.print("*");
        }
        System.out.print("\n* " + getTitle() + " *\n");
        for ( int i = 0; i < length; i++ ){
            System.out.print("*");
        }
        System.out.println();
    }


}
