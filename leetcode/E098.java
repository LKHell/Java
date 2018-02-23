import javax.swing.tree.TreeNode;

// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
// Example 1:
//     2
//    / \
//   1   3
// Binary tree [2,1,3], return true.
// Example 2:
//     1
//    / \
//   2   3
// Binary tree [1,2,3], return false.

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
  public boolean isValidBST(TreeNode root) {
      if(root == null) {
        return true;
      }
      Stack<TreeNode> stack = new Stack<>();
      TreeNode prev = null;
      while(root != null || !stack.isEmpty()) {
        while(root != null) {
          stack.push(root) ;
          root = root.left;
        }
        root = stack.pop();
        if(prev != null && root.val <= prev.val) {
          return false;
        }
        prev = root;
        root = root.right;
      }
      return true;
      
  }
}

//
class Solution {
  public boolean isValidBST(TreeNode root) {
    return until (root, Long.MAX_VALUE, Long.MIN_VALUE);
  }
  private boolean until (TreeNode root, Long up, long down){
    if(root == null) {
      return true;
    }
    if(!(root.val< up && root.val > down )){
      return false;
    }
    if(until(root.left, (long)root.val, down) && until (root.right, up , (long)root.val)) {
      return true;
    }
    return false;
  }
}