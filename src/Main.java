
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        // Instantiate and Initalize set A and set B
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();

        // Read the inputs and populate both sets.
        readInputs(setA, setB);

        // Generate the union of set A and set B then sort the result lexicographically.
        Set<String> union = lexicographicalSort(union(setA, setB));
        printSet(union, true);

        // Generate the intersection of set A and set B then sort the result lexicographically.
        Set<String> intersection = lexicographicalSort(intersection(setA, setB));
        printSet(intersection, true);

        // Generate the cartesian product of set A x set B then sort the result lexicographically.
        Set<String> cartesianProduct = lexicographicalSort(cartesianProduct(setA, setB));
        printSet(cartesianProduct, true);
    }

    private static void printSet(Set<String> set, boolean newLine) {
        for (String element : set) {
            System.out.println(element);
        }
        if(newLine){
            System.out.println("");
        }
    }

    private static Set<String> lexicographicalSort(Set<String> input) {
        Set<String> sortedStrings = new TreeSet<String>((s1, s2) -> s1.compareTo(s2));
        sortedStrings.addAll(input);
        return sortedStrings;
    }

    private static Set<String> union(Set<String> setA, Set<String> setB) {
        Set<String> union = new HashSet<>(setA);
        union.addAll(setB);
        return union;
    }

    private static Set<String> intersection(Set<String> setA, Set<String> setB) {
        Set<String> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        return intersection;
    }

    private static Set<String> cartesianProduct(Set<String> setA, Set<String> setB) {
        Set<String> cartesianProduct = new HashSet<>();
        for (String a : setA) {
            for (String b : setB) {
                cartesianProduct.add(a + " " + b);
            }
        }
        return cartesianProduct;
    }

    private static void readInputs(Set<String> setA, Set<String> setB) {

        String input = null;
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            // Input for set A
            System.out.print("Enter input: ");

            int size = scanner.nextInt();
            for (int i = 0; i < size; i++) {
                input = scanner.next();
                if(input.length() > 10) input = input.substring(0, 10);
                setA.add(input);
            }

            size = scanner.nextInt();
            for (int i = 0; i < size; i++) {
                input = scanner.next();
                if(input.length() > 10) input = input.substring(0, 10);
                setB.add(input);
            }

            System.out.println("");
            close(scanner);
        } catch (Exception ex) {
            System.out.println("Cannot read the inputs.");
            ex.printStackTrace();
            close(scanner);
        }

        return;
    }

    private static void close(Scanner scanner) {
        try {
            if (null != scanner) {
                scanner.close();
            }
            scanner = null;
        } catch (Exception ex) {
            scanner = null;
        }

        return;
    }
}
