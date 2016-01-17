
public class Person {
    private String myFirstName;
    private String myLastName;
    
    public Person(String first, String last) {
        myFirstName = first;
        myLastName = last;
    }
    
    public String toString()
    {
        return "A person named " + myFirstName + " " + myLastName;
    }
}
