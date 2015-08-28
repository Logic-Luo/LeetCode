package array;

import java.util.ArrayList;
import java.util.List;

public class Pascal_sTriangle119 {

	public static void main(String[] args) {
		System.out.println(getRow(0));
	}
	
	public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> currentLevel = new ArrayList<Integer>();
        for (int i=0; i<rowIndex+1; i++) {
        	currentLevel.add(i, 1);
        	for(int j=i-1; j>0; j--) {
        		currentLevel.set(j, currentLevel.get(j) + currentLevel.get(j-1));
        	}
        }
        return currentLevel;
    }
}
