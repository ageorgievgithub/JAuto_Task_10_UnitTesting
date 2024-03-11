package parser;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import shop.Cart;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTests {

    private JsonParser jsonParser;

    @TempDir
    File tempFolder;

    @BeforeEach
    void setUp() {
        jsonParser = new JsonParser() {
            @Override
            public void writeToFile(Cart cart) {

            }
        };
    }

    @ParameterizedTest
    @DisplayName("Test reading from different files")
    @ValueSource(strings = {
            "nonexistent.json",
            "corrupted.json",
            "empty.json",
            "andrew-cart.json"
    })
    void testReadFromFile(String fileName) {
        File file;
        if (!fileName.equals("null")) {
            file = new File(tempFolder, fileName);
            // Don't create the file, let it be non-existent for testing
        } else {
            file = null;
        }

        if (fileName.equals("null")) {
            assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(null),
                    "Should throw NoSuchFileException for null file");
        } else {
            assertThrows(NoSuchFileException.class, () -> jsonParser.readFromFile(file),
                    "Should throw NoSuchFileException for " + fileName);
        }
    }
}
