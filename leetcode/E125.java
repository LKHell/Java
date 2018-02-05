// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.

// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.

// For the purpose of this problem, we define empty string as valid palindrome.

class Solution {
  public boolean isPalindrome(String s) {
    if (s == null) {
      return true;
    }
    int head_i = 0, tail_i = s.length()-1;
    char head_c,tail_c;
    while (head_i<tail_i) {
      head_c = s.charAt(head_i);
      tail_c = s.charAt(tail_i);
      
      if (!Character.isLetterOrDigit(head_c)) {
        head_i++;
      } 
      else if (!Character.isLetterOrDigit(tail_c)) {
        tail_i--;
      }
      else {
        if (Character.toLowerCase(head_c) != Character.toLowerCase(tail_c)) {
          return false;
        }
        head_i ++ ;
        tail_i -- ;
      }
    }
    return true;
  }
}

//
class Solution {
  public boolean isPalindrome(String s) {
    String actual = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
    String rev = new StringBuffer(actual).reverse().toString();
    return actual.equals(rev);
  }
}