import java.util.LinkedList;

// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.



// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


class Solution {
  public List<String> letterCombinations(String digits) {
      LinkedList<String> ans = new LinkedList<>();
      if(digits.isEmpty()) {
        return ans;
      }
      String [] mapping = new String [] {
              "0", 
        "1", "abc", "def", 
        "ghi", "jkl", "mno", 
        "pqrs", "tuv","wxyz"
      };

      ans.add("");
      for (int i = 0; i<digits.length(); i++) {
        int x = Character.getNumericValue(digits.charAt(i));
        while (ans.peek().length() == i) {
          String t = ans.remove();
          for (char c : mapping[x].toCharArray()) {
            ans.add(t+c);
          }
        }
      }
      return ans;
  }
}



//
class Solution {
  private static final String[] LETTERS = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

  public List<String> letterCombinations(String digits) {

      List<String> res = new LinkedList<>();
      
      if(digits.length() == 0) return res;

      letterCombinationsHelper(digits, res, "", 0);

      return res;
  }

  private void letterCombinationsHelper(String digits, List<String> res, String cur, int i) {
      if(i == digits.length()) {
          res.add(cur);
          return;
      }

      String str = LETTERS[digits.charAt(i) - '0'];

      for(char c: str.toCharArray()) {
          letterCombinationsHelper(digits, res, cur + c, i + 1);
      }
  }
}