package array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2_219 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3,1,2,3};
		
		System.out.println(containsDuplicate0(nums, 2));
	}	
	
	//利用排序
	public static boolean containsDuplicate0(int[] nums, int k) {
       if(null == nums)
    	   return false;
       Set<Integer> result = new HashSet<Integer>();
       int start = 0;
       int end =0;
       for(int i=0; i<nums.length; i++) {
    	   if(result.contains(nums[i])) {
    		   return true;
    	   } else {
    		   result.add(nums[i]);
    		   end++;
    	   }
    	   if((end - start) > k){
    		   result.remove(nums[start]);
    		   start++;
    	   }
       }
       
       return false;
    }
	
	//利用Map
	
}
