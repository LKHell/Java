import java.util.ArrayList;

import javax.security.auth.callback.NameCallback;

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]

class Solution {
  public List<String> generateParenthesis(int n) {
      List<String> list = new ArrayList<>();
      if (n < 1){
        return null;
      }
      backtrack(list, "", 0, 0, n);
      return list;
  }
  public void backtrack(List<String> list, String str, int open, int close, int max) {
    if(str.length() == max*2) {
      list.add(str);
      return;
    }
    if (open < max ) {
      backtrack(list, str + "(", open +1, close, max);
    }
    if (close < open) {
      backtrack(list, str + ")", open, close +1, max);
    }
  }
}

////
class Solution {
  public List<String> generateParenthesis(int n) {
      List<String> rst = new ArrayList<String>();
      if (n < 1) {
          return rst;
      }
      char[] cur = new char[2 * n];
      helper(n, n, cur, 0, rst);
      return rst;
  }
  private void helper(int left, int right, char[] cur, int index, List<String> rst) {
      if (left + right == 0) {
          rst.add(new String(cur));
          return;
      }
      if (left > 0) {
          cur[index] = '(';
          helper(left - 1, right, cur, index + 1, rst);
      }
      if (right > left) {
          cur[index] = ')';
          helper(left, right - 1, cur, index + 1, rst);
      }
  }
}