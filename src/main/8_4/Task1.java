import java.util.ArrayList;
import java.util.OptionalDouble;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);

        Double mean = numbers.stream()
                             .mapToInt(Integer::intValue)
                             .average()
                             .orElse(0);
        System.out.println("Mean: " + mean);
    }
}
