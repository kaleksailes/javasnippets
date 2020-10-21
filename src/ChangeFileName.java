import java.io.File;

public class ChangeFileName {

    public static void changeFileName() {

        // Get the Directory
        File folder = new File("PATH\\folder");

        // Get all the files in the directory
        File[] listOfFiles = folder.listFiles();

        int numberSeq = 1;

        String newFileName = "LogFile";
        String newExtension = "csv";

        for (File file : listOfFiles) {

            if (file.isFile()) {

                System.out.println(file.getName());

                // Rename each file in the directory
                file.renameTo(new File("PATH\\folder\\" + newFileName + numberSeq + "." + newExtension));
            }

            numberSeq++;
        }
    }
}