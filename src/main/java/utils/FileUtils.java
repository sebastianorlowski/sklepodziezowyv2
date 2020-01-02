package utils;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class FileUtils {

    public static void createNewFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
    }

    public static void clearFile(String fileName) throws IOException {
        PrintWriter pw = new PrintWriter(fileName);
        pw.close();
    }
}
