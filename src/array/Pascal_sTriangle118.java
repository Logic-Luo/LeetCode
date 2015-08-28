package array;

import java.util.ArrayList;
import java.util.List;

public class Pascal_sTriangle118 {

	public static void main(String[] args) {
		System.out.println(generate(6));
	}
	public static List<List<Integer>> generate(int numRows) {
		
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        /**
         * ���ڼ�¼ǰһ��Ԫ��
         */
        ArrayList<Integer> previousLevel = null;
        /**
         * ���ڼ�¼��ǰ��Ԫ��
         */
        ArrayList<Integer> currentLevel = null;
        for (int i=0; i<numRows; i++) {
        	if(i==0) {
        		currentLevel = new ArrayList<Integer>();
        		currentLevel.add(1);
        	} else {
        		previousLevel = (ArrayList<Integer>)result.get(i-1);
        		currentLevel = new ArrayList<Integer>();
        		/**
        		 * ��ÿһ�еĿ�ʼ����1
        		 */
        		currentLevel.add(1);
        		for(int j=0; j<i-1; j++) {
        			currentLevel.add(previousLevel.get(j) + previousLevel.get(j+1));
        		}
        		/**
        		 * ÿ�н�����������һ��Ԫ��1
        		 */
        		currentLevel.add(1);
        	}
        	result.add(currentLevel);
        }
        
        return result;
    }
}
