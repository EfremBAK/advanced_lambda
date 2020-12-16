import java.time.LocalDate;

public class Person implements Comparable<Person> {
    @Override
    public int compareTo(Person other) {
        if(null == other) {
            return 1; // "this" is bigger than null
        }

        return this.ssn.compareTo(other.ssn);

    }

    public static enum Gender{
        MALE, FEMALE
    }
    private String ssn;
    private String name;
    private Gender gender;
    private LocalDate birthday;
    private String email;

    public Person(String ssn, String name, Gender gender, LocalDate birthday) {
        super();
        this.ssn = ssn;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.email = name + "@abc.com";
    }
    public Person(String ssn, String name){
        super();
        this.name = name;
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void printPerson()
    {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
