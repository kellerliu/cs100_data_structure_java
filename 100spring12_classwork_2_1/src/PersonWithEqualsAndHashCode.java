
public class PersonWithEqualsAndHashCode {
    private String myFirstName;
    private String myLastName;
    
    public PersonWithEqualsAndHashCode(String first, String last) {
        myFirstName = first;
        myLastName = last;
    }
    
    public String toString()
    {
        return "A person named " + myFirstName + " " + myLastName;
    }

    public int hashCode() {
        return myFirstName.hashCode() * 10000+myLastName.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonWithEqualsAndHashCode other = (PersonWithEqualsAndHashCode) obj;
        if(other.myFirstName.equals(myFirstName) && other.myLastName.equals(myLastName)) {
            return true;
        }
        return false;
    }
}
