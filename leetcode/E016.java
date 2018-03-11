import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.TargetLostException;

import sun.security.util.Length;

// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

//     For example, given array S = {-1 2 1 -4}, and target = 1.

//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int len = nums.length;
    int res = 0;
    if(len < 4) {
      for(int num : nums) {
        res += num;
      }
      return res;
    }
    if(3 * nums[0] > target) {
      return nums[0]+nums[1]+nums[2];
    }
    if(3 * nums[nums.length-1] < target) {
      return nums[len-3]+nums[len-2]+nums[len-1];
    }
   res = nums[0]+nums[1]+nums[2];
    
    for(int i = 0 ; i<len-2; i++) {
      int low = i+1;
      int high = len-1;
      while(low < high) {
        int sum = nums[low] + nums[high] + nums[i];
        if(Math.abs(target-res) >= Math.abs(target - sum)) {
          res = sum;
          if(res == target) {
            return res;
          }
        }
        if(sum > target) {
          high--;
        } else if(sum < target) {
          low++;
        }
      }
    }
    return res;
  }
}
