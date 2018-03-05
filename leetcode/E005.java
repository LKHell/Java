// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

// Example:

// Input: "babad"

// Output: "bab"

// Note: "aba" is also a valid answer.
 

// Example:

// Input: "cbbd"

// Output: "bb"

class Solution {
  public String longestPalindrome(String s) {
    int start = 0 , end = 0;

    for(int i = 0; i < s.length(); i++) {
      int len_odd = expandAroundCenter(s,i,i);
      int len_even = expandAroundCenter(s, i, i+1);
      int len = Math.max(len_odd,len_even);
      if ( len > end - start) {
        start = i - (len - 1)/2;
        end = i + len/2;
      }
    }

    return s.substring(start, end+1);
  }

  private int expandAroundCenter(String s, int left, int right) {
    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left --;
      right ++;
    }
    return right - left -1;
  }

}

//
class Solution {
  char[] ss;
  int left=0, max=1;
  public String longestPalindrome(String s) {
      ss=s.toCharArray();
      if(ss.length<1) return "";
      for(int i=0; i<ss.length; i++){
          i=update(i);
      }
      return s.substring(left, left+max);
  }
  private int update(int index){
      int ll=index, rr=index;
      while(rr+1<ss.length && ss[rr]==ss[rr+1]){
          rr++;
      }
      int temp=rr;
      while(rr+1<ss.length && ll-1>=0 && ss[rr+1]==ss[ll-1]){
          rr++;
          ll--;
      }
      if(rr-ll+1>max){
          max=rr-ll+1;
          left=ll;
      }
      return temp;
  }
}
