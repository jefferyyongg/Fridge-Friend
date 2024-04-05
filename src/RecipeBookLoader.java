import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RecipeBookLoader {

    public List<String> getRecipeBook(){
        List<String> lines = null;
        try{
            Path path = Paths.get("/Users/jefferyyong/IdeaProjects/FridgeFriend_v1/src/RecipeBook.txt");
            lines = Files.readAllLines(path);
        } catch(IOException e){
            e.printStackTrace();
        }
        return lines;
    }

    public void addRecipe(String id){
        try{
            FileWriter writer = new FileWriter("/Users/jefferyyong/IdeaProjects/FridgeFriend_v1/src/RecipeBook.txt", true);
            writer.append(id + "\n");
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
