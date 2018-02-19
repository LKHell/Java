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


//

class Solution {
  public int search(int[] nums, int target) {
    int minIdx = findMinIdx(nums);
    if (target == nums[minIdx]) return minIdx;
    int m = nums.length;
    int start = (target <= nums[m - 1]) ? minIdx : 0;
    int end = (target > nums[m - 1]) ? minIdx : m - 1;
    
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) return mid;
        else if (target > nums[mid]) start = mid + 1;
        else end = mid - 1;
    }
    return -1;
  }

  public int findMinIdx(int[] nums) {
    int start = 0, end = nums.length - 1;
    while (start < end) {
        int mid = start + (end -  start) / 2;
        if (nums[mid] > nums[end]) start = mid + 1;
        else end = mid;
    }
  return start;
  }
}
