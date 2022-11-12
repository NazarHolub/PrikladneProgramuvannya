package Commands;

public class ShowActionsCommand implements Command{
    @Override
    public void execute(){
        System.out.println("Choose an action: ");
        System.out.println("1 show necklace");
        System.out.println("2 add stone to necklace");
        System.out.println("3 write to file");
        System.out.println("4 read from file");
        System.out.println("5 sort necklace by price");
        System.out.println("6 Show necklace cost");
        System.out.println("7 Show necklace weight");
        System.out.println("0 exit");
    }
}
