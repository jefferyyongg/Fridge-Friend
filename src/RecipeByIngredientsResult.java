import java.util.List;

public class RecipeByIngredientsResult {
    private int id;
    private String title;
    private int likes;
    private int usedIngredientCount;
    private int missedIngredientCount;
    private List<ExtendedIngredients> missedIngredients;
    private List<ExtendedIngredients> usedIngredients;
    private List<ExtendedIngredients> unusedIngredients;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getUsedIngredientCount() {
        return usedIngredientCount;
    }

    public void setUsedIngredientCount(int usedIngredientCount) {
        this.usedIngredientCount = usedIngredientCount;
    }

    public int getMissedIngredientCount() {
        return missedIngredientCount;
    }

    public void setMissedIngredientCount(int missedIngredientCount) {
        this.missedIngredientCount = missedIngredientCount;
    }

    public List<ExtendedIngredients> getMissedIngredients() {
        return missedIngredients;
    }

    public void setMissedIngredients(List<ExtendedIngredients> missedIngredients) {
        this.missedIngredients = missedIngredients;
    }

    public List<ExtendedIngredients> getUsedIngredients() {
        return usedIngredients;
    }

    public void setUsedIngredients(List<ExtendedIngredients> usedIngredients) {
        this.usedIngredients = usedIngredients;
    }

    public List<ExtendedIngredients> getUnusedIngredients() {
        return unusedIngredients;
    }

    public void setUnusedIngredients(List<ExtendedIngredients> unusedIngredients) {
        this.unusedIngredients = unusedIngredients;
    }
}
