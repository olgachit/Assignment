import java.util.ArrayList;
import java.util.List;

public class Numbers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(20);
        numbers.add(15);
        numbers.add(3);
        numbers.add(12);

        System.out.println("List of numbers: " + numbers);

        numbers.removeIf(n->n%2==0);
        System.out.println("After removing even numbers: " + numbers);

        numbers.replaceAll(n->n*2);
        System.out.println("After doubling each number: " + numbers);

        int sum =0;
        for(int n : numbers) {
            sum += n;
        }
        System.out.println("Sum of remaining numbers: " + sum);
    }
}
