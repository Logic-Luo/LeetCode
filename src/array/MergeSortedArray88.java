package array;

/**
 * We ma assume that nums1 has enough space
 * @author Logic
 *
 */
public class MergeSortedArray88 {

	public static void main(String[] args) {
		int[] nums1 = new int[0];
		int[] nums2 = new int[]{1};
		merge1(nums1, 0, nums2, 1);
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if((nums1==null) && (nums2==null))
			return;
		/**
		 * 记录nums1中最后一个元素的位置
		 */
        int i = m-1;
        /**
         * 记录nums2中最后一个元素的位置
         */
        int j = n-1;
        /**
         * 记录归并结束后最后一个元素的位置
         */
        int k = m+n-1;
        while ((i>=0) && (j>=0)) {
        	if(nums1[i] > nums2[j]) {
        		nums1[k--] = nums1[i--];
        	} else {
        		nums1[k--] = nums2[j--];
        	}
        }
        
        //add remains elements to result
        while(j>=0) {
        	nums1[k--] = nums2[j--];
        }
        for(int a: nums1)
			System.out.print(a + ",");
    }
	
	public static void merge1(int nums1[], int m, int nums2[], int n) {
	    if(nums1==null || nums2==null)
	        return;
	    int idx1 = m-1;
	    int idx2 = n-1;
	    int len = m+n-1;
	    while(idx1>=0 && idx2>=0)
	    {
	        if(nums1[idx1]>nums2[idx2])
	        {
	        	nums1[len--] = nums1[idx1--];
	        }
	        else
	        {
	        	nums1[len--] = nums2[idx2--];
	        }
	    }
	    while(idx2>=0)
	    {
	    	nums1[len--] = nums2[idx2--];
	    }        
	}
}
