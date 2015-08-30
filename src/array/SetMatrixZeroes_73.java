package array;

import java.util.Arrays;

public class SetMatrixZeroes_73 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] aaa = new int[][]{{0,0,0,5},{4,3,1,4},{0,1,1,4},{0,0,1,1}};
setZeroes3(aaa);
	}
	
	/**
	 * a constant space
	 * @param matrix
	 */
	public static void setZeroes3(int[][] matrix) {
		/**
		 * ��¼��һ�е�һ���Ƿ�Ϊ��
		 */
		boolean firstRowZero = false;
		boolean firstColZero = false;
		
		/**
		 * �жϵ�һ���Ƿ�Ϊ0
		 */
		for(int i=0; i<matrix.length; i++) {
			if(0 == matrix[i][0]) {
				firstColZero = true;
			}
		}
		
		/**
		 * �жϵ�һ���Ƿ�Ϊ0
		 */
		for(int i=0; i<matrix[0].length; i++) {
			if(0 == matrix[0][i])
				firstRowZero = true;
		}
		
		/**
		 * �����������󣬽�Ҫ��Ϊ0���к��б�ע�ڵ�0�к͵�0��
		 */
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(0 == matrix[i][j]){
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for(int i=1; i<matrix.length; i++) {
			for(int j=1; j<matrix[0].length; j++) {
				if((matrix[0][j] == 0) || (matrix[i][0] == 0))
					matrix[i][j] = 0;
			}
		}
		/**
		 * ��һ���Ƿ�����
		 */
		if(firstRowZero) {
			for(int i=0; i<matrix[0].length; i++)
				matrix[0][i] = 0;
		}
		
		/**
		 * ��һ���Ƿ�����
		 */
		if(firstColZero) {
			for(int i=0; i<matrix.length; i++)
				matrix[i][0] = 0;
		}
	}
	
	/**
	 * O(mn) space
	 * @param matrix
	 */
	public static void setZeroes1(int[][] matrix) {
		int[][] matrixTemp = new int[matrix.length][matrix[0].length];
		//��matrix�е�Ԫ��ȫ�����Ƹ�tempMatrix
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				matrixTemp[i][j] = matrix[i][j];
			}
		}
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(0 == matrix[i][j]){
					//��j��Ԫ������
					for(int m=0; m<matrix.length; m++) {
						matrixTemp[m][j] = 0;
					}
					
					//��i��Ԫ������
					for(int n=0; n<matrix[0].length; n++) {
						matrixTemp[i][n] = 0;
					}
				}	
			}
		}
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = matrixTemp[i][j];
			}
		}
	}
	
	
	/**
	 * O(m + n) space
	 * @param matrix
	 */
	public static void setZeroes0(int[][] matrix) {
		//���ڼ�¼��Щ��Ӧ������Ϊ0
        int[] zeroRows = new int[matrix.length];
        for(int i=0; i<matrix.length; i++) {
        	zeroRows[i] = 1;
        }

        //��¼��Щ��Ӧ������Ϊ0
        int[] zeroCols = new int[matrix[0].length];
        for(int i=0; i<matrix[0].length; i++) {
        	zeroCols[i] = 1;
        }
        
        for(int i=0; i< matrix.length; i++) {
        	for(int j=0; j<matrix[0].length; j++) {
        		if(0 == matrix[i][j]){
        			zeroRows[i] = 0;
        			zeroCols[j] = 0;
        		}
        	}
        }
        
       //������Ϊ0
        for(int i=0; i<matrix.length; i++) {
        	if(0 == zeroRows[i]) {
        		for(int j=0; j<matrix[0].length; j++) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        //������Ϊ0
        for(int i=0; i<matrix[0].length; i++) {
        	if(0 == zeroCols[i]) {
        		for(int j=0; j<matrix.length; j++) {
        			matrix[j][i]=0;
        		}
        	}
        }
    }
}
