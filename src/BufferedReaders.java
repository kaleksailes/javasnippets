import java.io.*;

/**
 * 
 * From Java 7 onwards you can use the try-with-resources block with
 * BufferedReader to close the object. No need to use bufferedReader.close();
 * 
 * encoding (UTF-16, UTF-8) Characters are a graphical entity which is part of
 * human culture. When a computer needs to handle text, it uses a representation
 * of those characters in bytes. The exact representation used is called an
 * encoding.
 * 
 */

public class BufferedReaders {

    public static void bufferedReaderOne() {

        // BufferedReader 1 - Read lines from a given path file

        String line;
        final String path = "PATH\\file.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            // Read all lines in file.
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void bufferedReaderTwo(final String[] args) {

        // BufferedReader 2 - Read lines from one or more file(s) passed as an argument

        final File f = new File(args[0]);

        String line;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-16"))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (final Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void bufferedReaderThree() {

        // BufferedReader 3 - Read lines from all the files in the current directory

        // Get all files in current directory
        final String folderPath = System.getProperty("user.dir");

        final File folder = new File(folderPath);
        final File[] listOfFiles = folder.listFiles();

        if ((listOfFiles == null) || (listOfFiles.length <= 0)) {

            System.out.println("Directory has no files");
            return;
        } else {

            for (final File fs : listOfFiles) {

                String lines;

                try (BufferedReader BuffRead = new BufferedReader(new InputStreamReader(new FileInputStream(fs)))) {

                    while ((lines = BuffRead.readLine()) != null) {
                        System.out.println(lines);
                    }

                } catch (final Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }
    }
}