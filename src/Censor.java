import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Censor {
    //TODO set up git

    private String fileName = "";
    private String[] keyWord;

    public Censor(String fileNameIn, String[] keysWordIn) throws IOException { //TODO add array of words
        fileName = fileNameIn;
        keyWord = keysWordIn;
        this.censorFile();
    }

    public boolean censorFile() throws IOException {
        // Create new file
        String fName = "Censored-" + fileName;
        try {
            File newFile = new File(fName);
            if (newFile.createNewFile()) {
                System.out.println("File Created: " + fName);
            } else {
                System.out.println("File not created");
            }
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }

        /* Read in original file */
        String originalFile = "";
        String currentLine = "";
        Scanner scanFile = new Scanner(new File(fileName));
        while (scanFile.hasNextLine()) {
            currentLine = scanFile.nextLine();
            StringBuilder builder = new StringBuilder(currentLine);
            for (String element : keyWord) {
                if (currentLine.toLowerCase().contains(element.toLowerCase())) {
                    int l = element.length();
                    if (currentLine.length() > l) {
                        int startIndex = currentLine.toLowerCase().indexOf(element.toLowerCase());
                        int endIndex = startIndex + l;
                        String replacement = "";
                        for (int i = l; i > 0; i--) {
                            replacement += "X";
                        }
                        builder.replace(startIndex, endIndex, replacement);
                        currentLine = builder.toString();
                    }
                }
            }
        originalFile += currentLine + "\n";

        }

        // Write new text to new file
        FileWriter myWriter = new FileWriter(fName);
        myWriter.write(originalFile);
        myWriter.close();

        return true; // TODO make this return false for something.

    }

}
