import java.util.List;

// Given numRows, generate the first numRows of Pascal's triangle.

// For example, given numRows = 5,
// Return

// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    
    if (numRows == 0) {
      return triangle;
    }

    triangle.add(new ArrayList<>());
    triangle.get(0).add(1);

    for(int rowNum=1; rowNum < numRows; rowNum++) {
      List<Integer> row = new ArrayList<>();
      List<Integer> prevRow = triangle.get(rowNum-1);
      
      row.add(1);
      for(int j=1; j<(rowNum); j++) {
        row.add(prevRow.get(j-1)+prevRow.get(j));
      }
      row.add(1);
      
      triangle.add(row);
    }
    return triangle;
  }
}