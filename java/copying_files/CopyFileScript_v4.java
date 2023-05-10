package copying_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyFileScript_v4 {
    public static void main(String[] args) throws IOException {
        // copy using FileChannel.transferTo
        File sourceFile = new File("copy_me.txt");
        File destinationFIle = new File("destination/copied_file.txt");
        FileInputStream sourceFileInputStream = new FileInputStream(sourceFile);
        FileOutputStream destinationFIleOutputStream = new FileOutputStream(destinationFIle);

        try {
            FileChannel iChannel = sourceFileInputStream.getChannel();
            FileChannel oChannel = destinationFIleOutputStream.getChannel();
            iChannel.transferTo(0, iChannel.size(), oChannel);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Could not copy file to destination:\n"
                    + sourceFile.getAbsolutePath() + "\nto\n" + destinationFIle.getAbsolutePath());
            System.exit(1);
        } finally {
            sourceFileInputStream.close();
            destinationFIleOutputStream.close();
        }

        System.out.println("Copied file from:\n" + sourceFile.getAbsolutePath() + "\nto\n"
                + destinationFIle.getAbsolutePath());
    }
}
