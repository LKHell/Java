// Hint:
// A linked list can be reversed either iteratively or recursively. Could you implement both?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode curr = head;
      while (curr != null) {
        ListNode next_temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next_temp;
      }
      return prev;
  }
}

class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p = reverseList(head.next);
    head.next.next = head ;
    head.next = null ;
    return p;
  }
}