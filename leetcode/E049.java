import java.util.ArrayList;
import java.util.HashMap;

// Given an array of strings, group anagrams together.

// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:

// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note: All inputs will be in lower-case.


//sort
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
          return new ArrayList();
        }
        Map<String,List> ans = new HashMap<>();
        for (String s:strs) {
            char [] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}

//prime number
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int [] prime = { 2, 3, 5, 7, 11,
                        13, 17, 19, 23, 29,
                        31, 37, 41, 43, 47,
                        53, 59, 61, 67, 71, 
                        73, 79, 83, 89, 97, 
                        101};
        List<List<String>> res= new ArrayList<>();
        HashMap<Integer, Integer> map=new HashMap<>();
        for(String s:strs){
          int key =1;
          for(char c : s.toCharArray()){
            key *= prime[c - 'a'];
          }
          List<String> t;
          if(map.containsKey(key)) {
            t = res.get(map.get(key));
          }
          else {
            t = new ArrayList<>();
            res.add(t);
            map.put(key,res.size()-1);
          }
          t.add(s);
        }          
        return res;        
    }
}