package test;

public class AndByBit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[]{1,2,3,5,4,9};
		int sum1=0;
		int sum2=0;
		for (int i=0; i<nums.length; i++) {
			//sum1+=Math.abs(nums[i]);
			sum1+=nums[i];
		}
		for(int j=0; j<nums.length; j++) {
			//sum2 = sum2^Math.abs(nums[j]);
			sum2 = sum2^nums[j];
		}
		
		System.out.println(sum1);
		System.out.println(sum2);
	}
}
