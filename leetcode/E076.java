// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".

// Note:
// If there is no such window in S that covers all characters in T, return the empty string "".

// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

class Solution {
  public String minWindow(String s, String t) {
    char[] s_array = s.toCharArray();
    char[] t_array = t.toCharArray();
    int[] map = new int[256];
    int end = 0;
    int start = 0;
    int min_length = Integer.MAX_VALUE;
    
    for ( int i = 0 ; i< t_array.length; i++) {
      map[t_array[i]]++;
    }
    int count = t_array.length;
    int min_start = 0;

    while(end<s_array.length) {
      
      if(map[s_array[end]] > 0) { // t has this character
        count --; 
      }

      map[s_array[end]]--;
      
      while(count == 0) { //window matches
        if((end - start +1) < min_length) {
          min_length = end - start +1;
          min_start = start;
        }
        
        map[s_array[start]] ++; // start go left
        
        if(map[s_array[start]]>0){ // remove a character which t has
          count ++;   
        //Cause for those Characters t doesn't have, map[thisCharacter] are at most 0
        }
        start++;
      }

      end ++;
    }
    if(min_start+min_length > s_array.length) {
      return "";
    }
    return s.substring(min_start,min_start+min_length);

  }
}