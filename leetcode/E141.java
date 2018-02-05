// Given a linked list, determine if it has a cycle in it.

// Follow up:
// Can you solve it without using extra space?

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// 2 pointers

public class Solution {
  public boolean hasCycle(ListNode head) {
      if (head == null) {
        return false;
      }
      ListNode walker = head;
      ListNode runner = head;
      while (runner.next.next != null && walker.next != null) {
        walker = walker.next;
        runner = runner.next.next;
        if (walker == runner) {
          return true;
        }
      }
      return false;
  }
}

// HashSet
public class Solution {
  public boolean hasCycle(ListNode head) {
    Set<ListNode> nodes_set = new HashSet<>();
    while (head != null) {
      if( nodes_set.contains(head)) {
        return true;
      } 
      else {
        nodes_set.add(head);
      }
      head = head.next;
    }
    return false;
  }
}