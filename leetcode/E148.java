// Sort a linked list in O(n log n) time using constant space complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode sortList(ListNode head) {
    if(head == null || head.next == null) {
      return head;
    }
    ListNode prev = null, slow = head, fast = head;
    
    while(fast!= null && fast.next != null) {
      prev = slow;
      slow= slow.next;
      fast=fast.next.next;
    }
    
    prev.next = null; // cut the list

    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);

    return merge(l1,l2);


  }

  private ListNode merge(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0), p=l;

    while(l1 != null && l2 != null) {
      if(l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2=l2.next;
      }
      p = p.next;
    }
    if(l1 != null) {
      p.next = l1;
    }
    if(l2 != null) {
      p.next = l2;
    }
    return l.next;
  }
}

//
class Solution {
  private ListNode tail;
  public ListNode sortList(ListNode head) {
      if (head == null) return null;
      else if (head.next == null) {
          tail = head;
          return head;
      }
      ListNode biggerListHead = null;
      ListNode smallerListHead = null;
      ListNode equalListHead = head;
      ListNode node = head.next;
      head.next = null;
      while (node != null) {
          ListNode next = node.next;
          if (node.val == head.val) {
              node.next = equalListHead;
              equalListHead = node;
          } else if (node.val > head.val) {
              node.next = biggerListHead;
              biggerListHead = node;
          } else {
              node.next = smallerListHead;
              smallerListHead = node;                
          }
          node = next;
      }
      
      node = head;
      if (smallerListHead != null) {
          head = sortList(smallerListHead);
          tail.next = equalListHead;
      } else {
          head = equalListHead;
      }
      if (biggerListHead != null) {
          node.next = sortList(biggerListHead);
      } else {
          tail = node;
      }
      return head;
  }
}
