import static org.junit.Assert.assertEquals;

import org.junit.Test;



public class StringLinkedListTester {
 
    @Test
    public void testAddAtBeginning(){
        StringLinkedList s = new StringLinkedList();
        assertEquals("",s.toString());
        s.addAtBeginning("a");
        assertEquals("a ",s.toString());
        s.addAtBeginning("b");
        assertEquals("b a ",s.toString());
    }

    @Test
    public void testAddAtEnd(){
        StringLinkedList s = new StringLinkedList();
        assertEquals("",s.toString());
        s.addAtEnd("a");
        assertEquals("a ",s.toString());
        s.addAtEnd("b");
        assertEquals("a b ",s.toString());
    }
    
    @Test
    public void testRemoveLongest(){
        
        //testing longest in middle
        StringLinkedList s = new StringLinkedList();
        assertEquals("",s.toString());
        s.addAtEnd("a");
        s.addAtEnd("b");
        s.addAtEnd("long");
        s.addAtEnd("c");
        s.removeLongestString();
        assertEquals("a b c ",s.toString());

        //testing empty list
        s = new StringLinkedList();
        s.removeLongestString();
        assertEquals("",s.toString());

        //testing 1 element list
        s = new StringLinkedList();
        s.addAtEnd("a");
        s.removeLongestString();
        assertEquals("",s.toString());
        
        //testing longest first
        s = new StringLinkedList();
        s.addAtEnd("long");
        s.addAtEnd("c");
        s.removeLongestString();
        assertEquals("c ",s.toString());
        
        //testing longest last
        s = new StringLinkedList();
        s.addAtEnd("a");
        s.addAtEnd("b");
        s.addAtEnd("long");
        s.removeLongestString();
        assertEquals("a b ",s.toString());
        
    }

}
