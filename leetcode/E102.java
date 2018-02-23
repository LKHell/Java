

// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
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
  public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> list = new LinkedList<>();
      Queue <TreeNode> queue = new LinkedList<>();

      if(root == null) {
        return list;
      }

      queue.offer(root);
      while(!queue.isEmpty()){
        int levelNum = queue.size();
        List<Integer> sublist= new LinkedList<>();
        for(int i =0 ; i<levelNum; i++) {
          if(queue.peek().left != null) {
            queue.offer(queue.peek().left);
          }
          if(queue.peek().right != null) {
            queue.offer(queue.peek().right);
          }
          sublist.add(queue.poll().val);
        }
        list.add(sublist);
      }
      return list;
  }
}

//

class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    level_traverse (root, 0 ,ans);
    return ans;
  }
  private void level_traverse(TreeNode root, int depth, List<List<Integer>> list) {
    if(root == null){
      return;
    }
    if(depth == list.size()) {
      list.add(new ArrayList<Integer>());
    }
    list.get(depth).add(root.val);
    level_traverse(root.left, depth+1, list);
    level_traverse(root.right, depth+1, list);
  }
}