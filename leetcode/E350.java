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



//
class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      int i = 0;
      int j = 0;
      int k = 0;
      int[] ans = new int[Math.min(nums1.length, nums2.length)];
      while (i < nums1.length && j < nums2.length) {
          if (nums1[i] == nums2[j]) {
              ans[k] = nums1[i];
              i++;
              j++;
              k++;
          } else if (nums1[i] < nums2[j]) {
              while (i + 1 < nums1.length && nums1[i] == nums1[i + 1]) i++;
              i++;
          } else {
              while (j + 1 < nums2.length && nums2[j] == nums2[j + 1]) j++;
              j++;
          }
      }
      
      return Arrays.copyOf(ans, k);
  }
}

// [], [1,2,2,3] -> []
// [2,2], [1,2,2,3] -> [2,2]