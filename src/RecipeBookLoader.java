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
            Path path = Paths.get("/Users/jefferyyong/IdeaProjects/Fridge-Friend/src/RecipeBook.txt");
            lines = Files.readAllLines(path);
        } catch(IOException e){
            e.printStackTrace();
        }
        return lines;
    }

    public void addRecipe(String id){
        if(id.isEmpty()){
            System.out.println(
                    "geen recept gevonden"
            );
        } else {
            try{
                FileWriter writer = new FileWriter("/Users/jefferyyong/IdeaProjects/Fridge-Friend/src/RecipeBook.txt", true);
                writer.append(id + "\n");
                System.out.println("Recept toegevoegd.");
                writer.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void removeRecipe(List<String> lines){
        try{
            FileWriter writer = new FileWriter("/Users/jefferyyong/IdeaProjects/Fridge-Friend/src/RecipeBook.txt");
            for(String line : lines){
                writer.append(line + "\n");
            }
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
