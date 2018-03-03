//Reverse bits of a given 32 bits unsigned integer.

// For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

// Follow up:
// If this function is called many times, how would you optimize it?

// Related problem: Reverse Integer

public class Solution {
  // you need treat n as an unsigned value
  public int reverseBits(int n) {
      int ans = 0 ;
      for (int i = 0; i < 32; i++) {
        ans += n & 1;
        n >>>= 1;
        if (i < 31) {
          ans <<= 1;
        }
      }
      return ans;
  }
}

// optimize

//  Take 12345678 as an example.
//  First step, interchange 1234 with 5678 -> 56781234
//  Second step, interchange 56~~12~~ with ~~78~~34-> 78563412
//  Last step, interchange 7~5~3~1~ with ~8~6~4~2 ->87654321
public class Solution {
  public int reverseBits(int n) {
    int ret=n;                                                // 12345678
    ret = ret >>> 16 | ret<<16;                               // 5678 1234
    ret = (ret & 0xff00ff00) >>> 8 | (ret & 0x00ff00ff) << 8; // 7856 3412
    ret = (ret & 0xf0f0f0f0) >>> 4 | (ret & 0x0f0f0f0f) << 4; // 
    ret = (ret & 0xcccccccc) >>> 2 | (ret & 0x33333333) << 2;
    ret = (ret & 0xaaaaaaaa) >>> 1 | (ret & 0x55555555) << 1;
    return ret;
  }
}

//  12345678
// = 0000 0000 1011 1100 0110 0001 0100 1110 

//  1632501948
// =0)110 0001 0100 1110 0000 0000 1011 1100

//  1315027968
// 0)100 1110 0110 0001 1011 1100 0000 0000

// -468268288
// 1110 0100 0001 0110 1100 1011 0000 0000

// -1320600064
// 1011 0001 0100 1001 0011 1110 0000 0000

// 1921400064
// 0)111 0010 1000 0110 0011 1101 0000 0000