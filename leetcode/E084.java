import java.util.Stack;

// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


// The largest rectangle is shown in the shaded area, which has area = 10 unit.

// For example,
// Given heights = [2,1,5,6,2,3],
// return 10.

class Solution {
  public int largestRectangleArea(int[] heights) {
     int len = heights.length;
     Stack<Integer> s = new Stack<>();
     int maxArea = 0;
     for (int i = 0 ; i<=len; i++) {
       int h = (i == len ? 0 : heights[i]);
       if(s.isEmpty() || h>= heights[s.peek()]) {
         s.push(i);
       } else {
         int tp = s.pop();
         maxArea = Math.max(maxArea, heights[tp]*(s.isEmpty() ? i : i-1-s.peek()));
         i--;
       }
     } 
     return maxArea;
  }
}

//
class Solution {
  public int largestRectangleArea(int[] heights) {
     /* int n = heights.length;
      Stack<Integer> s = new Stack<>();
      int max = 0;
      for(int i = 0; i <= n; i++) {
          int h = (i == n ? 0 : heights[i]);
          if(s.isEmpty() || h >= heights[s.peek()]) {
              s.push(i);
          } else {
              int cur = s.pop();
              max = Math.max(max, heights[cur] * (s.isEmpty()? i : i - 1 - s.peek()));
              i--;
          }
      }
      return max; */
      return find(heights, 0, heights.length - 1);
  }
  private int find(int[] h, int left, int right){
      if(left>right) return 0;
      if(left==right) return h[left];
      int minIndex=left;
      boolean sorted=true;
      for(int i=left+1; i<=right; i++){
          if(h[i]<h[i-1]) sorted=false;
          if(h[i]<h[minIndex]) minIndex=i;
      }
      if(sorted){
          int max=0;
          for(int i=left; i<=right; i++){
              if(h[i]*(right-i+1)>max) max=h[i]*(right-i+1);
          }
          return max;
      }
      else{
          int maxLeft=find(h, left, minIndex-1);
          int maxRight=find(h, minIndex+1, right);
          int crossMax=h[minIndex]*(right-left+1);
          return Math.max(Math.max(maxLeft, maxRight), crossMax);
      }
  }
}