// Given a collection of distinct numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]



class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    backtrack(result, new ArrayList<>(), nums);
    return result;   
  }

  private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums) {
    if (temp.size() == nums.length) {
      list.add(new ArrayList<>(temp));
    }
    else {
      for (int i = 0; i<nums.length; i++){
        if (temp.contains(nums[i])) {
          continue;
        }
        temp.add(nums[i]);
        backtrack(list,temp,nums);
        temp.remove(temp.size()-1);
      }
    }
  }

}


///
class Solution {
  public List<List<Integer>> permute(int[] nums) {
    LinkedList<List<Integer>> res = new LinkedList<>();
    res.add(new ArrayList<Integer>());
    for (int n : nums) {
      int size = res.size();
      while(size>0){
        size --;
        List<Integer> r = res.pollFirst();
        for (int i = 0 ; i<=r.size(); i++) {
          List<Integer> t = new ArrayList<>(r);
          t.add(i,n);
          res.add(t);
        }
      }
    }
    return res;
  }
}



////
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        DFSHelper(result, nums, 0);
        return result;
    }
    
    private void DFSHelper(List<List<Integer>> result, int[] nums, int index){
        if(index == nums.length){
            List<Integer> path = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                path.add(nums[i]);
            }
            result.add(path);
            return;
        }
        for(int i = index; i < nums.length; i++){
            swap(nums, index, i);
            DFSHelper(result, nums, index + 1);
            swap(nums, index, i);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}