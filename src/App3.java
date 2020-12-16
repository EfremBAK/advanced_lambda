//Calls a utility method to perform a particular search

import java.util.List;

public class App3 {
    public static void main(String[] args) {
        List<Person> roster = PersonUtils.generateRandomPersonList(100);

        System.out.println("Persons who are eligeble for selective service: ");

        class CheckPersonEligibleForSelectiveService implements CheckPerson{
            public boolean test(Person p){
                return p.getGender() == Person.Gender.MALE
                        && p.getAge() >=18
                        && p.getAge() <= 25;
            }
        }

        int count = printPerson(roster, new CheckPersonEligibleForSelectiveService());
        System.out.printf("\nThere were %d person eligible for selective service\n", count);
    }

    public static int printPerson(List<Person> roster, CheckPerson tester) {
        int count = 0;
        for (Person p : roster) {
            if (tester.test(p)) {
                ++count;
                p.printPerson();
            }
        }
        return count;
    }
}


/**
 * Although this approach is less brittle—you don't have to rewrite methods if you change the structure of the Person—you
 * still have additional code: a new interface and a local class for each search you plan to perform in your application.
 * Because CheckPersonEligibleForSelectiveService implements an interface, you can use an anonymous class instead of a
 * local class and bypass the need to declare a new class for each search.
 */