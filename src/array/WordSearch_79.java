package array;

import java.util.ArrayList;
import java.util.List;

public class WordSearch_79 {

	public static WordSearch_79 w = new WordSearch_79();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][]{{'A','B','C','E'},
			{'S','F','C','S'},{'A','D','E','E'}};
//		System.out.println(exist(board,"ABCCED"));
//		System.out.println(exist(board,"SEE"));
		System.out.println(exist(board,"ABCB"));
	}
	
	
	class Coordinate {
		private int X;
		private int Y;
		public Coordinate(int x, int y) {
			super();
			X = x;
			Y = y;
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Coordinate coordinate = (Coordinate)obj;
			if(coordinate.X==this.X && coordinate.Y == this.X)
				return true;
			else
				return false;
		}
		
	}
	
	public static boolean exist(char[][] board, String word) {
		
		char[] words = word.toCharArray();
		List<Coordinate> coordinates = new ArrayList<Coordinate>();
//		return existCurrentLetter(0, 3, 1, words, board);
		for(int i=0; i<board[0].length; i++) {//行，x坐标 左右
			for(int j=0; j<board.length; j++) {//列，y坐标，上下
				boolean result = existCurrentLetter(coordinates, 0, i, j, words, board);
				if(true == result) {
					return true;
				}
			}
		}
        return false;
    }
	
	public static boolean existCurrentLetter(List<Coordinate> coordinates,int currentStation, int currentX, int currentY, char[] words, char[][] board){
		//如果查找到最后一个字母的下一个位置，则此单词查找完毕。
		if(currentStation >= words.length) {
			return true;
		}
		if(0<=currentX && currentX<board[0].length && 0<=currentY && currentY<board.length) {
			boolean currentCorrect = board[currentY][currentX]==words[currentStation];
			boolean left = false;
			boolean right = false;
			boolean up = false;
			boolean down = false;
			if(true == currentCorrect)
				coordinates.add(w.new Coordinate(currentX, currentY));
			if(coordinates.contains(w.new Coordinate(currentX-1,currentY)))
					left = false;
			else
				left = existCurrentLetter(coordinates, currentStation+1, currentX-1, currentY, words, board);
			
			if(coordinates.contains(w.new Coordinate(currentX+1,currentY)))
				right = false;
			else
				right = existCurrentLetter(coordinates, currentStation+1, currentX+1, currentY, words, board);
			
			if(coordinates.contains(w.new Coordinate(currentX,currentY-1)))
				up = false;
			else
				up = existCurrentLetter(coordinates, currentStation+1, currentX, currentY-1, words, board);
			
			if(coordinates.contains(w.new Coordinate(currentX,currentY+1)))
				down = false;
			else
				down = existCurrentLetter(coordinates, currentStation+1, currentX, currentY+1, words, board);
		return currentCorrect && (left||right||up||down);
		}
		return false;
	}
}
