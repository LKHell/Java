// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

// You may assume that the array is non-empty and the majority element always exist in the array.

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}

//Boyer-Moore Voting Algorihtm
class Solution {
    public int majorityElement(int [] nums) {
        int count = 0;
        Integer candidate = null;

        for ( int num : nums) {
            if (count == 0) {
                candidate = num ;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}