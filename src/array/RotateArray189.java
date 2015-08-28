package array;
/**
 * LeetCode 189  Rotate Array
 * 总结：如果向右移的位数k大于数组长度的话，就可以用k-length,这样中间省去几步，
 * 具体是在rotate方法中的if判断
 */
public class RotateArray189 {

	public static void main(String[] args) {
		
		int[] nums = {1};
		rotate(nums, 2);
		for(int a: nums) {
			System.out.print(a + ",");
		}
	}

	public static void rotate(int[] nums, int k) {
		if(k>nums.length) {
			k-=nums.length;
		}
		reverse(nums, 0, nums.length-k-1);
		reverse(nums, nums.length-k, nums.length-1);
		reverse(nums, 0, nums.length-1);
	}
	
	public static void reverse(int[] nums, int start, int end){
		int temp = 0;
		while(start < end) {
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

}
