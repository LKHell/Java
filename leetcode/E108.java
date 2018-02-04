import java.util.Enumeration;

import javax.swing.tree.TreeNode;

// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.


// Example:

// Given the sorted array: [-10,-3,0,5,9],

// One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

//       0
//      / \
//    -3   9
//    /   /
//  -10  5

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
  public TreeNode sortedArrayToBST(int[] nums) {
      if( nums.length == 0 || nums == null) {
        return null;
      }
      TreeNode head =  BST_F(nums, 0, nums.length-1);
      return head;
  }
  public TreeNode BST_F(int [] num, int low, int high){
    if (low > high) {
      return null;
    }
    int mid = low + (high-low)/2;
    TreeNode node = new TreeNode(num[mid]);
    node.left = BST_F(num, low, mid-1);
    node.right = BST_F(num, mid+1, high);
    return node;
  }
}