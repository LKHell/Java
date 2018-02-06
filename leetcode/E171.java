// Given a column title as appear in an Excel sheet, return its corresponding column number.

// For example:

//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 

class Solution {
  public int titleToNumber(String s) {
    if (s == null) {
      return 0;
    }
    int sum = 0;
      for (char c : s.toUpperCase().toCharArray()) {
        sum = sum*26 + c - 64; // sum = sum*26 +c -'A'+1;

      }
    return sum;
  }
}

// 1 line
return s != "" ? 26*titleToNumber(s.substr(0,s.size()-1)) + s[s.size()-1] -'A'+1 : 0;