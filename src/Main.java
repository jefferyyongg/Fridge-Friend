import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void menuKeuze(){
        System.out.println("\nMenu:\n1. \uD83C\uDF5DRecept Opties\n2. ❄\uFE0FFridge Opties");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            menuKeuze();
            String input = scanner.nextLine();
            switch (input){
                case "1":
                    RecipePage recipePage = new RecipePage();
                    recipePage.loadPage(scanner);
                    break;
                case "2":
                    FridgePage fridgePage = new FridgePage();
                    fridgePage.loadPage(scanner);
                    break;
                default:
                    System.out.println("ongeldige invoer.");
            }
        }
    }
}