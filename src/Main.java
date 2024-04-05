import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void menuKeuze(){
        System.out.println(
                "\nMenu:\n1. Zoek Recept\n2. Toevoegen Recept\n3. Bekijk Fridge\n4. Toevoegen Ingredient\n5. Verwijderen Ingredient\n6. Bekijk ReceptenBoek"
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeLoader recipeLoader = new RecipeLoader();
        FridgeLoader fridgeLoader = new FridgeLoader();
        RecipeBookLoader recipeBookLoader = new RecipeBookLoader();
        while(true){
            menuKeuze();
            String input = scanner.nextLine();
            List<String> fridge = fridgeLoader.loadFridge();
            switch(input){
                case "1":
                    System.out.println("Zoekterm?: \n");
                    String query = scanner.nextLine();
                    recipeLoader.getComplexSearch(query);
                    break;
                case "2":
                    System.out.println("Recipe ID?: \n");
                    String recipeID = scanner.nextLine();
                    recipeBookLoader.addRecipe(recipeID);
                    recipeLoader.getRecipeInformation(recipeID);
                    break;
                case "3":
                    System.out.println("Fridge:");
                    for(String s : fridge){
                        System.out.println(s);
                    }
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Welk ingredient wilt u toevoegen?: \n");
                    String addInput = scanner.nextLine();
                    fridgeLoader.addIngredient(addInput);
                    break;
                case "5":
                    for(String s : fridge){
                        System.out.print(s + "\n");
                    }
                    System.out.println("Welk ingredient wilt u verwijderen?: \n");

                    String removeInput = scanner.nextLine();
                    fridgeLoader.removeIngredient(removeInput);

                    break;
                case "6":
                    List<String> lines = recipeBookLoader.getRecipeBook();
                    for(int i = 0; i < lines.size(); i++){
                        System.out.println(i + ". " + recipeLoader.getRecipeInformation(lines.get(i)).getTitle());
                    }

                    System.out.println("Bekijk Recept Ingredienten:");

//                  System.out.println("\nRecept: " + recipeLoader.getRecipeInformation(s).getTitle());
//                        System.out.println("Ingredienten:");
//                        for(ExtendedIngredients e : recipeLoader.getRecipeInformation(s).getExtendedIngredients()){
//                            System.out.printf(
//                                            "______________________\n" +
//                                            "Title: %s\nAmount: %.2f\nUnit: %s\n", e.getName(), e.getAmount(), e.getUnit());
//                        }

                    break;
                default:
                    System.out.println("Ongeldige Invoer");
            }
        }
    }
}