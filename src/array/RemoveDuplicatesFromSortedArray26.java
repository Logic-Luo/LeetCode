package array;
/**
 * 注意count的初值，提交三次
 *
 */
public class RemoveDuplicatesFromSortedArray26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,1,1};
		int length = removeDuplicates(nums);
		System.out.println(length);
		for(int k=0; k<length; k++) {
			System.out.print(nums[k] + ",");
		}
	}

	public static int removeDuplicates(int[] nums) {
		int k=0;
		int count=1;
		for (int i=1; i<nums.length; i++) {
			if((nums[i-1] == nums[i]) && (count>=2)) {
				k++;
				continue;
			} else {
				if(nums[i-1] == nums[i]) {
					count++;
				} else {
					count=1;
				}
				nums[i-k] = nums[i];
			}
		}
		return nums.length-k;
	}
}
