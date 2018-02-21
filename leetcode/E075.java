import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;

// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Note:
// You are not suppose to use the library's sort function for this problem.

// click to show follow up.

// Follow up:
// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

// Could you come up with an one-pass algorithm using only constant space?

class Solution {
  public void sortColors(int[] nums) {
      if(nums == null || nums.length<2) {
        return;
      }
      int low=0;
      int high = nums.length -1;
      for(int i = low; i<=high;) {
        if(nums[i] == 0) {
          int temp = nums[i];
          nums[i] = nums[low];
          nums[low] = temp;
          i++;
          low++;
        }
        else if(nums[i] == 2){
          int temp = nums[i];
          nums[i]= nums[high];
          nums[high] = temp;
          high --;
        }
        else {
          i++;
        }
      }
  }
}

//

public class Solution {
    public void s(int i,int k, int[] c) {
        int temp = c[i];
        c[i] = c[k];
        c[k] = temp;
    }
    
    public void sortColors(int[] nums) {
        int r,b,j,red,blue;
        
        blue=2;
        red=r=j= 0;
        b = nums.length - 1;
        
        
        while (b>=j) {
            if (nums[j] == red) {s(j, r,nums);r=r+1;j++;} 
            else if (nums[j] == blue) {s(j,b,nums);b=b-1;} 
            else {j++;}
        }
    }
     
    
}