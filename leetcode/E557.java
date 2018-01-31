/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.


 
*/
class Solution {
  public String reverseWords(String s) {
    String ans_str="";
    String str_single="";
    for(char c : s.toCharArray())
    {
      if(c==32)
      {
        ans_str=ans_str+str_single+c; //put in String
        str_single="";
      }else{
        str_single=c+str_single;  //reverse word
      }
    }
    ans_str=ans_str+str_single; //add the last word
    return ans_str;
  }
}