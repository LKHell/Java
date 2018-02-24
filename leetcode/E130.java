// Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

// A region is captured by flipping all 'O's into 'X's in that surrounded region.

// For example,
// X X X X
// X O O X
// X X O X
// X O X X
// After running your function, the board should be:

// X X X X
// X X X X
// X X X X
// X O X X

// X X X X           X X X X             X X X X
// X X O X  ->       X X O X    ->       X X X X
// X O X X           X 1 X X             X O X X
// X O X X           X 1 X X             X O X X

//
class Solution {
  public void solve(char[][] board) {
      int row = board.length;
      if (row == 0) {
          return;
      }
      int col = board[0].length;
      
      for (int i = 0; i < row; i++) {
          check(board, i, 0, row, col); // first column
          if (col > 1) {
              check(board, i, col - 1, row, col); //last column
          }
      }
      for (int j = 1; j < col - 1; j++) {
          check(board, 0, j, row, col);           //fist row
          if (row > 1) {
              check(board, row - 1, j, row, col);   // last row
          }
      }
      for (int i = 0; i < row; i++) {
          for (int j = 0; j < col; j++) {
              board[i][j] = board[i][j] == '*' ? 'O' : 'X';
          }
      }
  }
  
  private void check(char[][] board, int i, int j, int row, int col) {
      if (board[i][j] == 'O') {
          board[i][j] = '*';
          if (i > 1) { //i - 1>0 check left
              check(board, i - 1, j, row, col);
          }
          if (j > 1) { // j-1 >0 check top
              check(board, i, j - 1, row, col);
          }
          if (i + 1 < row) {  //check right
              check(board, i + 1, j, row, col);
          }
          if (j + 1 < col) { //check  bottom
              check(board, i, j + 1, row, col);
          }
      }
  }
}