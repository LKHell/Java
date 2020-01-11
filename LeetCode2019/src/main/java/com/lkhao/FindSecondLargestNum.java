package com.lkhao;

import org.junit.Test;

/**
 * describe:
 * EPAM
 *
 * @author 李坤澔
 *     date 2020-01-09 12:45-13:15
 */
public class FindSecondLargestNum {

    @Test
    public void xx() {
//        List<String> y=new ArrayList<>(new String[]{"Larry", "Moe", "Curly"});

        int[] x = {1, 2, 3, 5, 0};
        int a = findSecondLargestNnm(x);
        System.out.println(a);
    }

    public int findSecondLargestNnm(int[] nums) {
        if (nums.length < 2) {
            throw new IllegalArgumentException();
        }
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }

        int firstLargestNum = Integer.MIN_VALUE;
        int secondLargestNum = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > firstLargestNum) {
                secondLargestNum = firstLargestNum;
                firstLargestNum = num;

            } else if (num > secondLargestNum) {
                secondLargestNum = num;
            }
        }

//      Map<Integer,Integer>

        return secondLargestNum;
    }

}
