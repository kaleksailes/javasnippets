import java.util.ArrayList;
import java.util.List;

public class Splits {

    /**
     * 
     * When you have a string divided by an specific value use sthe split method to
     * divide said values
     * 
     * You can then keep the values in the array created from the split or assign
     * every value as an item to a list
     * 
     */
    public static void splitStringByComma() {

        String line = "wind,river,beach,coast,water,mountain";

        List<String> listSplit = new ArrayList<>();

        String splitBy = ",";

        String[] lines = line.split(splitBy);

        for (String value : lines) {
            listSplit.add(value);
        }
    }
}