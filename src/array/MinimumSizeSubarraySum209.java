package array;

public class MinimumSizeSubarraySum209 {
	public static void main(String[] args) {
		System.out.println(minSubArrayLen3(11, new int[]{1,2,3,4,5}));
		/*System.out.println(minSubArrayLen3(7, new int[]{2,3,1,2,4,3}));
		System.out.println(minSubArrayLen3(4, new int[]{1,4,4}));*/
	}
	public static int min(int start, int end, int s, int[] nums) {
		int leftLength = nums.length;
		int rightLength = nums.length;
		int length = nums.length;
		int sum = 0;
		if(start == end ) {
			System.out.println("start:" + start);
			System.out.println(nums[start]>=s? 1:nums.length);
			return nums[start]>=s? 1:nums.length;
		} else {
			for(int i=start; i<=end; i++) {
				sum += nums[i];
			}
			if(sum>s) {
				length = end-start + 1;
				System.out.println("length = end-start" + length + " " + start + " " + end);
			}
		}
		int mid = (start+end) /2;
		System.out.println("mid:" + mid);
		leftLength =  min(start, mid, s, nums);
		rightLength = min(mid, end, s, nums);
		
		if(leftLength < rightLength) {
			if(leftLength < length)
				return leftLength;
			else
				return length;
		} else {
			if(rightLength < length)
				return rightLength;
			else
				return length;
		}
	}
	public static int minSubArrayLen(int s, int[] nums) {
		int sum = 0;
		int minlength = nums.length;
		int length = 0;
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
			int j=0;
			for(j=i+1; j<nums.length; j++ ) {
				if(sum >= s) {
					length = j-i;
					break;
					
				} else {
					sum += nums[j];
				}
			}
			if(j==nums.length && sum >= s) {
				length = j-i;
			}
			if(minlength > length) {
				minlength = length;
			}
			sum = 0;
		}
		if(minlength != nums.length) {
			return minlength;
		} else {
			return 0;
		}
    }
	
	public static int minSubArrayLen2(int s, int[] nums) {
		int i=0;
		int left = 0;
		int minLength = nums.length;
		int sum = 0;
		for(i=0; i<nums.length; i++) {
			sum += nums[i];
			while(sum >= s) {
				minLength = Math.min(minLength, i-left+1);
				sum -= nums[left++];
			}
		}
		return minLength==nums.length?0:minLength;
	}
	
	public static int minSubArrayLen3(int s, int []nums) {
		return min(0, nums.length -1, s,nums);
	}
	
	
	
/*	public static int min1(int start, int end, int s, int[] nums) {
		if(start == end) {
			
		}
		int mid = (start+end)/2;
	}*/

}
