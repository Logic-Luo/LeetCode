package array;

public class UniquePaths_62 {

	public static void main(String[] args) {
		System.out.println(uniquePaths2(12, 23));
	}
	
	//��̬�滮
	public static int uniquePaths2(int m, int n) {
		if(0==m || 0==n) 
			return 0;
		//һ��һ��ֻ����һ�����
		if(1==m && 1==n)
			return 1;
		
		int[][] dynamicPlanning = new int[m][n];
		
		//�������һ�н��и�ֵ1����ʶ�ӿ�ʼ�㵽��˵�����һ���ط�ֻ��һ�ְ취
		for(int i=0; i<m; i++)
			dynamicPlanning[i][0] = 1;
		//�����Ϸ�һ�и�ֵ1����ʾ�ӿ�ʼ�㵽�϶�����һ���ط�ֻ��һ�ַ���
		for(int i=0; i<n; i++)
			dynamicPlanning[0][i] = 1;
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) 
				//�����ά����������һ����ܺ�Ϊ��λ���Ϸ�����Ԫ��֮��
				dynamicPlanning[i][j] = dynamicPlanning[i-1][j] + dynamicPlanning[i][j-1];
		}
		return dynamicPlanning[m-1][n-1];
	}
	
	
	//�������
	public static int uniquePaths(int m, int n) {
		return deepFirstSearch(m, n, 0, 0);
    }
	
	public static int deepFirstSearch(int m, int n, int i, int j) {
		if((i==m-1) && (j==n-1))
			return 1;
		
		if((i<m) && (j<n))
			return deepFirstSearch(m, n, i+1, j) + deepFirstSearch(m, n, i, j+1);
		
		if(i<m)
			return deepFirstSearch(m, n, i+1, j);
		
		if(j<n)
			return deepFirstSearch(m, n, i, j+1);
		
		return 0;
	}
}
