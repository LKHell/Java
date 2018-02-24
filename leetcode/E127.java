import java.util.HashSet;
import java.util.List;

// Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

// Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// For example,

// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.

// Note:
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
// UPDATE (2017/1/20):
// The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if(!wordList.contains(endWord)){
      return 0;
    }
    Set<String> b_set = new HashSet<>(); // beginSet
    Set<String> e_set = new HashSet<>(); // endSet
    b_set.add(beginWord);
    e_set.add(endWord);

    Set<String> visted = new HashSet<>();
    Set<String> w_set  = new HashSet<>(); //wordSet

    for(String str : wordList){
      w_set.add(str);
    }

    int len = 1;
    while(!b_set.isEmpty() && !e_set.isEmpty()){
      if(b_set.size() > e_set.size()) {
        Set<String> set = b_set;
        b_set = e_set;
        e_set = set;
      }

      Set<String> temp = new HashSet<>();
      for (String str : b_set) {
        char [] chars = str.toCharArray();

        for(int i = 0; i<chars.length; i++) {
          for(char c = 'a' ; c<= 'z'; c++) {
            char old = chars[i];
            chars[i] =c;
            String target = String.valueOf(chars);

            if(e_set.contains(target)) {
              return len+1;
            }

            if(!visted.contains(target) && w_set.contains(target)) {
              temp.add(target);
              visted.add(target);
            }
            chars[i] = old;

          }
        }
      }
      b_set =temp;
      len++;
    }
    return 0;

  }
}

//

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      // edge case
      if (wordList == null || wordList.size() == 0) {
          return 0;
      }
      
      Set<String> setTotal = new HashSet<String>(wordList);
      if (!setTotal.contains(endWord)) {
          return 0;
      }
      
      setTotal.add(beginWord);
          
      Queue<String> qSmall = new ArrayDeque<String>();
      Queue<String> qLarge = new ArrayDeque<String>();
      Set<String> setVisit = new HashSet<String>();
      
      qSmall.add(beginWord);
      qLarge.add(endWord);
      setVisit.add(beginWord);
      setVisit.add(endWord);
      int len = 2;
      
      // BFS traversal
      while (!qSmall.isEmpty() && !qLarge.isEmpty()) {
          // follow narrow bredth path (smaller queue size path)
          if (qSmall.size() > qLarge.size()) {
              Queue<String> temp = qSmall;
              qSmall = qLarge;
              qLarge = temp;
          }
          
          
          Set<String> set = new HashSet<String>(qLarge);
          int size = qSmall.size();
          
          for (int i = 0; i < size; i++) {
              String curr = qSmall.poll();
              char[] arr = curr.toCharArray();
              
              for (int j = 0; j < arr.length; j++) {
                  char old = arr[j];
                  
                  for (char c = 'a'; c <= 'z'; c++) {
                      if (c == old) {
                          continue;
                      }
                      
                      arr[j] = c;
                      String next = String.valueOf(arr);
                      if (!setTotal.contains(next)) {
                          continue;
                      }
                      
                      
                      if (set.contains(next)) {
                          return len;
                      }
                      
                      if (setVisit.add(next)) {
                          qSmall.add(next);
                      }
                  }
                  
                  arr[j] = old;
              }
          }
          
          len++;
      }
      
      return 0;
  }
}