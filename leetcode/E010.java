// Implement regular expression matching with support for '.' and '*'.

// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true

//Recursion 
class Solution {
  public boolean isMatch(String s, String p) {
    if(p.isEmpty()) {
      return s.isEmpty();
    }

    boolean first_match  = (!s.isEmpty() && 
                          (p.charAt(0) == s.charAt(0) || p.charAt(0)== '.'));
    
    if(p.length() >= 2 && p.charAt(1) == '*') {
      return (isMatch(s, p.substring(2))|| 
             (first_match && isMatch(s.substring(1), p)));
    }
    else{
      return first_match && isMatch(s.substring(1), p.substring(1));
    }
  }
}

//dp
class Solution {
  public boolean isMatch(String s, String p) {
       if (s == null || p == null) {
          return false;
      }

      char[] text = s.toCharArray();
      char[] pattern = p.toCharArray();

      boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

      T[0][0] = true;
      //Deals with patterns like a* or a*b* or a*b*c*
      for (int i = 1; i < T[0].length; i++) {
          if (pattern[i-1] == '*') {
              T[0][i] = T[0][i - 2];
          }
      }

      for (int i = 1; i < T.length; i++) {
          for (int j = 1; j < T[0].length; j++) {
              if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                  T[i][j] = T[i-1][j-1];
              } 
              else if (pattern[j - 1] == '*') {
                  T[i][j] = T[i][j - 2];  // assuming  empty 
                  if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                      T[i][j] = T[i][j] | T[i - 1][j];  // only 0|0 = 0
                  }
              } 
              else {
                  T[i][j] = false;
              }
          }
      }
      return T[text.length][pattern.length];  
  }
}

/*
1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*': 
   here are two sub conditions:
      1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  
                                            //in this case, a* only counts as empty
      2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                     dp[i][j] = dp[i-1][j]  //in this case, a* counts as multiple a 
                  or dp[i][j] = dp[i][j-1]  //in this case, a* counts as single a
                  or dp[i][j] = dp[i][j-2]  //in this case, a* counts as empty
*/