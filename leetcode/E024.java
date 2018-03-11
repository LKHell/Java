// iven a linked list, swap every two adjacent nodes and return its head.

// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.

// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null&&current.next.next != null) {
     ListNode first = current.next;
     ListNode second = current.next.next;
     first.next = second.next;
     current.next = second;
     current.next.next = first; // second.next = first;
     current = current .next.next;
    }
    return dummy.next;
  }
}

//
class Solution {
  public ListNode swapPairs(ListNode head) {
      if (head == null || head.next == null) {
          return head;
      }
      ListNode nextNode  = head.next;
      head.next = swapPairs(nextNode.next);
      nextNode.next = head;
      return nextNode;
  }
}