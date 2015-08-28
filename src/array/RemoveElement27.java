package array;

public class RemoveElement27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeElement2(new int[]{3}, 3));
	}
	
	//�ⷨ1
	public static int removeElement(int[] nums, int val) {
        int k=0;
        for (int i=0; i<nums.length; i++) {
        	if(nums[i] == val) {
        		k++;
        		continue;
        	}
        	if(i-k>=0)
        		nums[i-k] = nums[i];
        }
        return nums.length-k;
    }
	
	//�ⷨ��
	public static int removeElement2(int[] nums, int val) {
		//���鳤��size
		int size = nums.length;
		int low =0;
		int high = size-1;
		
		//��¼������val�ĸ���
		int count = 0;
		while(low <= high) {
			
			if(nums[high] == val) {
				count ++;
				high --;
				continue;
			} 
			if(nums[low] == val) {
				count ++;
				nums[low]=high;
				low ++;
				high --;
			} else {
				low ++;
			}
		}
		return size-count;
	}
	
}
