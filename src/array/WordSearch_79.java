package array;

public class WordSearch_79 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][]{{'A','B','C','E'},
			{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(exist2(board,"ABCCED"));
		System.out.println(exist2(board,"SEE"));
		System.out.println(exist2(board,"ABCB"));
	}
	
	public static boolean exist2(char[][] board, String word) {
		int rows = board.length; //����
		int cols = board[0].length; //����
		
		boolean result = false;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(searchLetter(board, word, i, j, 0)) {
					result = true;
				}
			}
		}
		return result;
	}
	
	private static boolean searchLetter(char[][] board, String word, int currentRow, int currentCol, int currnetLetter) {
		// TODO Auto-generated method stub
		int rows = board.length;
		int cols = board[0].length;
		
		//�ж��Ƿ�Խ��
		if(currentRow<0 || currentRow>=rows || currentCol <0 || currentCol>= cols)
			return false;
		if(board[currentRow][currentCol] == word.charAt(currnetLetter)) {
			//��¼board�е�ǰԪ�ص�ֵ
			char temp=board[currentRow][currentCol];
			board[currentRow][currentCol]='#';
			if(currnetLetter == word.length()-1) {
				return true;
			} else if(searchLetter(board, word, currentRow-1, currentCol, currnetLetter+1)
					||searchLetter(board, word, currentRow+1, currentCol, currnetLetter+1)
					||searchLetter(board, word, currentRow, currentCol-1, currnetLetter+1)
					||searchLetter(board, word, currentRow, currentCol+1, currnetLetter+1)){
				return true;
			}
			//�������ʧ�ܣ��ظ�ԭ����Ԫ��
			board[currentRow][currentCol] = temp;
		} 
		return false;
	}

	
	
	public static boolean exist(char[][] board, String word) {
		
		/**
		 * ��ά��������¼�Ѿ�ʹ�õ�·��
		 */
		boolean[][] record = new boolean[board.length][board[0].length];
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				record[i][j] = false;
			}
		}
		
		char[] words = word.toCharArray();
		for(int i=0; i<board[0].length; i++) {//�У�x���� ����
			for(int j=0; j<board.length; j++) {//�У�y���꣬����
				boolean result = existCurrentLetter(record, 0, i, j, words, board);
				if(true == result) {
					for(int m=0; m<board.length; m++) {
						for(int n=0; n<board[0].length; n++) {
							System.out.print(record[m][n] + " ");
						}
						System.out.println();
					}
					return true;
				}
			}
		}
		for(int m=0; m<board.length; m++) {
			for(int n=0; n<board[0].length; n++) {
				System.out.print(record[m][n] + " ");
			}
			System.out.println();
		}
		
        return false;
    }
	
	public static boolean existCurrentLetter(boolean[][] record, int currentStation, int currentX, int currentY, char[] words, char[][] board){
		//������ҵ����һ����ĸ����һ��λ�ã���˵��ʲ�����ϡ�
		if(currentStation >= words.length) {
			return true;
		}
		if(0<=currentX && currentX<board[0].length && 0<=currentY && currentY<board.length) {
			if(board[currentY][currentX]==words[currentStation]) {
				record[currentY][currentX] = true;
			}
			return (board[currentY][currentX]==words[currentStation]) && (
					(!recordExist(record, currentY, currentX-1)&&existCurrentLetter(record, currentStation+1, currentX-1, currentY, words, board)) || //�������һ����ĸ
					(!recordExist(record, currentY, currentX+1)&&existCurrentLetter(record, currentStation+1, currentX+1, currentY, words, board)) || //���Ҳ���һ����ĸ
					(!recordExist(record, currentY-1, currentX)&&existCurrentLetter(record, currentStation+1, currentX, currentY+1, words, board)) || //���²���һ����ĸ
					(!recordExist(record, currentY+1, currentX)&&existCurrentLetter(record, currentStation+1, currentX, currentY-1, words, board))//���ϲ���һ����ĸ
					);
		}
		return false;
	}
	
	public static boolean recordExist(boolean[][] record, int currentY, int currentX){
		if(0<=currentX && currentX<record[0].length && 0<=currentY && currentY<record.length)
			return record[currentY][currentX];
		else
			return true;
	}
}
