package array;

public class PlusOne66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{8,9,9,9};
		
		System.out.println(plusOne(a));
	}

	public static int[] plusOne(int[] digits) {
		//½øÎ»
		int carry = 1;
		for (int i=digits.length-1; i >=0; i--) {
			if((digits[i] + carry) <= 9) {
				digits[i] += 1;
				carry = 0;
				break;
			} else {
				digits[i] =0;
				carry = 1;
			}			
		}
		if(carry == 1) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
			for (int j=0; j<digits.length; j++) {
				newDigits[j+1] = digits[j];
			}
			return newDigits;
		}
        return digits;
    }
}
