import java.util.List;
//use lambda expression instead of the anonymous class
public class App5 {
    public static void main(String[] args) {
        List<Person> roster = PersonUtils.generateRandomPersonList(120);

        System.out.println("Persons who are eligible for selective service: ");

        int count = printPerson(roster,
                                 (Person p) -> p.getGender()==Person.Gender.MALE && p.getAge()>=18 && p.getAge()<=25);
        System.out.printf("there are %d people in this category:", count);
    }
    public static int printPerson(List<Person> roster, CheckPerson tester){
        int count = 0;
        for(Person p: roster){
            if(tester.test(p)){
                ++count;
                p.printPerson();
            }
        }
        return count;
    }
}


/**
 * You can use a standard functional interface in place of the interface CheckPerson, which reduces even further the amount of code required.
 *
 */