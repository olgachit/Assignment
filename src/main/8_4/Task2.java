import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(8);
        list.add(20);
        list.add(15);
        list.add(3);
        list.add(12);

        Double sum = list.stream()
                .filter(n-> n % 2 != 0)
                .mapToInt(n-> n * 2)
                .sum() * 1.0;
        System.out.println("Sum of doubled odd numbers: " + sum);
    }
}
