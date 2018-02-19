import com.sun.accessibility.internal.resources.accessibility_ko;

// Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].

// version 1 , O(n)
class Solution {
  public int[] searchRange(int[] nums, int target) {
    int i_left = 0 , i_right = nums.length-1;
    int[] ans = {-1,-1};
      while (i_left <= i_right) {
        if (nums[i_left] == target && nums[i_right] == target ) {
          ans[0] = i_left;
          ans[1] = i_right;
          break;
        }
        if (nums[i_left] != target) {
          i_left ++;
        }
        if (nums[i_right] != target) {
          i_right --;
        }
      }
    
      return ans;
  }
}


///


class Solution {
  public int[] searchRange(int[] nums, int target) {
    

    int lo = searchStart(nums, target);
    

    if (lo == nums.length || nums[lo] != target)
      return new int[]{-1, -1};

    int hi = searchStart(nums, target + 1) - 1;
    
    int[] result = new int[2];
    result[0] = lo;
    result[1] = hi;

    return result;
  }
  public int searchStart(int[] nums, int target) {
    int lo = 0, hi = nums.length, mid;
    while (lo < hi) {
      mid = lo + (hi - lo)/2;
      if (nums[mid] < target) {
        lo = mid + 1;
      }
      else {
        hi = mid;
      }
    }
    return lo;
  }
}


///
class Solution {
  public int[] searchRange(int[] nums, int target) {//二分法
      
      int[] result=new int[2];
      result[0]=firsttarget(nums,target);
      result[1]=lasttarget(nums,target);
      return result;
  }
  public int firsttarget(int[] nums,int target){
      int lo=0;
      int hi=nums.length-1;
      int idx=-1;
      //int mid=0;
      while(lo<=hi){
      int mid=(lo+hi)/2;
      
      if(target<=nums[mid]){
          hi=mid-1;
      }
      else{
          lo=mid+1;
      }
      if(nums[mid]==target){
          idx=mid;
          //return idx;
      }
      }
      
      return idx;
  }
  
   public int lasttarget(int[] nums,int target){
      int lo=0;
      int hi=nums.length-1;
      int idx=-1;
      //int mid=0;
      while(lo<=hi){
      int mid=(lo+hi)/2;
      if(target<nums[mid]){
          hi=mid-1;
      }
      else{
          lo=mid+1;
      }
      if(nums[mid]==target){
          idx=mid;
          //return idx;
      }
      }
     
      return idx;
  }
}