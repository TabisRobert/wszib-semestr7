package zejj.lab2;

import java.io.*;

public class InputOutputExample {

    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile1 = "destination1.txt";
        String destinationFile2 = "destination2.txt";
        String destinationFile3 = "destination3.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile1)) {
            long startTimefis = System.currentTimeMillis();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            long endTimefis = System.currentTimeMillis();
            long totalTimefis = endTimefis - startTimefis;
            System.out.println("Czas kopiowania FileInputStream: " + totalTimefis + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader(sourceFile);
             FileWriter fw = new FileWriter(destinationFile2)) {
            long startTimefr = System.currentTimeMillis();

            char[] buffer = new char[4096];
            int charsRead;
            while ((charsRead = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, charsRead);
            }

            long endTimefr = System.currentTimeMillis();
            long totalTimefr = endTimefr - startTimefr;
            System.out.println("Czas kopiowania FileReader: " + totalTimefr + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(destinationFile3))) {
            long startTimebr = System.currentTimeMillis();

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            long endTimebr = System.currentTimeMillis();
            long totalTimebr = endTimebr - startTimebr;
            System.out.println("Czas kopiowania BufferedReader: " + totalTimebr + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
