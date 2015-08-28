package array;
/**
 * LeetCode 189  Rotate Array
 * �ܽ᣺��������Ƶ�λ��k�������鳤�ȵĻ����Ϳ�����k-length,�����м�ʡȥ������
 * ��������rotate�����е�if�ж�
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
