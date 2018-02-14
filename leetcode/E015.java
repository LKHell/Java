import java.util.ArrayList;
import java.util.Arrays;

// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note: The solution set must not contain duplicate triplets.

// For example, given array S = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]


class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result_list = new ArrayList<>();
    Arrays.sort(nums);
    
    for (int i = 0; i+2 < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i-1]) {   // skip the same result
        continue;  
      }
      int left = i + 1, right = nums.length -1;
      int target = -nums[i];  // left + right = -nums[i]
      while (left < right) {
        if ( nums[left] + nums[right] == target) {
          result_list.add(Arrays.asList(nums[i], nums[left], nums[right]));
          left++;
          right--;
          while (left < right && nums[left] == nums[left -1]) left++;  // skip the same result
          while (left < right && nums[right] == nums[right +1]) right--;
        }
        else if (nums [left] + nums[right] > target) {
          right--;     // nums_right too big
        }
        else {
          left++;
        }
      }
    }
    return result_list;
  }
}