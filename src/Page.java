import java.util.Scanner;

public class Page {
    public void loadPage(Scanner scanner){
        System.out.println("Loading page.");
    }


    //om gebruiker input juist te parsen voor GET request
    public String encodeReview(String review)
    {
        String encodedReview = review;
        encodedReview = encodedReview.replace(" ", "%20");

        return encodedReview;
    }

    public String decodeReview(String encodedReview)
    {
        String decodedReview = encodedReview;

        decodedReview = decodedReview.replace("%20", " ");

        return  decodedReview;
    }
}
