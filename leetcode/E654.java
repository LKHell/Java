import javax.swing.tree.TreeNode;

import javafx.animation.RotateTransition;

// iven an integer array with no duplicates. A maximum tree building on this array is defined as follow:

// The root is the maximum number in the array.
// The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
// The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
// Construct the maximum tree by the given array and output the root node of this tree.

// Example 1:
// Input: [3,2,1,6,0,5]
// Output: return the tree root node representing the following tree:

//       6
//     /   \
//    3     5
//     \    / 
//      2  0   
//        \
//         1
// Note:
// The size of the given array will be in the range [1,1000]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    if(nums == null) {return null;}
    return helper(nums, 0, nums.length-1);   
  }
  private TreeNode helper(int[] nums, int start, int end) {
    if(start > end) {return null;}

    int idxMax = start;

    for(int i = start+1; i<=end; i++) {
      if(nums[i] > nums[idxMax]) {
        idxMax = i;
      }
    }
    TreeNode root = new TreeNode (nums[idxMax]);

    root.left = helper(nums, start, idxMax -1);
    root.right = helper(nums, idxMax+1, end);
    return root;
  }
}

//
class Solution {
  private TreeNode helper(int[] nums, int low, int high) {
      // System.out.println("low:" + low + " high:" + high);
      if(low == high) return new TreeNode(nums[low]);
      int max = Integer.MIN_VALUE;
      int index = -1;
      for(int i = low; i <= high; i++) {
          if(nums[i] > max) {
              max = nums[i];
              index = i;
          }
      }
      // System.out.println("find max:" + max + " index:" + index);
      TreeNode root = new TreeNode(max);
      root.left = index > low ? helper(nums, low, index - 1) : null;
      // System.out.println("here");
      root.right = index < high ? helper(nums, index + 1, high) : null;
      return root;        
  }
  
  public TreeNode constructMaximumBinaryTree(int[] nums) {
      if(nums == null || nums.length == 0) return null;
      return helper(nums, 0, nums.length - 1);
  }
}