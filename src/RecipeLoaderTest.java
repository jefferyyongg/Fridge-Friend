import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class RecipeLoaderTest {

    @Test
    public void testGetSuggestedRecipe() {
        RecipeLoader recipeAPI = new RecipeLoader();

        List<RecipeByIngredientsResult> recipes = recipeAPI.getSuggestedRecipe("apple");
        assertNotNull(recipes);
        assertFalse(recipes.isEmpty());
    }

    @Test
    public void testGetRecipeInformation() {
        RecipeLoader recipeAPI = new RecipeLoader();


        RecipeInformationResult recipeInfo = recipeAPI.getRecipeInformation("12345");
        assertNotNull(recipeInfo);
        assertNotNull(recipeInfo.getTitle());
    }
}
