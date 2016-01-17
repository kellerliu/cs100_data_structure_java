
public class LinkedListSol {

    //internally this class uses ListNode to store
    //all its data
    private static class ListNode {
        public int data;
        public ListNode next;
        public ListNode(int d, ListNode n) {
            data = d;
            next = n;
        }
    }
    
    private ListNode head = null;
    
    public LinkedListSol() {
        //makes and empty list
    }
    
    public LinkedListSol(int[] data) {
        
        for(int i = data.length - 1; i >= 0; i--) {
            head = new ListNode(data[i], head);
        }
    }
    
    public String toString() {
        if(head == null) return "[]";
        ListNode current = head;
        String result = "[";
        while(current.next != null) {
            result += current.data + ", ";
            current = current.next;
        }
        return result + current.data + "]";
    }
    
    public static void main(String[] args) {
        int[] data1 = {1,4, 0, 2,3,4,4,4, 5, 6, 7};
        int[] data2 = {8,8,8};
        LinkedListSol list = new LinkedListSol(data1);
        LinkedListSol list2 = new LinkedListSol(data2);
        System.out.println("Starting list: " + list);
        //list is zero indexed, like arrays
        //this should return 2
        System.out.println("4th element " + list.getElement(3));
        list.removeFours();
        System.out.println("Without fours: " + list);
        System.out.println("Merged with: " + list2 + ":");
        list.mergeWith(list2);
        // should produce [1, 0, 8, 8, 8, 2, 3, 5, 6, 7]
        System.out.println(list);
    }

    public int getElement(int index) {
        ListNode current = head;
        for(int i = 0; i < index; i++) {
            if(current == null)
                return -1;
            current = current.next;
        }
        return current.data;
    }
    
    private int getElementRecursive(int index, ListNode current) {
        if(current == null)
            return -1;
        if(index == 0)
            return current.data;
        return getElementRecursive(index-1, current.next);
    }
    
    public void removeFours() {
        //you would call the recursive function like this
        //head = removeFoursRecursive(head);
        
        //make a new fake head
        ListNode fakeHead = new ListNode(0,head);
        ListNode current = fakeHead;
        while(current.next != null) {
            if(current.next.data == 4) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        head = fakeHead.next;
    }
    
    private ListNode removeFoursRecursive(ListNode current) {
        if(current == null)
            return null;
        if(current.data == 4)
            return removeFoursRecursive(current.next);
        current.next = removeFoursRecursive(current.next);
        return current;
    }

    public void mergeWith(LinkedListSol two) {
        //recursive version called like this:
        //mergeListsRecursive(head, two.head);
        ListNode current = head;
        if(two.head == null)
            return; //inserting an empty list
        while(current != null && current.data != 0) {
            current = current.next;
        }
        if(current == null) return; //no zero
        ListNode listRemainder = current.next;
        current.next = two.head;
        current = two.head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = listRemainder;
    }
    
    private void mergeListsRecursive(ListNode one, ListNode two) {
        if(one == null) {
            return;
        }
        if(one.data == 0) {
            one.next = appendListsRecursive(two, one.next);                
        }
        mergeListsRecursive(one.next, two);
    }

    //just appends list two at the end of list one
    private ListNode appendListsRecursive(ListNode one, ListNode two) {
        if(one == null) return two;
        one.next = appendListsRecursive(one.next, two);
        return one;
    }
}


//HINT for removeFours() interative edition:        


//LEVEL 1: To remove an element, you have to edit the previous element in the list.
//It looks like this:
//
//        current.next = current.next.next;



//LEVEL 2:        
//while the next element is not null
//    if the next element's value is 4 then 
//        current.next = current.next.next;
//    otherwise move on to the next element in the list