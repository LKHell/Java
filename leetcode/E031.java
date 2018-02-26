import sun.security.util.Length;

// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

// The replacement must be in-place, do not allocate extra memory.

// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1
//20ms
class Solution {
  public void nextPermutation(int[] nums) {
    int i = nums.length-2;
    while(i>=0 && nums[i+1] <= nums[i]) {
      i--;
    }
    if(i>=0){
      int j = nums.length -1; //int j = i+1
      while(j>= 0 && nums[j] <= nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i+1);
  }
  private void reverse(int[] nums, int start) {
    int i = start;
    int j= nums.length-1;
    while(i<j) {
      swap(nums, i, j);
      i++;
      j--;
      // swap(nums, i++, j--);
    }
  }
  private void swap(int [] nums, int i , int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}

//19ms
public class Solution {
  public void nextPermutation(int[] nums) {
      //check nums null or empty
      if(nums==null || nums.length< 2) return;
      // find the first decreasing num from right to left
      int i = nums.length-2;
      for(; i>=0; i--){
          if(nums[i]<nums[i+1]){
              break;
          }
      }
      if(i<0) {
          reverse(nums, 0);
          return;
      }
      // 
      int j = i+1;
      int minDiff = Integer.MAX_VALUE, id = i;
      for(; j<nums.length; j++){
          if(nums[j]>nums[i] && nums[j]-nums[i]<=minDiff){
              minDiff = nums[j]-nums[i];
              id = j;
          }
      }
      //swap nums[i] and the element with min difference
      swap(nums, i, id);
      reverse(nums, i+1);
  }
  
  private void swap(int[] nums, int i, int j){
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
  }
  
  private void reverse(int[] nums, int start){
      int left = start, right = nums.length-1;
      while(left<right){
          swap(nums, left, right);
          left++;
          right--;
      }
  }
  
}