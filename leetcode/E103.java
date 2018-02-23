import javax.swing.tree.TreeNode;

// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
//   [15,7]
// ]

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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    zigzagLevel_traversal(root,0,ans);
    return ans;
  }

  private void zigzagLevel_traversal(TreeNode root, int depth, List<List<Integer>> list) {
    if(root == null) {
      return;
    }
    if(depth == list.size()) {
      list.add(new ArrayList<Integer>());
    }
    
    if(depth % 2 == 0) {
      list.get(depth).add(root.val);
    }
    else{
      list.get(depth).add(0,root.val);
    }
    zigzagLevel_traversal(root.left, depth+1, list);
    zigzagLevel_traversal(root.right, depth+1, list);
  
  }
}
