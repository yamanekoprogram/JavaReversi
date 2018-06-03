// �Ֆʏ����Ǘ�����N���X

package MainPackage;

import static MainPackage.Constants.*;

public class Board {
	private int[][] board = new int[8][8];
	private boolean putable = false;
	
	// �Ֆʂ̏�����
	public Board() {
		for (int i=0; i<BOARD_LENGTH; i++) {
			for (int j=0; j<BOARD_LENGTH; j++) {
				board[i][j] = BLANK;
			}
		}
		board[3][3] = BLACK;
		board[4][4] = BLACK;
		board[3][4] = WHITE;
		board[4][3] = WHITE;
	}
	
	public void setCell(int x, int y, int status) {
		board[x][y] = status;
	}
	public int getCell(int x, int y) {
		return board[x][y];
	}
	public void setPutable(boolean b) {
		putable = b;
	}
	public boolean getPutable() {
		return putable;
	}
	
	// ��̐����グ���\�b�h
	public int countCell(int color) {
		int count = 0;
		for (int i=0; i<BOARD_LENGTH; i++) {
			for (int j=0; j<BOARD_LENGTH; j++) {
				if (this.getCell(i, j) == color) count++;
			}
		}
		return count;
	}
	
	// ���s����
	public int jadge() {
		for (int i=0; i<BOARD_LENGTH; i++) {
			for (int j=0; j<BOARD_LENGTH; j++) {
				if (this.getCell(i, j) == BLANK) return 0;
			}
		}
		if (countCell(BLACK) < countCell(WHITE)) {
			return 1;
		} else if (countCell(WHITE) < countCell(BLACK)) {
			return 2;
		} else {
			return 3;
		}
	}
}
