import java.util.Arrays;


public class Sorting {
    
    public void yourSort(int[] data) {
        //write your own sorting function here
        //don't use Arrays.sort or priority
        //queues or anything else that will do the
        //sort for you.  Develop your own algorithm
        //for sorting
        //
        //You can use recursion if you wish
    	for(int i=0;i<data.length;i++){
    		int lowest=i;
    		for(int j=lowest+1;j<data.length;j++){
    			if(data[lowest]>data[j]){
    				lowest=j;
    			}	
    		}
    		swap(data,i,lowest);
    		
    	}
    	
    	
    	
    	
    }
    
    public int[] copyFirstHalfOfList(int[] list) {
        //this function should be easy but be careful
        //of the edge cases
        //
        //It should take a list [1, 2, 3] and make a copy
        //of it.  If the list is an odd size, the first
        //half should be LARGER (e.g. [1,2])
        //
        //If the list has 1 element, then the copy is the 
        //same as the original 
        //
        //If the list is empty the copy is empty
        int resultLength; 
        if(list.length % 2 == 0) {
            resultLength = list.length / 2;
        } else {
            resultLength = list.length / 2 + 1;
        }
        int[] result = new int[resultLength];
        for(int i = 0; i < resultLength; i++) {
            result[i] = list[i];
        }
        return result;
    }

    public int[] copySecondHalfOfList(int[] list) {
        //this function should be easy but be careful
        //of the edge cases
        //
        //It should take a list [1, 2, 3] and make a copy
        //of it.  If the list is an odd size, the second
        //half should be SMALLER (e.g. [3])
        //
        //If the list has 1 element, then the copy is 
        //empty
        //
        //If the list is empty the copy is empty
    	int resultLength; 
        if(list.length % 2 == 0) {
            resultLength = list.length / 2;
        } else {
            resultLength = list.length / 2 + 1;
        }
        int[] result = new int[list.length-resultLength];
        for(int i = resultLength; i < list.length; i++) {
            result[i-resultLength] = list[i];
        }
        return result;
        }

    public int[] mergeSortedLists(int[] l1, int[] l2) {
        //l1 and l2 are both sorted
        //we want to create a new list that has
        //both of them sorted together
        //key idea:
        // we want to keep 2 variables, both of which
        // represent the index of the "top" of the 
        // sorted list
        // the next item in the list must come from
        // one of these two tops
    	int len1=l1.length;
    	int len2=l2.length;
    	int [] result=new int[len1+len2];
    	int t1=0;
    	int t2=0;
    	while(t1<len1&&t2<len2){
    		if(l1[t1]<=l2[t2]){
    			result[t1+t2]=l1[t1];
    			t1++;  			
    		}
    		else{
    			result[t1+t2]=l2[t2];
    			t2++;
    		}  		
    	}
    	
    	while(t1==len1&&t2<len2){
    		
    		result[t1+t2]=l2[t2];
    		t2++;
    		
    	}
    	
    	while(t1<len1&&t2==len2){
    		
    		result[t1+t2]=l1[t1];
    		t1++;
    		
    	}
    	
    	
        return result;
    }
    
    public void swap(int[] data, int a, int b) {
        int val = data[a];
        data[a] = data[b];
        data[b] = val;
    }
    
    //selects the element at pivotIndex and uses that to
    //"sort" the list into two chunks...
    //those smaller than the pivot and those bigger than the
    //pivot.  The function should return the final position of the pivot
    public int pivotList(int[] data, int pivotIndex) {
        return 0;
    }
    
    public int[] mergeSort(int[] input) {
        // should return a new list in sorted order
        return new int[0];
    }
    
    public void quickSort(int[] input) {
        
    }
    
    public static void main(String[] args) {
        Sorting s = new Sorting();
        int[] data = {44, 3, 17, 1, 16, 6};
        s.yourSort(data);
        System.out.println("Data sorted: " + Arrays.toString(data));
        
        int[] data2 = {1,2,3};
        int[] data2part1 = s.copyFirstHalfOfList(data2);
        int[] data2part2 = s.copySecondHalfOfList(data2);        
        System.out.println("Data2 first half: " + Arrays.toString(data2part1));
        System.out.println("Data2 second half: " + Arrays.toString(data2part2));
        
        int[] data3 = {1,5,6,2,3,4};
        int[] data3part1 = s.copyFirstHalfOfList(data3);
        int[] data3part2 = s.copySecondHalfOfList(data3);        
        int[] data3sorted = s.mergeSortedLists(data3part1, data3part2);
        System.out.println("Data3 first half: " + Arrays.toString(data3part1));
        System.out.println("Data3 second half: " + Arrays.toString(data3part2));
        System.out.println("Data3 merged " + Arrays.toString(data3sorted));
        
        int[] data4 = {44, 3, 17, 1, 16, 6};
        s.pivotList(data4, 2);
        System.out.println("Data4: " + Arrays.toString(data4));
        System.out.println("Data4 pivoted on 17 " + Arrays.toString(data4));
    }
}
