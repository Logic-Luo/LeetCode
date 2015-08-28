package bitmanipulation;

/**
 * LeetCode 191	Number of 1 Bits
 * @author Logic
 */
public class NumberOf1Bit {

	public static void main(String[] args) {
		long a = 2147483648l;
		System.out.println(hammingWeight(a));
	}
	
	public static int hammingWeight(long n){
		int count = 0;
		while(n!=0) {
			if(n%2 == 1)
				count++;
			n = n/2;
		}
		return count;
	}
}
