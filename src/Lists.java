import java.util.*;

public class Lists {

    public static void CommonSyntx() {

        // Initialize a List of Strings
        List<String> initializedList = new ArrayList<>();

        // Add element to the list
        initializedList.add("Item");

        // Initialize List of Strings with values
        List<String> listWithValues = Arrays.asList("sup1", "sup2", "sup3");

        // Iterate through the elements of the list
        for (String sts : listWithValues) {
            System.out.println(sts);
        }

    }
}
