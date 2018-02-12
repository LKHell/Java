import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
      Map<Integer,Integer> map = new HashMap<>();
      ArrayList<Integer> result_list = new ArrayList<>();

      for (int i=0; i<nums1.length; i++) {
        if(map.containsKey(nums1[i])) {
          map.put(nums1[i], map.get(nums1[i])+1);
        }
        else {
          map.put(nums1[i], 1);
        }
      }
      for(int i = 0; i<nums2.length; i++) {
        if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
          result_list.add(nums2[i]);
          map.put(nums2[i], map.get(nums2[i])-1);
        }
      }

      int [] ans = new int[result_list.size()];
      for(int i = 0; i<ans.length; i++) {
        ans[i] = result_list.get(i);
      }
      return ans;
  }
}