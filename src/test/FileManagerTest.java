package test;

import main.FileManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FileManagerTest {
    private FileManager fileManager;
    private final String testFile = "testFile.txt";

    @BeforeEach
    void setUp() {
        fileManager = new FileManager(testFile);
    }

    @AfterEach
    void tearDown() {
        fileManager.deleteFile();
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, JUnit! This is my test file";
        fileManager.writeToFile(content);

        String result = fileManager.readFromFile();

        assertThat(result).isEqualTo(content);
    }

    @Test
    void testDeleteFile() throws IOException {
        fileManager.writeToFile("Some random text");
        assertThat(fileManager.deleteFile()).isTrue();
        assertThat(fileManager.deleteFile()).isFalse();
    }

    @Test
    void testDeleteNonExistingFile() throws IOException {
        assertThat(fileManager.deleteFile()).isFalse();
    }
}
