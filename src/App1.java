import java.util.List;
//Calls a utility method to perform particular searches
public class App1 {
    public static void main(String[] args) {
        List<Person> roster = PersonUtils.generateRandomPersonList(100);
        System.out.println("Persons older than 21: ");
        int count= printPersonOlderThan(roster, 21);
        System.out.printf("\nthere were %d persons in the category.\n" , count);
    }

    private static int printPersonOlderThan(List<Person> roster, int age) {
        int count  =  0;
        for (Person p : roster){
            if (p.getAge()>= age){
                ++count;
                p.printPerson();
            }
        }
        return count;
    }

}

/**
 * This approach can potentially make your application brittle, which is the likelihood of an application not working because of the introduction of updates
 * (such as newer data types). Suppose that you upgrade your application and
 * change the structure of the Person class such that it contains different member variables;
 * perhaps the class records and measures ages with a different data type or algorithm.
 *
 * You would have to rewrite a lot of your API to accommodate this change. In addition, this approach is unnecessarily restrictive;
 * what if you wanted to print members younger than a certain age, for example?
 */