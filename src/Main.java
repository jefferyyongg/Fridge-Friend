import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void menuKeuze(){
        System.out.println("\nMenu:\n1. Recept Opties\n2. Fridge Opties");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeLoader recipeLoader = new RecipeLoader();
        FridgeLoader fridgeLoader = new FridgeLoader();
        RecipeBookLoader recipeBookLoader = new RecipeBookLoader();
        List<String> lines = recipeBookLoader.getRecipeBook();
        while(true){
            menuKeuze();
            String input = scanner.nextLine();
            List<String> fridge = fridgeLoader.loadFridge();
            switch (input){
                case "1":
                    System.out.println("\nMenu:\n1. Zoek Recept\n2. Toevoegen Recept\n3. Verwijder Recept\n4. Bekijk ReceptenBoek\n5. ReceptSuggesties(gebaseerd op voorraad)\n");
                    String receptInvoer = scanner.nextLine();
                    switch(receptInvoer){
                        case "1":
                            System.out.println("Zoekterm?: \n");
                            String query = scanner.nextLine();
                            recipeLoader.getComplexSearch(query);
                            break;
                        case "2":
                            System.out.println("Recipe ID?: \n");
                            String recipeID = scanner.nextLine();
                            recipeBookLoader.addRecipe(recipeID);
                            break;
                        case "3":
                            for(int i = 0; i < lines.size(); i++){
                                System.out.println(i + ". " + recipeLoader.getRecipeInformation(lines.get(i)).getTitle());
                            }
                            String removeInvoer = scanner.nextLine();
                            lines.remove(recipeBookLoader.getRecipeBook().get(Integer.valueOf(removeInvoer)));
                            recipeBookLoader.removeRecipe(lines);
                            break;
                        case "4":
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
                                    System.out.printf("\n%s\nAmount: %.2f\nUnit: %s\n", e.getName(), e.getAmount(), e.getUnit());
                                }
                                System.out.println();
                                break;
                            }
                            break;
                        case "5":
                            List<String> ingredients = fridgeLoader.loadFridge();
                            String line = "";
                            for(String s : ingredients){
                                line += s + ",";
                            }
                            List<RecipeByIngredientsResult> recipes = recipeLoader.getSuggestedRecipe(line);
                            System.out.println("=== Recipe Suggestions ===");
                            for (RecipeByIngredientsResult recipe : recipes) {
                                System.out.printf("\nID: %d | Title: %s\n", recipe.getId(), recipe.getTitle());

                                System.out.printf("✅ Used Ingredients: %d\n", recipe.getUsedIngredientCount());
                                for(ExtendedIngredients e : recipe.getUsedIngredients()){
                                    System.out.printf("%s\nAmount: %.2f\nUnit: %s", e.getName(), e.getAmount(), e.getUnit());
                                }
                                System.out.println();

                                System.out.printf("❌ Missed Ingredients: %d\n", recipe.getMissedIngredientCount());
                                for(ExtendedIngredients e : recipe.getMissedIngredients()){
                                    System.out.printf("%s\nAmount: %.2f\nUnit: %s", e.getName(), e.getAmount(), e.getUnit());
                                }
                                System.out.println();
                            }

                            break;

                        default:
                            System.out.println("Ongeldige Invoer");
                            break;
                    }
                    break;
                case "2":
                    System.out.println("\nMenu:\n1. Bekijk Fridge\n2. Toevoegen Ingredient\n3. Verwijderen Ingredient\n");
                    String fridgeInvoer = scanner.nextLine();
                    switch(fridgeInvoer){
                        case "1":
                            System.out.println("Fridge:");
                            for(String s : fridge){
                                System.out.println(s);
                            }
                            System.out.println();
                            break;
                        case "2":
                            System.out.println("Welk ingredient wilt u toevoegen?: \n");
                            String addInput = scanner.nextLine();
                            fridgeLoader.addIngredient(addInput);
                            break;
                        case "3":
                            for(String s : fridge){
                                System.out.print(s + "\n");
                            }
                            System.out.println("Welk ingredient wilt u verwijderen?: \n");

                            String removeInput = scanner.nextLine();
                            fridgeLoader.removeIngredient(removeInput);
                            break;
                        default:
                            System.out.println("Ongeldige Invoer");
                            break;
                    }
            }
        }
    }
}