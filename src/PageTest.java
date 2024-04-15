import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageTest {
    Page page = new Page();

    @Test
    void encodeReviewUnderscore() {
        String test1 = "1 2 3 4 5";
        String expected1 = "1_2_3_4_5";
        assertEquals(expected1, page.encodeReview(test1));
    }

    @Test
    void encodeReviewDash() {
        String test1 = "1_2_3_4_5";
        String expected1 = "1-2-3-4-5";
        assertEquals(expected1, page.encodeReview(test1));
    }

    @Test
    void encodeReviewAt() {
        String test1 = "1-2-3-4-5";
        String expected1 = "1@2@3@4@5";
        assertEquals(expected1, page.encodeReview(test1));
    }

    @Test
    void decodeReviewUnderscore() {
        String expected1 = "1 2 3 4 5";
        String test1 = "1_2_3_4_5";
        assertEquals(expected1, page.decodeReview(test1));
    }

    @Test
    void decodeReviewDash() {
        String expected1 = "1_2_3_4_5";
        String test1 = "1-2-3-4-5";
        assertEquals(expected1, page.decodeReview(test1));
    }

    @Test
    void decodeReviewAt() {
        String expected1 = "1-2-3-4-5";
        String test1 = "1@2@3@4@5";
        assertEquals(expected1, page.decodeReview(test1));
    }
}