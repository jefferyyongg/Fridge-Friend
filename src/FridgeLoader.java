import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FridgeLoader {

    public void removeIngredient(String title){

        List<String> fridge = loadFridge();
        ArrayList<String> result = new ArrayList<>();

        try{

            FileWriter writer = new FileWriter("/Users/jefferyyong/IdeaProjects/Fridge-Friend/src/Fridge.txt");

            int count = 0;
            for(String s : fridge){
                if(s.equals(title)){
                    count++;
                }
            }

            if(count > 0){
                for(String s : fridge){
                    if(!s.equals(title)){
                        result.add(s);
                    }
                }
            } else {
                for(String s : fridge){
                    writer.append(s + "\n");
                }
                System.out.println("Fridge does not contain this item.");
            }

            for(String s : result){
                writer.append(s + "\n");
            }

            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
     public void addIngredient(String title){
         try{

             FileWriter writer = new FileWriter("/Users/jefferyyong/IdeaProjects/Fridge-Friend/src/Fridge.txt", true);
             writer.append(title + "\n");
             writer.close();

         } catch(IOException e){
             e.printStackTrace();
         }
     }

     public List<String> loadFridge(){
         List<String> lines = new ArrayList<>();
        try{
            Path path = Paths.get("/Users/jefferyyong/IdeaProjects/Fridge-Friend/src/Fridge.txt");
            lines = Files.readAllLines(path);

        } catch(IOException e){
            e.printStackTrace();
        }
        return lines;
     }
}
