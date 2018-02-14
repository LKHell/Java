// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

//    Given linked list: 1->2->3->4->5, and n = 2.

//    After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// Given n will always be valid.
// Try to do this in one pass.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    int length = 0;
    ListNode first =head;
    while(first != null) {
      length ++;
      first = first.next;
    }

    length -= n;
    first = dummy;
    for (int i = 0; i<length; i++) {
      first = first.next;
    }
      
    first.next =first.next.next;
    return dummy.next;
  }
}

//
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;
    ListNode second = dummy;

    for(int i = 0; i<n+1; i++) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next =second.next.next;
    return dummy.next;
  }
}

//
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
      if(head == null) return null;
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode cur = dummy;
      while(cur.next != null && n > 0) {
          cur = cur.next;
          n--;
      }
      ListNode tmp = dummy;
      while(cur.next != null) {
          tmp = tmp.next;
          cur = cur.next;
      }
      tmp.next = tmp.next.next;
      return dummy.next;
  }
}