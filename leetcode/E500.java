import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.print.attribute.HashAttributeSet;

/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]

 
*/

class Solution {
  public String[] findWords(String[] words) {
    //initialize HashMap
    String [] keyboard_word = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
    Map<Character,Integer>map=new HashMap<>();
    
    for(int i=0;i<keyboard_word.length;i++)
    {
      for(char c : keyboard_word[i].toCharArray())
      {
        map.put(c,i);
      }
    }
    //check
    List<String> ans_list=new LinkedList<>();
    for (String w: words)
    {
      if (w.equals("")) continue;
      int index=map.get(w.toUpperCase().charAt(0));
      //get index of first character 
      for(char c:w.toUpperCase().toCharArray())
      {
        if(map.get(c)!= index)
        {
          index=-1;
          break;
        }
      }
      if (index != -1) ans_list.add(w);
    }
    
    return ans_list.toArray(new String[0]);
  }
}


