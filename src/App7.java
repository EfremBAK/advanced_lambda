import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

//use a functional interface (CONSUMER) in place of the p.printPerson()
public class App7 {
    public static void main(String[] args) {
        List<Person> roster = PersonUtils.generateRandomPersonList(100);
        System.out.println("Persons who are eligible for the selective service are:");

int count = processPerson(roster,
          (Person p) -> p.getGender()== Person.Gender.MALE &&p.getAge()>=18&&p.getAge()<=25,
        p -> p.printPerson());
        System.out.printf("\nThere were %d persons in this category.\n",count);
    }
    public static int processPerson(List<Person> roster, Predicate<Person> tester, Consumer<Person> block){
        int count = 0;
        for(Person p:roster){
            if(tester.test(p)){
                ++count;
//                p.printPerson();
                block.accept(p);
            }
        }
        return count;
    }

}
