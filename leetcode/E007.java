
/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21

 
*/
class Solution {
  public int reverse(int x) {
    int ans_int=0, ans_new=0, remainder=0;
    while(x != 0)
    {
      remainder = x % 10;
      ans_new = ans_int * 10 +remainder;
      if ((ans_new-remainder)/10 != ans_int){ 
        return 0; // check overflow
      }
      ans_int = ans_new;
      x= x / 10;
    }
    return ans_int;
  }
}