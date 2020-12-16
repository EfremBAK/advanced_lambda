import java.util.List;

//Calls a utility method to perform a particular search
public class App2 {
    public static void main(String[] args) {
        List<Person> roster = PersonUtils.generateRandomPersonList(100);
        System.out.println("Print between the age of 14-30: ");
        int count = printPersonWithAgeRange(roster, 14, 30);
        System.out.printf("\nThere are %d persons in the category: ", count);
    }

    public static int printPersonWithAgeRange(List<Person> roster, int low, int high){
        int count = 0;
        for (Person p : roster){
            if (low <=p.getAge() && p.getAge()>=high){
                count ++;
                p.printPerson();
            }
        }

        return count;
    }

}

/**
 * What if you want to print members of a specified sex, or a combination of a specified gender and age range?
 * What if you decide to change the Person class and add other attributes such as relationship status or geographical location?
 * Although this method is more generic than printPersonsOlderThan, trying to create a separate method for each possible search query
 * can still lead to brittle code. You can instead separate the code that specifies the criteria for which you want to search in a different class.
 */