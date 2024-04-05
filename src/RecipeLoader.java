import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RecipeLoader {
    public GetRecipeInformationResult getRecipeInformation(String id){
        GetRecipeInformationResult getRecipeInformationResult = new GetRecipeInformationResult();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.spoonacular.com/recipes/" + id + "/information?apiKey=511f0eda5ee6487ea63b21e8660d8a88"))
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                getRecipeInformationResult = gson.fromJson(response.body(), GetRecipeInformationResult.class);
                return getRecipeInformationResult;
            } else {
                System.out.println(response.statusCode());
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return getRecipeInformationResult;
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
