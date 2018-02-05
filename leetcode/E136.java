import java.sql.ResultSet;

// Given an array of integers, every element appears twice except for one. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

//For anyone who didn¡¯t understood why this works here is an explanation. This XOR operation works because it¡¯s like XORing all the numbers by itself. So if the array is {2,1,4,5,2,4,1} then it will be like we are performing this operation

//((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5.
class Solution {
  public int singleNumber(int[] nums) {
      int result = 0;
      for (int i : nums) {
        result = result ^ i;
      }
      return result;
  }
}