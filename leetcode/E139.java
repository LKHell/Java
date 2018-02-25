// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".

// UPDATE (2017/1/4):
// The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
      boolean[] dp = new boolean[s.length()+1];
      Set<String> dictlist = new HashSet<>();
      dictlist.addAll(wordDict);
      dp[0] = true;

      for(int i=1; i<=s.length(); i++) {
        for(int j=0; j<i; j++) {
          if(dp[j] && dictlist.contains(s.substring(j, i))) {
            dp[i] = true;
            break;
          }
        }
      }
      return dp[s.length()];
  }
}

//
class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
      if (s == null) {
          return false;
      }
      int maxLength = 0;
      Set<String> set = new HashSet<>();
      for (String word : wordDict) {
          maxLength = Math.max(maxLength, word.length());
          set.add(word);
      }
      int n = s.length();
      boolean[] f = new boolean[n + 1];
      f[0] = true;
      for (int i = 1; i <= n; i ++) {
          for (int j = 1; j <= maxLength && j <= i; j ++) {
              if (f[i - j]) {
                  String sub = s.substring(i - j, i);
                  if (set.contains(sub)) {
                      f[i] = true;
                      break;
                  }
              }
          }
      }
      return f[n];
  }
}