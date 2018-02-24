import java.util.ArrayList;
import java.util.List;

// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// For example, given s = "aab",
// Return

// [
//   ["aa","b"],
//   ["a","a","b"]
// ]

class Solution {
  public List<List<String>> partition(String s) {
     int len =s.length();
     List<List<String>> ans = new ArrayList<>();
     boolean[][] dp = new boolean[s.length()][s.length()];
     for (int i=0; i<s.length(); i++) {
       for(int j=0; j<=i; j++) {
         if(s.charAt(i) == s.charAt(j) && (i-j <= 2 || dp[j+1][i-1])) {
           dp[j][i] =true;
         }
       }
     }
     helper(ans,new ArrayList<>(), dp, s, 0);
     return ans;
  }
  private void helper(List<List<String>>res, List<String>path, boolean [][]dp, String s, int pos) {
    if(pos == s.length()) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int i =0; i<s.length(); i++) {
      if(dp[pos][i]) {
        path.add(s.substring(pos, i+1));
        helper(res, path, dp, s, i+1);
        path.remove(path.size()-1);
      }
    }
  }
}


//
class Solution {
  public List<List<String>> partition(String s) {
      List<List<String>> result = new ArrayList<List<String>>();
      List<String> curList = new ArrayList<String>();
      doPart(s,result,curList,0);
      return result;
  }
  
  public void doPart(String src, List<List<String>> result, List<String> curList, int pos){
      int len = src.length();
      if(pos >= len) result.add(new ArrayList<String>(curList));
      for(int i = pos;  i < len; i++){
          if(isPal(src,pos,i)){
              curList.add(src.substring(pos,i+1));
              doPart(src,result,curList,i+1);
              curList.remove(curList.size()-1);
          }
      }
  }
  
  
  public boolean isPal(String src, int l,int r){
      if(l == r) return true;
      while(l < r){
          if(src.charAt(l)!=src.charAt(r)) return false;
          l++;
          r--;
      }
      return true;
  }
}

// "aab"
/*
pos = 0
before:[a]; i=0
pos = 1
before:[a, a]; i=1
pos = 2
before:[a, a, b]; i=2
pos = 3
add list

dopart after:[a, a, b]
after:[a, a]; i = 2

dopart after:[a, a]
after:[a]; i = 1

dopart after:[a]
after:[]; i = 0

before:[aa]; i=1
pos = 2
before:[aa, b]; i=2
pos = 3
add list

dopart after:[aa, b]
after:[aa]; i = 2
dopart after:[aa]
after:[]; i = 1
---------------------------------------------

"aaba"

pos = 0
before:[a]; i=0
pos = 1
before:[a, a]; i=1
pos = 2
before:[a, a, b]; i=2
pos = 3
before:[a, a, b, a]; i=3
pos = 4
add list

dopart after:[a, a, b, a]
after:[a, a, b]; i = 3
dopart after:[a, a, b]
after:[a, a]; i = 2
dopart after:[a, a]
after:[a]; i = 1
before:[a, aba]; i=3
pos = 4
add list

dopart after:[a, aba]
after:[a]; i = 3
dopart after:[a]
after:[]; i = 0
before:[aa]; i=1
pos = 2
before:[aa, b]; i=2
pos = 3
before:[aa, b, a]; i=3
pos = 4
add list

dopart after:[aa, b, a]
after:[aa, b]; i = 3
dopart after:[aa, b]
after:[aa]; i = 2
dopart after:[aa]
after:[]; i = 1

answer:
[["a","a","b","a"],["a","aba"],["aa","b","a"]]

*/


