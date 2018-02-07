// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

class Solution {
  public int rob(int[] nums) {
    if (nums == null) {
      return 0;
    }

    int a = 0 , b = 0;
    for( int i = 0; i<nums.length; i++){
      if (i%2 == 0) {
         a = Math.max(a+nums[i],b);
      }
      else {
        b = Math.max(a,b+nums[i]);
      }
    }
    return Math.max(a,b);     
  }
}

//
class Solution {
  public int rob(int[] nums) {
    if (nums == null) {
      return 0;
    }

    int prevNo = 0;
    int prevYes = 0;
    for(int num : nums) {
      int temp = prevNo;
      prevNo = Math.max(prevNo,prevYes);
      prevYes = num + temp;
    }
    return Math.max(prevNo,prevYes);     
  }
}