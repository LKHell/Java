import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

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

//8ms
class Solution{
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]) , i};
            }else{
                map.put(target - nums[i],i);
            }
        }
        return new int[]{0, 0};
    }
}


// 6ms
public class Solution{  
    public int[] twoSum(int[] nums, int target) {
                if(nums == null)
                    return null;
                int[] nums2 = Arrays.copyOf(nums, nums.length);
                Arrays.sort(nums2);
                int a = 0, b = 0;
                int start = 0, end = nums2.length-1;
                //find two nums
                while(start<end){
                    int sum = nums2[start] + nums2[end];
                    if(sum < target)
                        start++;
                    else if(sum > target)
                        end--;
                    else{
                        a = nums2[start]; b = nums2[end];
                        break;
                    }
                }
                //find the index of two numbers
                int[] res = new int[2];
                for(int i = 0; i < nums.length; i++){
                    if(nums[i] == a){
                        res[0] = i;
                        break;
                    }
                }
                // if(a != b){
                //     for(int i = 0; i < nums.length; i++){
                //         if(nums[i] == b){
                //             res[1] = i;
                //             break;
                //         }
                //     }
                // } else{
                //     for(int i = 0; i < nums.length; i++){
                //         if(nums[i] == b && i != res[0]){
                //             res[1] = i;
                //             break;
                //         }
                //     }
                // }

                for(int i = nums.length-1; i>=0; i--) {
                    if(nums[i] == b) {
                        res[1] = i;
                        break;
                    }
                }
                
                return res;
            }
    }



class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] map = new int[20050];
        int size = 4;
        for (int i = 0; i < nums.length; i++) {
            map[nums[i] + size] = (i + 1);
            int diff = target - nums[i + 1] + size;
            if (diff < 0) continue;
            int d = map[diff];
            if (d > 0)
                return new int[]{d - 1, i + 1};
        }
        return null;
    }
}