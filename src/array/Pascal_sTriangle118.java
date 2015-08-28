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
         * 用于记录前一行元素
         */
        ArrayList<Integer> previousLevel = null;
        /**
         * 用于记录当前行元素
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
        		 * 在每一行的开始加入1
        		 */
        		currentLevel.add(1);
        		for(int j=0; j<i-1; j++) {
        			currentLevel.add(previousLevel.get(j) + previousLevel.get(j+1));
        		}
        		/**
        		 * 每行结束后加入最后一个元素1
        		 */
        		currentLevel.add(1);
        	}
        	result.add(currentLevel);
        }
        
        return result;
    }
}
