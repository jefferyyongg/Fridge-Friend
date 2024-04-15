import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FridgeLoaderTest {
    @Test
    void testLoadFridge() {
        FridgeLoader fridge = new FridgeLoader();

        List<String> lines = fridge.loadFridge();

        assertNotNull(lines);
        assertFalse(lines.isEmpty());
    }
}
