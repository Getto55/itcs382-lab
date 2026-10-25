package bikeshare.repository;

import bikeshare.model.Receipt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class CsvRideSaver implements RideSaver {
    private final Path filePath;

    public CsvRideSaver(String fileName) {
        this.filePath = Path.of(fileName);
    }

    @Override
    public void save(String memberId, Receipt receipt) {
        String line = String.format("%s,%s,%d,%d%n", 
                memberId, receipt.bikeId(), receipt.minutes(), receipt.fee());
        try {
            Files.writeString(filePath, line, 
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Failed to save ride to CSV: " + e.getMessage());
        }
    }
}