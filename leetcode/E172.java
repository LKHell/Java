// Given an integer n, return the number of trailing zeroes in n!.

// Note: Your solution should be in logarithmic time complexity.
class Solution {
  public int trailingZeroes(int n) {
      int count_zero = 0;
      while (n > 0) {
        count_zero += n/5;
        n /= 5;
      }
      return count_zero;
  }
}