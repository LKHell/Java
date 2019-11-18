package com.lkhao;

import javax.swing.tree.TreeNode;
import java.util.HashSet;

/**
 * describe:
 * <p>
 * date 2019-04-10
 */

/*
Given a Binary Search Tree and a target number,
return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True


Example 2:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
*/
public class E653 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            HashSet<Integer> set = new HashSet<>();
            
            return dfs(root, set, k);
        }
    }
    
    boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if (null == root) {
            return false;
            
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
    
    class TreeNode {
        int val;
        
        TreeNode left;
        
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
    
}
