package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 第三种方法不理解，按位运算
 * @author Logic
 *
 */

public class MajorityElement169 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// nlog(n)
	public static int majorityElement1(int[] nums) {
		if (null == nums)
			return 0;
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	// O(n)
	public static int majorityElement2(int[] nums) {
		if (nums == null)
			return 0;
		int count = 0;
		int majority = 0;

		for (int i = 0; i < nums.length; i++) {
			if (0 == count) {
				majority = nums[i];
				count = 1;
			} else if (majority == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		return majority;
	}

	// HashMap
	public static int majorityElements3(int nums[]) {
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int a : nums) {
			if (count.containsKey(a)) {
				count.put(a, count.get(a) + 1);
			} else {
				count.put(a, 1);
			}
		}
		for (int item : count.keySet()) {
			if (count.get(item) > (nums.length / 2)) {
				return item;
			}
		}
		return 0;
	}

	// ***按位与
	public int majorityElement(int[] num) {
		if (num == null || num.length == 0)
			return 0;
		int[] dig = new int[32];
		for (int i = 0; i < num.length; i++) {
			int temp = num[i];
			for (int j = 0; j < 32; j++) {
				dig[j] += temp & 1;
				temp = temp >> 1;
			}
		}
		int count = num.length / 2;
		int res = 0;
		int temp = 1;
		for (int i = 0; i < 32; i++) {
			if (dig[i] > count)
				res = res | temp;
			temp = temp << 1;
		}
		return res;
	}

}
