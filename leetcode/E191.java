// Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

// For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

public class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
      int bits = 0;
      int mask = 1;
      for (int i = 0 ; i<32; i++) {
        if ((n & mask)!=0) { // only 1 & 1 =1;
          bits++;
        }
        mask <<= 1; // or  n >>>= 1;
       
      }
      
      return bits;
  }
}
//
public class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
        sum++;
        n &= (n - 1);
    }
    return sum;
  }
}