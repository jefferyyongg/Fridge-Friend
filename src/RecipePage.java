import java.util.List;
import java.util.Scanner;

public class RecipePage extends Page {
    RecipeLoader recipeLoader = new RecipeLoader();
    RecipeBookLoader recipeBookLoader = new RecipeBookLoader();
    List<String> lines = recipeBookLoader.getRecipeBook();
    public void loadPage(Scanner scanner){
        System.out.println("\nMenu:\n1. Zoek Recept\n2. Toevoegen Recept\n3. Verwijder Recept\n4. Bekijk ReceptenBoek\n");
        String receptInvoer = scanner.nextLine();
        switch(receptInvoer){
            case "1":
                System.out.println("=== Recept Zoeken ===");
                System.out.println("Zoekterm?: \n");
                String query = scanner.nextLine();
                recipeLoader.getComplexSearch(query);
                break;
            case "2":
                System.out.println("=== Recept Toevoegen ===");
                System.out.println("Recipe ID?: \n");
                String recipeID = scanner.nextLine();
                recipeBookLoader.addRecipe(recipeID);
                break;
            case "3":
                if(recipeBookLoader.getRecipeBook().isEmpty()){
                    System.out.println("Geen recepten.");
                    break;
                }
                System.out.println("=== Recept Verwijderen ===");
                for(int i = 1; i < recipeBookLoader.getRecipeBook().size() + 1; i++){
                    System.out.println(i + ". " + recipeLoader.getRecipeInformation(recipeBookLoader.getRecipeBook().get(i - 1)).getTitle());
                }
                String removeInvoer = scanner.nextLine();
                if(Integer.valueOf(removeInvoer) > recipeBookLoader.getRecipeBook().size() || Integer.valueOf(removeInvoer) <= 0){
                    System.out.println("Ongeldige invoer.");
                    break;
                }
                lines.remove(recipeBookLoader.getRecipeBook().get(Integer.valueOf(removeInvoer) - 1));
                recipeBookLoader.removeRecipe(lines);
                break;
            case "4":
                System.out.println("=== Recepten Boek ===");
                if(recipeBookLoader.getRecipeBook().isEmpty()){
                    System.out.println("Geen recepten.");
                    break;
                }
                while(true){
                    for(int i = 0; i < recipeBookLoader.getRecipeBook().size(); i++){
                        System.out.println(i + ". " + recipeLoader.getRecipeInformation(recipeBookLoader.getRecipeBook().get(i)).getTitle());
                    }

                    System.out.println("\nSelecteer Recept:");
                    int receptInput = Integer.valueOf(scanner.nextLine());
                    if(receptInput > recipeBookLoader.getRecipeBook().size() - 1){
                        System.out.println("Ongeldige Invoer");
                        break;
                    }

                    System.out.println("Title: " + recipeLoader.getRecipeInformation(recipeBookLoader.getRecipeBook().get(receptInput)).getTitle());
                    System.out.println("Ingredienten: ");
                    for(ExtendedIngredients e : recipeLoader.getRecipeInformation(recipeBookLoader.getRecipeBook().get(receptInput)).getExtendedIngredients()){
                        System.out.printf("Name: %s | Amount: %.2f | Unit: %s\n", e.getName(), e.getAmount(), e.getUnit());
                    }
                    System.out.println();
                    break;
                }
                break;
            default:
                System.out.println("Ongeldige Invoer");
                break;
        }
    }
}
