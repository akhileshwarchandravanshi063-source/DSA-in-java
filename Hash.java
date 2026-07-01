import java.util.HashSet;
import java.util.HashMap;

// A HashSet is a collection where every element is unique - no duplicates are allowed.
public class Hash {
    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<String>();

        cars.add("volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("volvo");

        System.out.println(cars);

        HashMap<String, String> capitalCities = new HashMap<String, String>();

        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);
    }
}
