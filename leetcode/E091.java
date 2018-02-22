// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.

class Solution {
  public int numDecodings(String s) {
      if(s==null || s.length() == 0){
        return 0;
      }

      int [] ans = new int [s.length()+1];
      ans[0] =1;
      ans[1]= s.charAt(0) != '0' ? 1 : 0;

      for(int i = 2; i<= s.length(); i++) {
        
        int first = Integer.valueOf(s.substring(i-1,i));
        int second = Integer.valueOf(s.substring(i-2,i));
        
        if(first >= 1 && first<= 9) {
          ans [i] += ans[i-1]; 
        }
        if(second >=10 && second <=26) {
          ans [i] += ans[i-2];
        }
      }
      return ans[s.length()];
  }
}


//
class Solution {
  public int numDecodings(String s) {
      if (s == null || s.length() == 0)
          return 0;
      int n = s.length();
      int[] dp = new int[n+1];
      dp[0] = 1;
      for (int i = 1; i <= n; i++) {
          if (s.charAt(i-1) >= '1' && s.charAt(i-1) <= '9')
              dp[i] = dp[i-1];
          if (i > 1) {
              if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) <= '6') {
                  dp[i] += dp[i-2];
              }
          }
          System.out.println(ans[i]);
      }
      return dp[n];
  }
}

//
public class Solution {  
  public int numDecodings(String s) {  
      if (s == null || s.length() == 0) return 0;  
      char[] sa = s.toCharArray();  
      int[] nums = new int[sa.length+1];  
      nums[0] = 1;  
      for(int i=1; i<=sa.length; i++) {  
          if (sa[i-1] != '0') nums[i] += nums[i-1];  
          if (i>1 && sa[i-2] == '1') nums[i] += nums[i-2];  
          if (i>1 && sa[i-2] == '2' && sa[i-1] >= '0' && sa[i-1] <= '6') nums[i] += nums[i-2];  
      }  
      return nums[sa.length];  
  }  
}  