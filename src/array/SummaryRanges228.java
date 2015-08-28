package array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
	public static void main(String[] args) {
		System.out.println(summaryRanges(new int[]{0,1,2,4,5,7,7}));
	}
	
	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		int start = 0;
		int end = 0;
		for (int i=0; i<nums.length; i++) {
			if((i+1) < nums.length) {
				if((nums[i+1]==nums[i]) || (nums[i+1]==(nums[i]+1))) {
					end++;
					continue;
				} else {
					end = i;
				}
			} else {
				end = i;
			}
			
			if(nums[start] == nums[end]) {
				result.add(nums[start] + "");
			} else {
				result.add(nums[start] + "->" + nums[end]);
			}
			
			start = end+1;
			end = end+1;
		}
		return result;
    }
}
