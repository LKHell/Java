// Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

class Solution {
  public boolean containsDuplicate(int[] nums) {
      Arrays.sort(nums);
      for(int i=0; i<nums.length-1; i++) {
        if (nums[i] == nums [i+1]) {
          return true;
        }
      }
      return false;
  }
}

// HashTable
class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> ans_set = new HashSet<>(nums.length);
    for (int x : nums ) {
      if (ans_set.contains(x)) {
        return true;
      }
      ans_set.add(x);
    }
    return false;
  }
}
