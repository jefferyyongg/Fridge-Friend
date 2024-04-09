import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RecipeLoader {

    public List<RecipeByIngredientsResult> getSuggestedRecipe(String ingredients){
        List<RecipeByIngredientsResult> recipes = new ArrayList<>();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.spoonacular.com/recipes/findByIngredients?ingredients=" + ingredients + "&apiKey=511f0eda5ee6487ea63b21e8660d8a88"))
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                Type recipeListType = new TypeToken<List<RecipeByIngredientsResult>>(){}.getType();
                recipes = gson.fromJson(response.body(), recipeListType);
                return recipes;
            } else {
                System.out.println(response.statusCode());
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    public RecipeInformationResult getRecipeInformation(String id){
        RecipeInformationResult recipeInformationResult = new RecipeInformationResult();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.spoonacular.com/recipes/" + id + "/information?apiKey=511f0eda5ee6487ea63b21e8660d8a88"))
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                recipeInformationResult = gson.fromJson(response.body(), RecipeInformationResult.class);
                return recipeInformationResult;
            } else {
                System.out.println(response.statusCode());
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return recipeInformationResult;
    }

    public void getComplexSearch(String query){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.spoonacular.com/recipes/complexSearch?apiKey=511f0eda5ee6487ea63b21e8660d8a88&query=" + query))
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                ComplexSearch complexSearch = gson.fromJson(response.body(), ComplexSearch.class);
                for(ComplexSearchResult c : complexSearch.getResults()){
                    System.out.printf("ID: %d\nTitle: %s\n", c.getId(), c.getTitle());
                    System.out.println();
                }
            } else {
                System.out.println(response.statusCode());
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
