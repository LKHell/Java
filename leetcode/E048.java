// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// Note:
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

// Example 1:

// Given input matrix = 
// [
//   [1,2,3],
//   [4,5,6],
//   [7,8,9]
// ],

// rotate the input matrix in-place such that it becomes:
// [
//   [7,4,1],
//   [8,5,2],
//   [9,6,3]
// ]
// Example 2:

// Given input matrix =
// [
//   [ 5, 1, 9,11],
//   [ 2, 4, 8,10],
//   [13, 3, 6, 7],
//   [15,14,12,16]
// ], 

// rotate the input matrix in-place such that it becomes:
// [
//   [15,13, 2, 5],
//   [14, 3, 4, 1],
//   [12, 6, 8, 9],
//   [16, 7,10,11]
// ]

 /*
 * clockwise rotate
 * 
 * 1 2 3     1 4 7     7 4 1
 * 4 5 6  => 2 5 8  => 8 5 2
 * 7 8 9     3 6 9     9 6 3
*/

class Solution {
    public void rotate(int[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
          for(int j=i; j<matrix[0].length; j++) { //j = i not j = 0
            int temp = 0;
            temp = matrix[i][j];
            matrix [i][j] = matrix [j][i];
            matrix [j][i] = temp;
          }
        }
        for (int i=0; i<matrix.length; i++) {
          for (int j =0; j<matrix.length/2; j++) {
            int temp = 0;
            temp = matrix [i][j];
            matrix [i][j] = matrix[i][matrix.length-1-j];
            matrix [i][matrix.length-1-j] = temp;
          }
        }
    }
}

 /*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/

class Solution {
public void rotate(int[][] matrix) {
    int s = 0, e = matrix.length - 1;
    while(s < e){
        int[] temp = matrix[s];
        matrix[s] = matrix[e];
        matrix[e] = temp;
        s++; e--;
    }

    for(int i = 0; i < matrix.length; i++){
        for(int j = i+1; j < matrix[i].length; j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
}
}