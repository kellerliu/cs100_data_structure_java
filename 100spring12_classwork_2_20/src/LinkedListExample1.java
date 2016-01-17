
public class LinkedListExample1 {

    public ListNode generateList(int n) 
    {
        //should generate a list of n nodes, each with value n
        //so generateList(2) should produce a list that looks like
        // 2 -> 2
    	
    	ListNode head=null;
    	for(int i=0;i<n;i++){
    		ListNode newNode=new ListNode();
    		newNode.data=n;
    		newNode.next=head;
    		head=newNode;		
    	}
        return head;
    }
    
    public ListNode addZeroAsFirstElement(ListNode n) {
        //in theory this function should add node as the first
        //node in the list.  It does not work.
        //
        //the reason has to do with the fact that this function
        //returns void

        ListNode zero = new ListNode();
        zero.data = 0;
        zero.next = n;
        return zero;
    }
    
    public void addZeroAsSecondElement(ListNode n) {
        //in theory this function should add node as the second
        //element in a list.  It works.
        
        if(n == null) {
            System.out.println("Broken!  I can't add to an empty list");
            return;
        }
        
        ListNode zero = new ListNode();
        zero.data = 0;
        zero.next = n.next;
        n.next = zero;
    }
    
    
    public void addZeroAsThirdElement(ListNode n) {
        //in theory this function should add node as the second
        //element in a list.  It works.
        
        if(n == null) {
            System.out.println("Broken!  I can't add to an empty list");
            return;
        }
        
        ListNode zero = new ListNode();
        zero.data = 0;
        zero.next = n.next.next;
        n.next.next = zero;
    }
    
    public void doExample1()
    {
        ListNode node = new ListNode();
        node.data = 1;
        node.next = null;
        
        ListNode nodeX = new ListNode();
        nodeX.data = 2;
        nodeX.next = node;
        
        System.out.println("A) nodeX.data: " + nodeX.data);
        System.out.println("B) nodeX.next.data " + nodeX.next.data);
        
        node = new ListNode();
        node.data = 3;
        node.next = null;
        
        nodeX.next.next = node;

        //adjustment:
        node=new ListNode();
        node.data=4;
        node.next=nodeX;
        nodeX=node;
        
        node=new ListNode();
        
        ListNode position=new ListNode();
        
        while(position.next!=null){
        	position=position.next;
        	
        }
        position.data=5;
        
        node.data=5;
        nodeX.next.next.next.next=node;

        
    
        
        
        
        
        
        
        
        
        
        System.out.println("C) nodeX.data: " + nodeX.data);
        System.out.println("D) nodeX.next.data " + nodeX.next.data);
        System.out.println("E) nodeX.next.next.data " + nodeX.next.next.data);
        
        System.out.println("F) The output of the loop is:");
        
        ListNode current = nodeX;
        while(current != null) {
            System.out.println("CurrentNode = " + current.data);
            current = current.next;
        }
        

        System.out.println("G) Generate list outputs:");
        
        ListNode head = generateList(5);
        current=head;
        while(current != null) {
            System.out.println("CurrentNode = " + current.data);
            current = current.next;
        }
        
        
        System.out.println("H) Zero added:");
        head=addZeroAsFirstElement(head);
        addZeroAsFirstElement(head);
        addZeroAsSecondElement(head);
        addZeroAsThirdElement(head);
        current=head;
        while(current != null) {
            System.out.println("CurrentNode = " + current.data);
            current = current.next;
        }
    }
    
    public static void main(String[] args) {
        LinkedListExample1 ex = new LinkedListExample1();
        ex.doExample1();

    }

}
