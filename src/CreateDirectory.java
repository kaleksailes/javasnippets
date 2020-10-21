import java.io.File;

public class CreateDirectory {

    // Create folder in the working directory with a given name
    public static void createDirectory(String directoryName) {

        String pathWriter = System.getProperty("user.dir") + "\\" + directoryName;

        File file = new File(pathWriter);

        if (!file.exists()) {

            if (file.mkdir()) {

                System.out.println("Directory is created!");
            } else {

                System.out.println("Failed to create directory!");
            }
        }
    }
}