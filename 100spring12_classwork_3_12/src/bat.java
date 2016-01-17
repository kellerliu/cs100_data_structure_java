import java.util.ArrayList;

public class bat{


public boolean groupSum(int start, int[] nums, int target) {
	  
	  
	  if(start==nums.length){
	  if(target==0) return true;
	  return false;
	  }
	  
	  
	  if(nums[start]==target)
	  return true;
	  
	  if(groupSum(start+1,nums, target-nums[start]))
	  return true;
	  
	  if(groupSum(start+1,nums, target))
	  
	  return true;
	  
	  return false;
	  
	  
	}

public boolean groupNoAdj(int start, int[] nums, int target) {
	  
    
	  if(start>=nums.length){
	  if(target==0) return true;
	  return false;
	  }

	  if(nums[start]==target)
	  return true;
	  
	  if(groupNoAdj(start+2,nums, target-nums[start]))
	  return true;
	  
	  if(groupNoAdj(start+1,nums, target))
	  
	  return true;
	  
	  return false;

}


public boolean splitArray(int[] nums) {
	  if(nums.length==1) return false;

	  ArrayList<Integer> numList= new ArrayList<Integer>();
	  for(int i=0;i<nums.length;i++)
	  numList.add(nums[i]);
	  return CanSplit(numList, 0, 0);
	}
	public boolean CanSplit(ArrayList<Integer> list, int g1, int g2){
	 if(list.size()==0){
	  if (g1==g2)
	 return true;
	 return false;
	 }
	int first=list.remove(0);
	 if(CanSplit(list, g1+first, g2)||CanSplit(list, g1, g2+first))
	 return true; 
	 list.add(0,first); 
	return false;
	}



}
