import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FridgePage extends Page {
    public void loadPage(Scanner scanner){
        RecipeLoader recipeLoader = new RecipeLoader();
        FridgeLoader fridgeLoader = new FridgeLoader();
        RecipeBookLoader recipeBookLoader = new RecipeBookLoader();
        List<String> fridge = fridgeLoader.loadFridge();

        System.out.println("\nMenu:\n1. Bekijk Fridge\n2. Toevoegen Ingredient\n3. Verwijderen Ingredient\n4. ReceptSuggesties(gebaseerd op voorraad)\n5. Missed Ingredienten(Recepboek ingredienten - Fridge ingredienten)");
        String fridgeInvoer = scanner.nextLine();
        switch(fridgeInvoer){
            case "1":
                System.out.println("=== Fridge ===");
                for(String s : fridge){
                    System.out.println(s);
                }
                System.out.println();
                break;
            case "2":
                System.out.println("=== Ingredient Toevoegen ===");
                System.out.println("Welk ingredient wilt u toevoegen?: \n");
                String addInput = scanner.nextLine();
                fridgeLoader.addIngredient(addInput);
                break;
            case "3":
                System.out.println("=== Ingredient Verwijderen ===");
                for(String s : fridge){
                    System.out.print(s + "\n");
                }
                System.out.println("Welk ingredient wilt u verwijderen?: \n");

                String removeInput = scanner.nextLine();
                fridgeLoader.removeIngredient(removeInput);
                break;
            case "4":
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
                        System.out.printf("Name: %s | Amount: %.2f | Unit: %s\n", e.getName(), e.getAmount(), e.getUnit());
                    }
                    System.out.println();

                    System.out.printf("❌ Missed Ingredients: %d\n", recipe.getMissedIngredientCount());
                    for(ExtendedIngredients e : recipe.getMissedIngredients()){
                        System.out.printf("Name: %s | Amount: %.2f | Unit: %s\n", e.getName(), e.getAmount(), e.getUnit());
                    }
                    System.out.println();
                }
                break;
            case "5":
                List<String> recipeBookIngredients = recipeBookLoader.getRecipeBook();
                ArrayList<ExtendedIngredients> fullIngredients = new ArrayList<>();
                for(String s: recipeBookIngredients){
                    for(ExtendedIngredients e : recipeLoader.getRecipeInformation(s).getExtendedIngredients()){
                        fullIngredients.add(e);
                    }
                }

                for(int i = 0; i < fullIngredients.size(); i++){
                    for(int j = 0; j < fridge.size(); j++){
                        if(fullIngredients.get(i).getName().contains(fridge.get(j))){
                            fullIngredients.remove(i);
                        }
                    }
                }

                System.out.println("=== Missed Ingredients ===");
                for(ExtendedIngredients e : fullIngredients){
                    System.out.printf("Name: %s | Amount: %.2f | Unit: %s\n", e.getName(), e.getAmount(), e.getUnit());
                }
                break;
            default:
                System.out.println("Ongeldige Invoer");
                break;
        }
    }
}
