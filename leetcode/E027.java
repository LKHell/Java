// Given an array and a value, remove all instances of that value in-place and return the new length.

// Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

// Example:

// Given nums = [3,2,2,3], val = 3,

// Your function should return length = 2, with the first two elements of nums being 2.

class Solution {
  public int removeElement(int[] nums, int val) {
    int length_i =0;
    for(int i = 0; i<nums.length; i++) {
      if (val != nums[i]){
          nums[length_i] = nums[i];
          length_i++;
        }
      }
    
    return length_i;
  }
}


//
class Solution {
public int removeElement(int[] nums, int val) {
  int i = 0;
  int n = nums.length;
  while (i < n) {
      if (nums[i] == val) {
          nums[i] = nums[n - 1];
          // reduce array size by one
          n--;
      } else {
          i++;
      }
  }
  return n;
}
}