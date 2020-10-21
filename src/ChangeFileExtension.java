import java.io.File;

public class ChangeFileExtension {

    public static void changeFileExtension() {

        try {

            // Get the file(s) that in the same folder of the jar.
            String path = System.getProperty("user.dir");

            File folder = new File(path);

            File[] listOfFiles = folder.listFiles();

            String newExtension = "png";

            for (File f : listOfFiles) {

                String name = f.getName();
                String nameWithoutExtension = name.substring(0, name.indexOf("."));

                f.renameTo(new File(nameWithoutExtension + "." + newExtension));
            }

        } catch (Exception e) {
            System.out.println("Error in execution...finishing processes");
            System.out.println(e);
        }
    }
}