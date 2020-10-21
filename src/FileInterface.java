import java.io.File;

public class FileInterface {

    public static void fileInterface() {

        /**
         * Create a representation of the file with File CLass
         */
        File f = new File("PATH\\fileName.pdf");

        /**
         * From the file class you can get the name of the file
         */
        String fileName = f.getName();

        /**
         * Check if the name of the file ends with an specific string
         * 
         * Good to check filename extension type
         */
        boolean flag = fileName.endsWith(".csv");

        /**
         * Substring: Get part of the string
         * 
         * substring(int beginIndex, int endIndex)
         * 
         * Result: hel
         */
        String str0 = "hello";
        String subStringOfHello = str0.substring(0, 2);

        /*
         * last index of: Returns last index of the given character value or substring
         * 
         * The count starts at 1 not 0
         * 
         * Result: 5 *
         */
        String str1 = "hello";
        int lastIndexOfHello = str1.lastIndexOf('o');// Display: 5

        /**
         * Get file name without the extension and assign it to a variable
         */
        String fileNameNoExt = fileName.substring(0, fileName.lastIndexOf("."));

        /**
         * Get the extension of a file
         */
        String str2 = "hellointernert.txt";
        String extension = str2.substring(str2.lastIndexOf(".") + 1);

        /**
         * Get Extension using Apache Commons IO library
         */
        // String extensionUsingApache = FilenameUtils.getExtension(str2);

        System.out.println("File Name: " + fileName);

        System.out.println("Does the file end with .csv? " + flag);

        System.out.println("Substring from 0 to 2 of hello: " + subStringOfHello);

        System.out.println("Last Index of the o in hello: " + lastIndexOfHello);

        System.out.println("File name with no extension: " + fileNameNoExt);

        System.out.println("Extension of the file: " + extension);

    }

    public static void GetAllFilesInDirectory() {

        File folder = new File("PATH");

        File[] listOfFiles = folder.listFiles();

        if (listOfFiles.length == 0)
            System.out.println("No files were found.");
        else
            System.out.println("We have found " + listOfFiles.length + " files in the directory.");
    }
}