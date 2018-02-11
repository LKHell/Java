// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

// Examples:

// s = "leetcode"
// return 0.

// s = "loveleetcode",
// return 2.

class Solution {
  public int firstUniqChar(String s) {
      if(s == null || s == "") return -1;
      int res = s.length();
      if(res == 1) return 0;
      for(char c = 'a'; c <= 'z'; c++){
          if(s.indexOf(c)!=-1 && s.indexOf(c)==s.lastIndexOf(c)){
              res = Math.min(res, s.indexOf(c));
          }
      }
      return res==s.length()?-1:res;
  }
}

//
class Solution {
  public int firstUniqChar(String s) {
    int [] i = new int[256];
    for (char c : s.toCharArray() ) {
      i [c] ++;
     
    }
    int index = 0;
    for (char c : s.toCharArray() ) {
      if (i[c ] == 1) {
        return index;
      }
      index ++ ;
    }
    return -1;
  }
}