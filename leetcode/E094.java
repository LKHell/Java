// Given a binary tree, return the inorder traversal of its nodes' values.

// For example:
// Given binary tree [1,null,2,3],
//    1
//     \
//      2
//     /
//    3
// return [1,3,2].
//Recursive solution is trivial, could you do it iteratively?

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


 // Recursive
class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();

    helper(root,res);

    return res;
  }
  private void helper (TreeNode root, List<Integer> list){
    if(root != null) {
  
      helper(root.left, list);
      list.add(root.val);
      helper(root.right, list);
    
    }
  }
}

// Iterating method using Stack
class Solution {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack <TreeNode> stack = new Stack<>();
    TreeNode curr =root;
    while (curr!=null || !stack.isEmpty()) {
       while(curr!=null) { 
        stack.push(curr);
        curr=curr.left;
      }
      curr = stack.pop();
      res.add(curr.val);
      curr=curr.right;
    }
    return res;
  }
}

//Morris Traversal
class Solution {
  public List < Integer > inorderTraversal(TreeNode root) {
      List < Integer > res = new ArrayList < > ();
      TreeNode curr = root;
      TreeNode pre;
      while (curr != null) {
          if (curr.left == null) {
              res.add(curr.val);
              curr = curr.right; // move to next right node
          } else { // has a left subtree
              pre = curr.left;
              while (pre.right != null) { // find rightmost
                  pre = pre.right;
              }
              pre.right = curr; // put cur after the pre node
              TreeNode temp = curr; // store cur node
              curr = curr.left; // move cur to the top of the new tree
              temp.left = null; // original cur left be null, avoid infinite loops
          }
      }
      return res;
  }
}