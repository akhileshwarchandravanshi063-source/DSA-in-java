
/* 1) An iterator is a way to loop through elements in a data structure.
   2) It is called an "iterator" because "iterating" is the technical term for looping.*/
import java.util.ArrayList;
import java.util.Iterator;

public class Iterate {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        // Get an iterator for the ArrayList
        Iterator<String> it = cars.iterator();

        // Iterate through the list using the iterator
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
