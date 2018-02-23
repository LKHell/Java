import com.sun.org.apache.bcel.internal.classfile.InnerClass;

// Given preorder and inorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

// For example, given

// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
// Return the following binary tree:

//     3
//    / \
//   9  20
//     /  \
//    15   7

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
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree_helper(0, 0, inorder.length-1, preorder, inorder);
  }
  
  private TreeNode buildTree_helper(int pre_start, int in_start, int in_end, int []preorder, int [] inorder) {
    if(pre_start > preorder.length -1 || in_start >in_end){
      return null;
    }
    TreeNode root = new TreeNode(preorder[pre_start]);
    int in_index = 0;
    for(int i = in_start; i<=in_end; i++) {
      if(inorder[i] == root.val) {
        in_index = i;
      }
    }
    root.left = buildTree_helper(pre_start+1, in_start, in_index-1, preorder, inorder);
    root.right = buildTree_helper(pre_start + in_index - in_start +1, in_index+1, in_end, preorder, inorder) ;
    return root;
  }
}


//
class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
      int[] preIndex = new int[] {0};
      int[] inIndex = new int[] {0};
      return buildTree(preorder, inorder, preIndex, inIndex, Integer.MAX_VALUE);
  }
  
  private TreeNode buildTree(int[] preorder, int[] inorder, int[] preIndex, int[] inIndex, int target) {
      //pre: [root][left][right];
      //in: [left][root][right];
      //target is the root
      if (inIndex[0] >= inorder.length || inorder[inIndex[0]] == target) {
          return null;
      }
      TreeNode root = new TreeNode(preorder[preIndex[0]]);
      //preorder, advance the index by 1 sice we already finish the root;
      preIndex[0]++;
      root.left = buildTree(preorder, inorder, preIndex, inIndex, root.val);
      //after finishing left subtree, we can advance the index by 1
      inIndex[0]++;
      root.right = buildTree(preorder, inorder, preIndex, inIndex, target);
      return root;
  }
}

