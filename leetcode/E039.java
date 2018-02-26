import java.awt.List;
import java.util.ArrayList;

// Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// The same repeated number may be chosen from C unlimited number of times.

// Note:
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// For example, given candidate set [2, 3, 6, 7] and target 7, 
// A solution set is: 
// [
//   [7],
//   [2, 2, 3]
// ]

//24ms
class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(res, new ArrayList<>(), candidates, target, 0);
    return res;
  }
  private void backtrack(List<List<Integer>> list ,
                        List<Integer> templist, 
                        int[] nums, 
                        int remain, 
                        int start)  {
    if(remain < 0) {
      return;
    } else if (remain == 0) {
      list.add(new ArrayList<>(templist));
    } else {
      for(int i = start; i<nums.length; i++) {
        templist.add(nums[i]);
        backtrack(list, templist, nums, remain-nums[i], i);
        templist.remove(templist.size() - 1);
      }
    }
  }
}

//
class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      Arrays.sort(candidates);
      final List<List<Integer>> ans = new ArrayList<>();
      search(candidates, 0, target, new Integer[target], 0, ans);
      return ans;
  }
  
  private void search(int[] candidates, int st,
                      int target,
                      Integer[] paper, int len,
                      List<List<Integer>> ans) {
      if (target == 0) {
          final Integer[] temp = new Integer[len];
          System.arraycopy(paper, 0, temp, 0, len);
          ans.add(Arrays.asList(temp));
          return;
      }

      for(int i=st; i<candidates.length; i++) {
          if (i>st && candidates[i] == candidates[i-1]) continue;
          if (target < candidates[i]) break;
          paper[len] = candidates[i];
          search(candidates, i, target-candidates[i], paper, len+1, ans);
      }
  }
}