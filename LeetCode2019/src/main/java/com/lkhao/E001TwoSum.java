package com.lkhao;

import org.junit.Assert;
import org.junit.Test;

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

public class E001TwoSum {

    private int[] twoSum(int[] nums, int target) {
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

    private int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[] {map.get(num), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        int max = 2047;
        int[] store = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i] & max;
            if (store[diff] != 0) {
                return new int[] {store[diff] - 1, i};
            }
            store[nums[i] & max] = i + 1;
        }
        throw new RuntimeException("no number found");
    }

    @Test
    public void testSolution() {

        int[] result = twoSum(new int[] {1, 2}, 3);
        Assert.assertArrayEquals(result, new int[] {0, 1});

        int[] result1 = twoSum1(new int[] {2, 7, 11, 15}, 9);
        Assert.assertArrayEquals(result1, new int[] {0, 1});
    }

}
