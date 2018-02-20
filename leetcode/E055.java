// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// For example:
// A = [2,3,1,1,4], return true.

// A = [3,2,1,0,4], return false.

// O(n)
class Solution {
  public boolean canJump(int[] nums) {
    int last_point = nums.length-1;
    for (int i = nums.length -1 ; i >= 0; i--) {
      if( i + nums[i] >= last_point) {
        last_point = i ;
      }
    }
    return last_point == 0;
  }
}


//

class Solution {
  public boolean canJump(int[] nums) {
      
      if(nums.length == 0) return false;
      if(nums.length ==1) return true;
      
      for(int i= nums.length -2; i>=0; i--){
          if(nums[i] == 0){
              int jumpsNeeded = 1;
              while(jumpsNeeded > nums[i]){
                  jumpsNeeded++;
                  i--;
                  if(i<0) return false;
              }
          }
      }
      return true;
      
  }
}

// O(2^n)
public class Solution {
  public boolean canJumpFromPosition(int position, int[] nums) {
      if (position == nums.length - 1) {
          return true;
      }

      int furthestJump = Math.min(position + nums[position], nums.length - 1);
      for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
          if (canJumpFromPosition(nextPosition, nums)) {
              return true;
          }
      }

      return false;
  }

  public boolean canJump(int[] nums) {
      return canJumpFromPosition(0, nums);
  }
}