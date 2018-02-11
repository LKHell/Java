import java.lang.reflect.Array;
import java.util.Arrays;

// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

// Example 1

// Input: [3,0,1]
// Output: 2
// Example 2

// Input: [9,6,4,2,3,5,7,0,1]
// Output: 8

// Note:
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?

//Sorting
class Solution {
  public int missingNumber(int[] nums) {
    Arrays.sort(nums);
     
    if(nums[nums.length-1] != nums.length) {
        return nums.length;
    }
    else if(nums[0] != 0) {
      return 0;
    }
    
    for(int i = 1; i < nums.length; i++) {
      int ex_num = nums[i-1]+1;
      if(nums[i] != ex_num) {
        return ex_num;
      }
    }

    return -1;
  }
}

//HashSet 
class Solution {
  public int missingNumber(int[] nums) {
    Set <Integer> numset = new HashSet<>();
    for (int num : nums) {
      numset.add(num);
    }

    int expected_count = nums.length + 1;
    for (int number = 0; number < expected_count; number++ ) {
      if (!numset.contains(number)){
        return number;
      }
    }

    return -1;
  }
}

//Bit Manipulation
class Solution {
  public int missingNumber(int[] nums) {
    int missing = nums.length;
    for(int i = 0; i < nums.length; i++) {
      missing ^= i ^ nums[i];
    }
    return missing;
  }
}

// Gauss' Formula
class Solution {
  public int missingNumber(int[] nums) {
    int ex_sum = nums.length * (nums.length+1)/2;
    int actual_sum = 0;
    for (int num : nums) {
      actual_sum += num;
    }
    return ex_sum - actual_sum;
  }
}

//
class Solution {
  public int missingNumber(int[] nums) {
      int total = 0;
      for(int i = 1; i <= nums.length ;i++ ){
          total += i;
      }
      for(int n : nums){
          total -= n;
      }
      return total;
  }
}