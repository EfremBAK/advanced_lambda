import java.util.List;

//using a anonymous class to find range between 18 and 25 who are male
public class App4 {
    public static void main(String[] args) {
    List<Person> roster = PersonUtils.generateRandomPersonList(100);

        System.out.println("Persons eligible for selective service: ");

        int count = printPerson(roster, new CheckPerson(){
                                            public boolean test(Person p){
                                                return p.getAge()>=18
                                                        && p.getAge()<=25
                                                        && p.getGender() == Person.Gender.MALE;
                                            }
                                    });
        System.out.printf("\n tehre are %d persons who are eliglble for selective service", count);
    }

    public static int printPerson(List<Person> roster, CheckPerson tester){
        int count =0;
        for (Person p: roster){
            if (tester.test(p)){
                ++count;
                p.printPerson();
            }
        }
        return count;
    }
}

/**
 * This approach reduces the amount of code required because you don't have to create a new class for each search that
 * you want to perform.
 * However, the syntax of anonymous classes is bulky considering that the CheckPerson interface contains only one method.
 * In this case, you can use a lambda expression instead of an anonymous class, as described in the next section.
 *
 */