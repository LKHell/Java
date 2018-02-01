import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
//use HashMap
class Solution {
  public int lengthOfLongestSubstring(String s) {
      int n = s.length(), ans_int = 0;

      Map<Character,Integer> map = new HashMap<>();

      for ( int j=0,i=0; j<n; j++){
        if (map.containsKey(s.charAt(j))){
          i = Math.max(map.get(s.charAt(j)), i);
        }
        ans_int = Math.max(ans_int, j-i+1);
        map.put(s.charAt(j),j+1);
      }

      return ans_int;
  }
}

//ASCII 128
class Solution{
  public int lengthOfLongestSubstring(String s) {
    int n = s.length(), ans = 0;
    int [] index = new int [128]; // all set 0
    
    for (int j=0, i=0; j<n; j++) {
      i = Math.max(index[s.charAt(j)], i);
      ans = Math.max(ans, j-i+1);
      index[s.charAt(j)]=j+1;
    }
    return ans;
  }
}

