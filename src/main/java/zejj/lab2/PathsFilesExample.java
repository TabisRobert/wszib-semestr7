package zejj.lab2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsFilesExample {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        Path sourcePath = Paths.get(sourceFile);
        Path destinationPath = Paths.get(destinationFile);

        try {
            long startTime = System.currentTimeMillis();

            Files.copy(sourcePath, destinationPath);

            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            System.out.println("Czas kopiowania: " + totalTime + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
