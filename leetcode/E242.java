import java.util.Arrays;

// Given two strings s and t, write a function to determine if t is an anagram of s.

// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.

// Note:
// You may assume the string contains only lowercase alphabets.

// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?

//1 Sorting  8ms

class Solution {
  public boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) {
      return false;
    }
    char[] s_c = s.toCharArray();
    char[] t_c = t.toCharArray();
    Arrays.sort(s_c);
    Arrays.sort(t_c);
    return Arrays.equals(t_c,s_c);
  }
}

//2 Hash table 5ms
class Solution {
  public boolean isAnagram(String s, String t) {
    if(s.length() == 0 && t.length() == 0) {
      return true;
    }
    if(s.length() != t.length()) {
      return false;
    }
    int[] count = new int[26];

    for(int i=0; i<s.length(); i++){
      count[s.charAt(i)- 'a']++;
      count[t.charAt(i)- 'a']--;
    }

    for(int i : count) {
      if(i != 0) {
        return false;
      }
    }
    return true;
  }
}

// 3ms
class Solution {
  public boolean isAnagram(String s, String t) {
      if(s.length() == 0 && t.length() == 0) return true;
      if(s.length() != t.length()) return false;
      int[] map = new int[256];
      for(char c : s.toCharArray()){
          map[c]++;
      }
      for(char a : t.toCharArray()){
          if(map[a] <= 0) return false;
          map[a]--;
      }
      return true;
  }
}