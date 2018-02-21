import javax.swing.plaf.basic.BasicBorders.MarginBorder;

// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

class Solution {
  public void setZeroes(int[][] matrix) {
      boolean firstRowZero = false;
      boolean firstColZero = false;
      int rows = matrix.length;
      int cols = matrix[0].length;
      //check frist row
      for(int i = 0; i < cols; ++i){
          if(matrix[0][i] == 0){
              firstRowZero = true;
              break;
          }
      }
      //check first col
      for(int i = 0; i < rows; ++i){
          if(matrix[i][0] == 0){
              firstColZero = true;
              break;
          }
      }
      
      //set bit
      for(int r = 1; r < rows; ++r){
          for(int c = 1; c < cols; ++c){
              if(matrix[r][c] == 0){
                  matrix[r][0] = 0;
                  matrix[0][c] = 0;
              }
          }
      }
      
      //set rows to zero
      for(int i = 1; i < rows; ++i){
          if(matrix[i][0] == 0){
              for(int j = 0; j < cols; ++j){
                  matrix[i][j] = 0;
              }
          }
      }
      
      //set cols to zero
      for(int i = 1; i < cols; ++i){
          if(matrix[0][i] == 0){
              for(int j = 0; j < rows; ++j){
                  matrix[j][i] = 0;
              }
          }
      }
      
      //set first row to zero
      if(firstRowZero){
          for(int j = 0; j < cols; ++j){
              matrix[0][j] = 0;
          }
      }
      
      //set first col to zero
      if(firstColZero){
          for(int j = 0; j < rows; ++j){
              matrix[j][0] = 0;
          }
      }
      
  }
}


// use 1 boolean;
class Solution {
  public void setZeroes(int[][] matrix) {
    boolean first_row_zero = false;
    int rows = matrix.length;
    int cols = matrix[0].length;

    //check first row 
    for (int i=0; i<cols; i++){
      if(matrix[0][i] == 0) {
        first_row_zero = true;
        break;
      }
    }

    //set bit
    for (int r = 1; r<rows; r++) {
      for(int c = 0; c<cols; c++) {
        if(matrix [r][c] == 0) {
          matrix [r][0] = 0;
          matrix [0][c] = 0;
        }
      }
    }

    //set zero
    for(int r = 1; r<rows; r++) {
      if(matrix[r][0]==0) {
        for(int c = 0; c<cols; c++) {
          matrix[r][c] = 0;
        }
      }
    }
    for(int c = 0; c<cols; c++) {
      if(matrix[0][c] == 0) {
        for(int r = 0; r < rows; r++) {
          matrix[r][c]=0;
        }
      }
    }

    //set first row 
    if (first_row_zero ) {
      for(int c = 0; c<cols; c++) {
        matrix[0][c] = 0;
      }
    }
  }
}