package MainPackage;

import static MainPackage.Constants.*;

public class GameSystem {
	
	// 盤面の更新メソッド
	public static Board boardCheck(Board board,int turn, int x, int y) {
		int playersCell, enemysCell;
		int targetCell;
		boolean[] putable = new boolean[8];
		
		if (turn == PLAYER) {
			playersCell = WHITE;
			enemysCell  = BLACK;
		} else {
			playersCell = BLACK;
			enemysCell  = WHITE;
		}
		
		if (board.getCell(x, y) != BLANK) {
			board.setPutable(false);
			return board;
		}
		
		// 上
		for (int i=y-1; i>=0; i--) {
			targetCell = board.getCell(x, i);
			if (targetCell != enemysCell) {
				if (i == y-1) {
					putable[0] = false;
					break;
				} else {
					if (targetCell == playersCell) {
						board.setCell(x, y, playersCell);
						for (int j=i; j<y; j++) {
							board.setCell(x, j, playersCell);
						}
						putable[0] = true;
						break;
					}
				}
			}
		}
		//　右
		for (int i=x+1; i<BOARD_LENGTH; i++) {
			targetCell = board.getCell(i, y);
			if (targetCell != enemysCell) {
				if (i == x+1) {
					putable[1] = false;
					break;
				} else {
					if (targetCell == playersCell) {
						board.setCell(x, y, playersCell);
						for (int j=i; j>x; j--) {
							board.setCell(j, y, playersCell);
						}
						putable[1] = true;
						break;
					}
				}
			}
		}
		//　左
		for (int i=x-1; i>=0; i--) {
			targetCell = board.getCell(i, y);
			if (targetCell != enemysCell) {
				if (i == x-1) {
					putable[2] = false;
					break;
				} else {
					if (targetCell == playersCell) {
						board.setCell(x, y, playersCell);
						for (int j=i; j<x; j++) {
							board.setCell(j, y, playersCell);
						}
						putable[2] = true;
						break;
					}
				}
			}
		}
		//　下
		for (int i=y+1; i<BOARD_LENGTH; i++) {
			targetCell = board.getCell(x, i);
			if (targetCell != enemysCell) {
				if (i == y+1) {
					putable[3] = false;
					break;
				} else {
					if (targetCell == playersCell) {
						board.setCell(x, y, playersCell);
						for (int j=i; j>y; j--) {
							board.setCell(x, j, playersCell);
						}
						putable[3] = true;
						break;
					}
				}
			}
		}
		// 斜め右下
		int i = x + 1, j = y + 1;
		while(i < BOARD_LENGTH && j < BOARD_LENGTH) {
			targetCell = board.getCell(i, j);
			if (targetCell != enemysCell) {
				if (i == x+1 || j == y+1) {
					putable[4] = false;
					break;
				} else {
					if (targetCell == playersCell) {
						board.setCell(x, y, playersCell);
						int ti = i, tj = j;
						while(ti > x && tj > y) {
							board.setCell(ti, tj, playersCell);
							ti--;
							tj--;
						}
						putable[4] = true;
						break;
					}
				}
			}
			i++;
			j++;
		}
		
		//　斜め左下
		i = x - 1;
		j = y + 1;
		while(i >= 0 && j < BOARD_LENGTH) {
			targetCell = board.getCell(i, j);
			if (targetCell != enemysCell) {
				if (i == x-1 || j == y+1) {
					putable[5] = false;
					break;
				} else {
					if (targetCell == playersCell) {
						board.setCell(x, y, playersCell);
						int ti = i, tj = j;
						while(ti < x && tj > y) {
							board.setCell(ti, tj, playersCell);
							ti++;
							tj--;
						}
						putable[5] = true;
						break;
					}
				}
			}
			i--;
			j++;
		}
		//　斜め右上
		i = x + 1;
		j = y - 1;
		while(i < BOARD_LENGTH && j >= 0) {
			targetCell = board.getCell(i, j);
			if (targetCell != enemysCell) {
				if (i == x+1 || j == y-1) {
					putable[6] = false;
					break;
				} else {
					if (targetCell == playersCell) {
						board.setCell(x, y, playersCell);
						int ti = i, tj = j;
						while(ti > x && tj < y) {
							board.setCell(ti, tj, playersCell);
							ti--;
							tj++;
						}
						putable[6] = true;
						break;
					}
				}
			}
			i++;
			j--;
		}
		//　斜め左上
		i = x - 1;
		j = y - 1;
		while(i >= 0 && j >= 0) {
			targetCell = board.getCell(i, j);
			if (targetCell != enemysCell) {
				if (i == x-1 || j == y-1) {
					putable[7] = false;
					break;
				} else {
					if (targetCell == playersCell) {
						board.setCell(x, y, playersCell);
						int ti = i, tj = j;
						while(ti < x && tj < y) {
							board.setCell(ti, tj, playersCell);
							ti++;
							tj++;
						}
						putable[7] = true;
						break;
					}
				}
			}
			i--;
			j--;
		}
		
		
		boolean temp = false;
		for (int n=0; n<putable.length; n++) {
			temp = (temp || putable[n]);
		}
		board.setPutable(temp);
		
		return board;
	}
}
