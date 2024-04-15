import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class RecipeLoaderTest {

    @Test
    public void testGetSuggestedRecipe() {
        RecipeLoader recipeAPI = new RecipeLoader();

        List<RecipeByIngredientsResult> recipes = recipeAPI.getSuggestedRecipe("apple");
        assertNotNull(recipes);
        assertTrue(!recipes.isEmpty());

        List<RecipeByIngredientsResult> emptyRecipes = recipeAPI.getSuggestedRecipe("geen ingredient.");
        assertNotNull(emptyRecipes);
        assertTrue(emptyRecipes.isEmpty());
    }

    @Test
    public void testGetRecipeInformation() {
        RecipeLoader recipeAPI = new RecipeLoader();


        RecipeInformationResult recipeInfo = recipeAPI.getRecipeInformation("12345");
        assertNotNull(recipeInfo);
        assertNotNull(recipeInfo.getTitle());

        RecipeInformationResult emptyRecipeInfo = recipeAPI.getRecipeInformation("geen recept id.");
    }
}
