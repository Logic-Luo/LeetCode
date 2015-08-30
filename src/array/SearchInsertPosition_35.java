package array;

public class SearchInsertPosition_35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchInsert2(new int[]{1,3,5,6},5));
		System.out.println(searchInsert2(new int[]{1,3,5,6},2));
		System.out.println(searchInsert2(new int[]{1,3,5,6},7));
		System.out.println(searchInsert2(new int[]{1,3,5,6},0));
	}
	
	/**
	 * 二分查找
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert2(int[] nums, int target) {
		if(nums == null)
			return 0;
		int low = 0;
		int high = nums.length-1;
		int mid = 0;;
		
		while(low < high) {
			mid = (low + high) / 2;
			if(nums[mid] == target)
				return mid;
			else if(nums[mid] > target)
				high = mid-1;
			else
				low = mid+1;
		}
		
		if(nums[low] >= target)
			return low;
		else 
			return low+1;
	}
	//常规方法
	public static int searchInsert(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
        	if(target == nums[i] || target < nums[i])
        		return i;
        	 else {
        		if(i<nums.length-1) {
        			continue;
        		} else {
        			return nums.length;
        		}
        	}
        }
        return nums.length;
    }
	
}
