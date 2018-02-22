import java.awt.List;
import java.util.ArrayList;

import com.sun.java.swing.action.BackAction;

// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// For example,
// If nums = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]


class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    //Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
  }
  private void backtrack(List<List<Integer>> list, List<Integer> temp_list, int[] nums , int start ) {
    list.add(new ArrayList<>(temp_list));
    for(int i = start; i<nums.length; i++) {
      temp_list.add(nums[i]);
      backtrack(list,temp_list,nums,i+1);
      temp_list.remove(temp_list.size()-1);
    }
  }
}


//
public class Solution {
  // public List<List<Integer>> subsets(int[] nums) {
  //     List<List<Integer>> res = new ArrayList<List<Integer>>();
  //     res.add(new ArrayList<Integer>());
  //     for (int num:nums){
  //         int size = res.size();
  //         for (int i = 0; i < size; i++){
  //             List<Integer> temp = new ArrayList<Integer>(res.get(i));
  //             temp.add(num);
  //             res.add(temp);
  //         }
  //     }
  //     return res;
  // }
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) return res;
    res.add(new ArrayList<>());
    int len  =  nums.length;
    for (int i = 0; i < len; i++){
      int size  =  res.size();
      for (int j = 0; j < size; j++){
        ArrayList<Integer>  temp  = new ArrayList<Integer>(res.get(j));
        temp.add(nums[i]);
        res.add(temp);
      }
    }
    return res;
  }
}