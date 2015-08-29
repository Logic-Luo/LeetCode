package array;

public class UniquePaths_62 {

	public static void main(String[] args) {
		System.out.println(uniquePaths2(12, 23));
	}
	
	//动态规划
	public static int uniquePaths2(int m, int n) {
		if(0==m || 0==n) 
			return 0;
		//一行一列只能有一种情况
		if(1==m && 1==n)
			return 1;
		
		int[][] dynamicPlanning = new int[m][n];
		
		//给最左端一行进行赋值1，标识从开始点到左端的任意一个地方只有一种办法
		for(int i=0; i<m; i++)
			dynamicPlanning[i][0] = 1;
		//给最上放一行赋值1，表示从开始点到上端任意一个地方只有一种方法
		for(int i=0; i<n; i++)
			dynamicPlanning[0][i] = 1;
		
		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) 
				//到达二维数组中任意一点的总和为其位置上方和左方元素之和
				dynamicPlanning[i][j] = dynamicPlanning[i-1][j] + dynamicPlanning[i][j-1];
		}
		return dynamicPlanning[m-1][n-1];
	}
	
	
	//深度优先
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
