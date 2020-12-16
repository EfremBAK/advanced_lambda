//use a functional interface (FUNCTION) in place of the

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class App8 {
    public static void main(String[] args) {
        List<Person> roster = PersonUtils.generateRandomPersonList(100);
        System.out.println("the persons eligible for selective service are:");

        int count = processPerson(roster,
                (Person p) -> p.getGender() == Person.Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25,
                p -> p.getEmail(),
                email -> System.out.println(email));
        System.out.printf("\nThere were %d persons in this category.\n",count);

    }

    public static int processPerson(List<Person> roster, Predicate<Person> tester, Function<Person, String> mapper, Consumer<String> block) {
        int count = 0;
        for (Person p : roster) {
            if (tester.test(p)) {
                ++count;
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
        return count;
    }
}
