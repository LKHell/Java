import sun.invoke.empty.Empty;
import sun.security.util.Length;

//Write a function to find the longest common prefix string amongst an array of strings.

class Solution {
  public String longestCommonPrefix(String[] strs) {
      if (strs.length == 0) return "";
      String prefix_s = strs[0];
      for (int i = 1; i<strs.length; i++){
        while (strs[i].indexOf(prefix_s) !=0 ){
          prefix_s = prefix_s.substring(0, prefix_s.length()-1);
          if (prefix_s.isEmpty())return "";
        }
      }
      return prefix_s;
  }
}