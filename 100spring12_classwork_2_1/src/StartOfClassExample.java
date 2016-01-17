
import java.util.*;

public class StartOfClassExample {

    public void doExample()
    {
        List<Person> personList = getPersonList();
        System.out.println("Person list: " + personList);
        
        Person p = new Person("Mike","Hewner");
        if(personList.contains(p)) {
            System.out.println("Mike is in the list!");
        } else {
            System.out.println("Mike is not in the list?!?  Something weird is happening!");
        }
    }
    
    private List<Person> getPersonList() {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("Mike", "Hewner"));
        list.add(new Person("Benjamin", "Franklin"));
        return list;
    }

    public static void main(String[] args) {
        StartOfClassExample ex = new StartOfClassExample();
        ex.doExample();
    }
}
