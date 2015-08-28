package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[30000];
	}	
	
	//ÀûÓÃÅÅĞò
	public boolean containsDuplicate0(int[] nums) {
       if(null == nums)
    	   return false;
       Arrays.sort(nums);
       for(int i=nums.length-1; i>0; i--)
    	   if(nums[i] == nums[i-1]) {
    		   return true;
    	   }
    		   
       return false;
    }
	
	//¹şÏ£·¨
	public boolean conbtainsDuplicate1(int[] nums) {
		if(null == nums) 
			return false;
		Set<Integer> result = new HashSet<Integer>();
		for(int i=0; i<nums.length; i++) {
			if(result.contains(nums[i]))
				return true;
			else
				result.add(nums[i]);
		}
		return false;
	}
}
