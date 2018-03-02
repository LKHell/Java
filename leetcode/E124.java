// Given a binary tree, find the maximum path sum.

// For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

// For example:
// Given the below binary tree,

//        1
//       / \
//      2   3
// Return 6.

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
  int maxSum;
public int maxPathSum(TreeNode root) {
   maxSum = Integer.MIN_VALUE;
   helper(root);
  return maxSum;
}
private int helper(TreeNode root) {
  if(root == null){
    return 0;
  }
  int leftMax = Math.max(0, helper(root.left));
  int rightMax = Math.max(0, helper(root.right));
  maxSum = Math.max(maxSum, leftMax+rightMax+root.val);
  return Math.max(leftMax, rightMax) + root.val;
}
}