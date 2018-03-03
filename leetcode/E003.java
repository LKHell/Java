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

//ASCII 256
class Solution{
  public int lengthOfLongestSubstring(String s) {
    int n = s.length(), ans = 0;
    int [] index = new int [256]; // all set 0
    
    for (int j=0, i=0; j<n; j++) {
      i = Math.max(index[s.charAt(j)], i);
      ans = Math.max(ans, j-i+1);
      index[s.charAt(j)]=j+1;
    }
    return ans;
  }
}

class Solution {
  public int lengthOfLongestSubstring(String s) {
      char[] chars = s.toCharArray();
      if(2 > chars.length){
          return chars.length;
      }
      int max = 0;
      int split_at = 0;
      int cur_len = 1;
      for(int i=1;i<chars.length;i++){
          int j = split_at;
          for(;j<i;j++){
              if(chars[i] == chars[j]){
                  break;
              }
          }
          if(j < i){
              split_at = j+1;
              cur_len = i-j;
          }else{
              cur_len++;
          }
          if(cur_len > max) max = cur_len;
      }
      return max;
  }
}