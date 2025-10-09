import java.util.ArrayList;
import java.util.Comparator;

public class Person {
    private String name;
    private int age;
    private String city;
    private ArrayList<Person> people;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getCity() {
        return city;
    }
    @Override
    public String toString() {
        return "Name='" + name + "', age=" + age + ", city='" + city + "'";
    }

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30, "New York"));
        people.add(new Person("Bob", 25, "Los Angeles"));
        people.add(new Person("Charlie", 35, "Chicago"));
        people.add(new Person("Daniel", 40, "new york"));

        System.out.println("People in the list:");
        people.forEach(System.out::println);

        System.out.println("\nPeople sorted by age:");
        people.sort(Comparator.comparing(Person::getAge));
        people.forEach(System.out::println);

        System.out.println("\nPeople from New York:");
        people.removeIf(p -> !p.getCity().equalsIgnoreCase("New York"));
        people.forEach(System.out::println);
    }
}
