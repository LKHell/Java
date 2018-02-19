import com.sun.tools.classfile.TypeAnnotation.TargetType;

// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.

class Solution {
  public int search(int[] nums, int target) {
    int lo = 0, hi = nums.length-1;

    while (lo <= hi) {
      int mid = lo + (hi - lo)/2;
      int num = nums[mid];
// double num = 
// (nums[mid] < nums[0]) == (target < nums[0]) ? 
// nums[mid] : target < nums[0] ? 
//           -INFINITY : INFINITY;
      if ((nums[mid] < nums[0] ) == (target < nums[0])) {
        num = nums[mid];
      }
      else {
        num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
      }

      if (num < target) {
        lo = mid + 1;
      }
      else if (num > target) {
        hi = mid - 1;
      }
      else {
        return mid;
      }

    }

    return -1;

  }
}


