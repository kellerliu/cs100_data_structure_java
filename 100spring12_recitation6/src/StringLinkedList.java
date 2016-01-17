public class StringLinkedList {

	private class Node {
		String myValue;
		Node myNext;

		Node(String value, Node next) {
			myValue = value;
			myNext = next;
		}
	}

	// you should not need any more instance variables
	private Node myHead;

	// BE SURE YOU TEST THIS CODE WORKS WITH THE StringLinkedListTester
	// BEFORE YOU SUBMIT!

	public void addAtEnd(String valueToAdd) {
		
		if (myHead == null) {
			myHead = new Node(valueToAdd, null);
			return;
		}
		Node current = myHead;
		while (current.myNext != null) {
			current = current.myNext;

		}
		current.myNext = new Node(valueToAdd, null);

		// your code goes here
	}

	public void addAtBeginning(String valueToAdd) {
		myHead = new Node(valueToAdd, myHead);
	}

	// Removes the longest string from the list
	// so if you have the list [a,b,longstring,z,q]
	// after this function runs you end up with [a,b,z,q]
	// if more than one string has the same longest length, remove the
	// first one
	// if the list is empty, do nothing
	// if the list has only 1 element, remove it
	public void removeLongestString() {
		// your code goes here
		// when you implement this function, be sure to think about
		// a. what if the list is empty
		// b. what if the longest element is the first element
		// c. what if the list has only 1 element
		if (myHead == null)
			return;
		
		if(myHead.myNext==null) {
			myHead=null;
			return;
			}
		
		
		//////a better method
		
		Node current=myHead;
		Node longest=myHead;
		while(current.myNext!=null){
			
			if(current.myNext.myValue.length()>longest.myNext.myValue.length()){
				longest=current;
			}
			
			
			current=current.myNext;
		}
		
		if(myHead.myValue.length()>=longest.myNext.myValue.length())
			myHead=myHead.myNext;
		else longest.myNext=longest.myNext.myNext;
		
		
		
		//////end of a better method, and another method below
		
		
		
		
		
//		Node current=myHead;
//		int longlen=0;
//		int index=0;
//		int longindex=0;
//		while(current!=null){
//			
//			int len=current.myValue.length();
//			if(len>longlen){
//				longlen=len;
//				longindex=index;
//			}
//			current=current.myNext;
//			index++;
//		}
//		
//		
//		if(longindex==0){
//			myHead=myHead.myNext;
//			return;
//		}
//		
//		current=myHead;			
//		while(longindex>1){
//			current=current.myNext;
//			longindex--;}
//		current.myNext=current.myNext.myNext;
//			
//			
		}
		
		
		


	public String toString() {
		// I've written this one for you!
		StringBuilder b = new StringBuilder();
		Node current = myHead;
		while (current != null) {
			b.append(current.myValue);
			// this is a little crude because it prints out a blank for last
			// element too
			// I opted to keep the code extra simple rather than print right
			b.append(" ");
			current = current.myNext;
		}
		return b.toString();
	}

}
