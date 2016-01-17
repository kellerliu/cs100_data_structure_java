public class DoublyLinkedList {

	// internally this class uses ListNode to store
	// all its data
	private static class ListNode {
		public int data;
		public ListNode next;
		public ListNode prev;

		public ListNode(int d, ListNode n, ListNode p) {
			data = d;
			next = n;
			prev = p;
		}
	}

	private ListNode head = null;
	private ListNode tail = null;

	public DoublyLinkedList() {
		// makes and empty list
	}

	public DoublyLinkedList(int[] data) {

		for (int i = data.length - 1; i >= 0; i--) {
			ListNode oldHead = head;
			head = new ListNode(data[i], head, null);
			if (tail == null) {
				tail = head;
			} else {
				oldHead.prev = head;
			}
		}
	}

	public String toString() {
		if (head == null)
			return "[]";
		ListNode current = head;
		String result = "[";
		while (current.next != null) {
			result += current.data + ", ";
			current = current.next;
		}
		return result + current.data + "]";
	}

	public String toStringReverse() {
		if (head == null)
			return "[]";
		ListNode current = tail;
		String result = "[";
		while (current.prev != null) {
			result += current.data + ", ";
			current = current.prev;
		}
		return result + current.data + "]";
	}

	public void addAtFront(int item) {
		ListNode newNode = new ListNode(item, head, null);
		if (head != null) {
			head.prev = newNode;
		} else {
			// adding to an empty list
			tail = newNode;
		}
		head = newNode;
	}

	public void addAtBack(int item) {
		ListNode newNode = new ListNode(item, null, tail);
		if (tail != null) {
			tail.next = newNode;
		} else {
			// adding to an empty list
			head = newNode;
		}
		tail = newNode;
	}

	public void removeFront() {
		if (head.next == null)
			head = tail = null;
		else {
			head = head.next;
			head.prev = null;
		}
		// should remove the first element
		// you can assume the list has at least one element
		// But don't forget the situation where the head and tail are the same!
		// (that's when you have a 1 element list)
	}

	public void removeBack() {
		if (tail.prev == null)
			tail = head = null;
		else {
			tail = tail.prev;
			tail.next = null;
		}
		// should remove the last element
		// you can assume the list has at least one element
		// But don't forget the situation where the head and tail are the same!
		// (that's when you have a 1 element list)

	}

	// adds a new value after a particular existing value in the list
	// if the existing value isn't there, doesn't needs to do anything to the
	// list
	public void addAfter(int valueToAddAfter, int valueToAdd) {

		if (head == null)
			return;
		ListNode current = head;
		while (current != null) {
			if (current.data == valueToAddAfter) {
				ListNode newNode = new ListNode(valueToAdd, current.next, current);
				if (current.next != null) {
					current.next.prev = newNode;
				}
				else{
					tail = newNode;					
				}
				current.next = newNode;
			}
			current = current.next;

		}

	}

	public void removeFours() {
		if (head == null)
			return;
		
		ListNode fakeHead=new ListNode(0,head,null);
		
		ListNode current=fakeHead;
		
		while(current.next!=null){
			if(current.next.data==4){
				current.next=current.next.next;
				
				if(current.next!=null)
				current.next.prev=current;
			}
			else{
				current=current.next;
			}
			
		}
		head=fakeHead.next;
		if(current!=fakeHead){
			tail=current;
			head.prev=null;  
		}
		else{
		tail=null;
		}
		
		
		// removes all the 4s in the list
	}

	public static void main(String[] args) {
		int[] data1 = { 4, 1, 2, 3, 4, 5, 4, 4, 4, 6, 4 };
		DoublyLinkedList list1 = new DoublyLinkedList(data1);
		System.out.println("List1 list: " + list1);
		System.out.println("List1 reversed: " + list1.toStringReverse());
		DoublyLinkedList list2 = new DoublyLinkedList();
		list2.addAtFront(1);
		list2.addAtBack(2);
		list2.addAtFront(0);
		System.out.println("List2 list: " + list2);
		System.out.println("List2 reversed: " + list2.toStringReverse());
		list2.removeFront();
		list2.removeBack();
		// this list should just contain one at this point
		System.out.println("List2 list: " + list2);
		System.out.println("List2 reversed: " + list2.toStringReverse());

		int[] data3 = { 1, 2, 3 };
		DoublyLinkedList list3 = new DoublyLinkedList(data3);
		// adds -1 after the 2
		list3.addAfter(2, -1);
		// adds 02 after the 3
		list3.addAfter(3, -2);

		// should print out List3 list: [1, 2, -1, 3, -2]
		System.out.println("List3 list: " + list3);
		// should print out List3 reversed: [-2, 3, -1, 2, 1]
		System.out.println("List3 reversed: " + list3.toStringReverse());

		list1.removeFours();
		System.out.println("List1 list: " + list1);
		System.out.println("List1 reversed: " + list1.toStringReverse());

	}

}
