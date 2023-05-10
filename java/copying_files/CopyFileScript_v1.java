package copying_files;

import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class CopyFileScript_v1 {

    public static void main(String args[]) throws IOException {
        // copy using FileInputStream and FileOutputStream
        final String sourceFilename = "copy_me.txt";
        final String destinationFilename = "destination/copy_me.txt";
        File sourceFile = new File(sourceFilename);
        File destinationFile = new File(destinationFilename);

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(sourceFile);
            outputStream = new FileOutputStream(destinationFile);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not copy the file to the destination: "
                    + destinationFile.getPath() + ". Check if folder of file already exists.");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }

            System.out.println("File successfully copied from: " + sourceFile.getPath() + " to "
                    + destinationFile.getPath() + ".");
        }
    }

}
