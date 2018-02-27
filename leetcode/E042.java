import jdk.nashorn.internal.runtime.regexp.joni.exception.JOniException;

// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

class Solution {
  public int trap(int[] height) {
    
      int ans = 0;
      int black_area =0;
      int maxheight = 0;
      for(int i : height) {
        black_area += i;
        maxheight = Math.max(maxheight, i);
      }

      for(int i = 0; i<maxheight; i++) {
        int left = 0;
        int right = height.length-1;
        while(left <= right) {
          if(height [left] > i && height [right] > i) {
            ans += right - left +1;
            break;
          } 
          if(height [left] <= i) {
            left++;
          }
          if(height [right] <= i) {
            right--;
          }
        }
      }
      // System.out.println("ans = "+ans);
      // System.out.println("black = "+black_area);
      if(ans > 0){
        ans -= black_area;
      }
        return ans;
  } 
}


class Solution {
  public int trap(int[] height) {
    int left = 0, right =height.length-1,sum = 0;

    while(left<right && height[left] < height[left +1]) {
      left++;
    }
    while(left<right && height[right] < height[right -1]) {
      right--;
    }
    while(left<right) {
      int r =height[right];
      int l = height[left];
      if(l<=r) {
        while(left < right && l>height[++left]) {
          sum += l - height[left];
        }
      }else {
        while(left<right && r>height[--right]) {
          sum += r -height[right];
        }
      }
     
    }
    return sum;
  }
}


//
class Solution {
  public int trap(int[] height) {
      int left = 0, right = height.length - 1, maxleft = 0, maxright = 0, res = 0;        
      while(left < right){
          if(height[left] < height[right]){
              if(height[left] > maxleft)
                  maxleft = height[left];
              else 
                  res += maxleft - height[left];
              left++;
          } else {
              if(height[right] > maxright)
                  maxright = height[right];
              else 
                  res += maxright - height[right];
              right--;
          }
      }
      return res;
  }
}