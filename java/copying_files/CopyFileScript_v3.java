package copying_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyFileScript_v3 {
    public static void main(String args[]) throws IOException {
        // copy using Files.copy
        final String sourceFilename = "copy_me.txt";
        final String destinationFilename = "destination/copy_me.txt";

        try {
            Files.copy(Paths.get(sourceFilename), Paths.get(destinationFilename));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not copy the file to the destination: "
                    + Paths.get(destinationFilename).toString());
            System.exit(1);
        }
        System.out.println("Copied: " + Paths.get(sourceFilename).toString() + "\nto\n"
                + Paths.get(destinationFilename).toString());
    }

}
