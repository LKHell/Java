// Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

// Example:
// For num = 5 you should return [0,1,1,2,1,2].

// Follow up:

// It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
// Space complexity should be O(n).
// Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

class Solution {
  public int[] countBits(int num) {
      int [] ans = new int[num+1];
      
      for(int i=0; i<num+1; i++) {
         int a = 0;
        for(int j=i; j>0; ){
          a += j%2;
          j >>>=1;
        }
        ans[i]=a;
        //System.out.println("add"+a);
      }

      return ans;
  }
}


//sample 2 ms submission
class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
              ans[i] = ans[i >> 1] + 1;
            }
            else {
               ans[i] = ans[i >> 1];
          }
        }
        return ans;
    }
}


// fater
class Solution {
  public int[] countBits(int num) {
    int result[] = new int[num + 1];
    int offset = 1;
    for (int index = 1; index < num + 1; ++index){
        if (offset * 2 == index){
            offset *= 2;
        }
        result[index] = result[index - offset] + 1;
    }
    return result;
  }
}

//
// dp[0] = 0;

// dp[1] = dp[1-1] + 1;

// dp[2] = dp[2-2] + 1;

// dp[3] = dp[3-2] +1;

// dp[4] = dp[4-4] + 1;

// dp[5] = dp[5-4] + 1;

// dp[6] = dp[6-4] + 1;

// dp[7] = dp[7-4] + 1;

// dp[8] = dp[8-8] + 1;
// …