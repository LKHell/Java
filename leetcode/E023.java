import java.util.Comparator;
import java.util.PriorityQueue;

// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null || lists.length == 0) {
      return null;
    }

    PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        // if(o1.val <o2.val) return -1;
        // else if(o1.val == o2.val) return 0;
        // else return 1;

         return o1.val -o2.val;
      }
    });

    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;

    for(ListNode node : lists) {
      if(node != null) {
        queue.add(node);
      }
    }

    while(!queue.isEmpty()) {
      tail.next = queue.poll();
      tail = tail.next;

      if(tail.next != null) {
        queue.add(tail.next);
      }
    }
    return dummy.next;

  }
}

// Top-down approach O(nlgn). Divide and conquer.
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) return null;
      
      ListNode merged = mergeKLists(lists, 0, lists.length - 1);
      
      return merged;
  }
  private ListNode mergeKLists(ListNode[] lists, int start, int end) {
      if (start == end) return lists[start];
      
      int mid = start + (end - start) / 2; 
      ListNode left = mergeKLists(lists, start, mid);
      ListNode right = mergeKLists(lists, mid + 1, end);
      
      ListNode merged = merge2Lists(left, right);
      return merged;
  }
  // utility method to merge 2 sorted lists.
  private ListNode merge2Lists(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode prev = dummy;
      
      while (l1 != null && l2 != null) {
          if (l1.val < l2.val) {
              prev.next = l1;
              l1 = l1.next;
          } else {
              prev.next = l2;
              l2 = l2.next;
          }
          prev = prev.next;
      }
      
      if (l1 != null) prev.next = l1;
      if (l2 != null) prev.next = l2;
      
      return dummy.next;
  }
}