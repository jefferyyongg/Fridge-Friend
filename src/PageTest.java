import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageTest {
    Page page = new Page();

    @Test
    void encodeReviewUnderscore() {
        String test1 = "1 2 3 4 5";
        String expected1 = "1%202%203%204%205";
        assertEquals(expected1, page.encodeReview(test1));
    }

    @Test
    void decodeReviewUnderscore() {
        String expected1 = "1 2 3 4 5";
        String test1 = "1%202%203%204%205";
        assertEquals(expected1, page.decodeReview(test1));
    }
}