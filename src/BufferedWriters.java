import java.io.*;

/**
 * 
 * From Java 7 onwards you can use the try-with-resources block with
 * BufferedWriter to close the object. No need to use bufferedReader.close();
 * 
 */

public class BufferedWriters {

    public static void bufferedWriterOne() {

        String fileDefinition = "newFile.txt";

        // BufferedWriter 1 - Create file

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileDefinition))) {

            writer.write("Write some content");
            writer.newLine();
            writer.write("Add this line after a newLine");
            writer.newLine();
            writer.write("Close file with this line");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void bufferedWriterTwo() {

        String fileDefinition = "newFile.txt";

        // BufferedWriter 2 - Create file that appends the data to the file

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileDefinition, true))) {

            writer.write("This line will be added to the file created in bufferedWriterOne");
            writer.newLine();
            writer.write("This line will be added as well");
            writer.newLine();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}