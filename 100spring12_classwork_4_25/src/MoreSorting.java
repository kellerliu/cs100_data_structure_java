import java.util.Arrays;
import java.util.Random;


public class MoreSorting {
    
    public void yourSort(int[] data) {
        //write your own sorting function here
        //don't use Arrays.sort or priority
        //queues or anything else that will do the
        //sort for you.  Develop your own algorithm
        //for sorting
        //
        //You can use recursion if you wish
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
        int[] result = new int[list.length/2];
        int startingPosition;
        if(list.length % 2 == 0) {
            startingPosition = list.length / 2;
        } else {
            startingPosition = list.length / 2 + 1;
        }

        
        for(int i = 0; i < result.length; i++) {
            result[i] = list[startingPosition + i];
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
        int[] result = new int[l1.length + l2.length];
        int top1, top2;
        top1 = top2 = 0; 
        for(int i = 0; i < result.length; i++) {
            if (top1 == l1.length || top2 == l2.length) {
                if (top1 == l1.length) {
                    result[i] = l2[top2];
                    top2++;
                } else { // CHANGED FOR CLASS
                    result[i] = l1[top1];
                    top1++;
                }
            } else {
                if (l1[top1] < l2[top2]) {
                    result[i] = l1[top1];
                    top1++;
                } else {
                    result[i] = l2[top2];
                    top2++;
                }
            }
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
        int pivot = data[pivotIndex];
        int pivotPosition = 0;
        swap(data,pivotIndex, 0);
        for(int i = 1; i < data.length; i++) {
            if(data[i] < pivot) {
                //move the item we want to swap just to the right
                //of the pivot
                swap(data,pivotPosition + 1, i);
                //swap the item we want to swap and the pivot
                swap(data, pivotPosition, pivotPosition+1);
                pivotPosition++;

            }
        }
        return pivotPosition;
    }

    public int pivotList2(int[] data, int pivotIndex, int startingAt, int length) {
        int pivot = data[pivotIndex];
        if(length < 2) return startingAt;
        int pivotPosition = startingAt;
        swap(data,pivotIndex, startingAt);
        for(int i = 1; i < length; i++) {
            if(data[i + startingAt] < pivot) {
                //move the item we want to swap just to the right
                //of the pivot
                swap(data,pivotPosition + 1, startingAt + i);
                //swap the item we want to swap and the pivot
                swap(data, pivotPosition, pivotPosition+1);
                pivotPosition++;

            }
        }
        return pivotPosition;
    }

    
    public int[] mergeSort(int[] input) {
        if(input.length == 0) {
            return new int[0];
        }
        
        if(input.length == 1) {
            int[] result = new int[1];
            result[0] = input[0];
            return result;
        }
        
        int[] l1 = copyFirstHalfOfList(input);
        int[] l2 = copySecondHalfOfList(input);
        int[] l1sorted = mergeSort(l1);
        int[] l2sorted = mergeSort(l2);
        return mergeSortedLists(l1sorted, l2sorted);
    }
    
    public void quickSort(int[] input, int startingFrom, int length) {
        Random r = new Random();
        if(length < 2) return;
        int pivotStartPosition = r.nextInt(length) + startingFrom;
        int pivotEndPosition = pivotList2(input,pivotStartPosition,startingFrom,length);
        int lengthOfFirstPart = pivotEndPosition - startingFrom;
        int lengthOfSecondPart = length - lengthOfFirstPart - 1;
        quickSort(input,startingFrom, lengthOfFirstPart);
        quickSort(input,pivotEndPosition + 1, lengthOfSecondPart);
    }
    
    public static void main(String[] args) {
        MoreSorting s = new MoreSorting();
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

        System.out.println("Data1 mergesort " + Arrays.toString(s.mergeSort(data)));

        
        int[] data4 = {44, 3, 17, 1, 16, 6};
        System.out.println("Data 4: " + Arrays.toString(data4));
        s.pivotList(data4, 5);
        System.out.println("Data4 pivoted on 6 " + Arrays.toString(data4));
        s.quickSort(data4, 0,data4.length);
        System.out.println("Data4 quicksorted " + Arrays.toString(data4));

        
        int[] data5 = new int[20];
        Random r = new Random();
        for(int i = 0; i < data5.length; i++) data5[i] = r.nextInt(100);
        s.quickSort(data5, 0, data5.length);
        System.out.println("Data5 quicksorted " + Arrays.toString(data5));
        

        
    }
}
