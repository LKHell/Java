package lkhao.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * describe:
 * <p>
 * date 2019-04-10
 */

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if (nums[i]+nums[j] == target)
//                 return new int[]{i,j};
//             }
//         }
//          throw new IllegalArgumentException("No two sum solution");
//     }
// }

public class E001 {
    private class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (null == nums || nums.length < 2) {
                throw new IllegalArgumentException("No two Sum solution");
            }
            
            int len = nums.length;
            //注意HashMap 大小
            Map<Integer, Integer> resultMap = new HashMap<>(len);
            
            for (int i = 0; i < len; i++) {
                if (resultMap.containsKey(nums[i])) {
                    return new int[] {resultMap.get(nums[i]), i};
                }
                resultMap.put(target - nums[i], i);
            }
            
            return new int[] {-1, -1};
        }
    }
    
    private class Solution2 {
        
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int num = target - nums[i];
                if (map.containsKey(num)) {
                    return new int[] {map.get(num), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }
}
