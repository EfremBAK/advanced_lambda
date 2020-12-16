import java.util.List;
import java.util.function.Predicate;

//use a functional interface (PREDICATE) in place of the interface CheckPerson
public class App6 {
    public static void main(String[] args) {
        List<Person> roster = PersonUtils.generateRandomPersonList(100);
        System.out.println("Persons who are eligible for the selective service:");

        int count =printPersonWithPredicate(roster,
                (Person p) -> p.getGender()== Person.Gender.MALE&&p.getAge()>=18&&p.getAge()<=25);
        System.out.printf("there are %d persons eligible for selective service:", count);
    }
    public static int printPersonWithPredicate(List<Person> roster, Predicate<Person> tester){
        int count = 0;
        for(Person p : roster){
            if(tester.test(p)){
                ++count;
                p.printPerson();
            }
        }
        return count;
    }
}
