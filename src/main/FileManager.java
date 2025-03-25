package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileManager {
    private final Path filePath;

    public FileManager(String fileName) {
        this.filePath = Path.of(fileName);
    }

    public void writeToFile(String content) throws IOException {
        Files.writeString(filePath, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public String readFromFile() throws IOException {
        if (!Files.exists(filePath)) {
            throw new IOException("File does not exist");
        }
        return Files.readString(filePath);
    }

    public boolean deleteFile() {
        try {
            return Files.deleteIfExists(filePath);
        } catch (IOException e) {
            return false;
        }
    }

    public boolean fileExists() {
        return Files.exists(filePath);
    }
}
