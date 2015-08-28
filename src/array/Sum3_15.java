package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum3_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(threeSum1(new int[] { 0, 0, 0, 0 }));
	}

	public static List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> sumList = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return sumList;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] > nums[i - 1]) {
				int start = i + 1;
				int end = nums.length - 1;
				while (start < end) {
					if (nums[i] + nums[start] + nums[end] == 0) {
						ArrayList<Integer> tempList = new ArrayList<Integer>();
						tempList.add(nums[i]);
						tempList.add(nums[start]);
						tempList.add(nums[end]);
						sumList.add(tempList);
						start++;
						end--;

						// 去掉重复的数据
						while ((start < end) && (nums[end] == nums[end + 1]))
							end--;
						while ((start < end) && (nums[start] == nums[start - 1]))
							start++;
					} else if (nums[i] + nums[start] + nums[end] > 0) {
						end--;
					} else {
						start++;
					}
				}
			}
		}

		return sumList;
	}

	// 时间复杂都过高
	public static List<List<Integer>> threeSum0(int[] nums) {
		List<List<Integer>> sumList = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return sumList;
		for (int i = 0; i < nums.length; i++) {
			while((i < nums.length) && (nums[i]==nums[i+1])){
				i++;
				continue;
			}
				
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[k]);
						sumList.add(temp);
					}
					while((k < nums.length) && (nums[k]==nums[k+1]))
						k++;
				}
				while((j < nums.length) && (nums[j]==nums[j+1]))
					j++;
			}
		}
		return sumList;
	}

}
