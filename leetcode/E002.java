import javax.management.ListenerNotFoundException;

/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode p=l1, q=l2, curr=prev;
        int carry = 0;
        while(p != null|| q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) p=p.next;
            if(q != null) q=q.next;
        }
        if (carry > 0) {
            curr.next=new ListNode(carry);
        }
        return prev.next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        
        ListNode cur1 = l1;
		ListNode cur2 = l2;
		
		ListNode result = new ListNode(0);
		ListNode cur = result;
		
		int carry = 0;
		
		while (null != cur1 || null != cur2 || 1 == carry) {
			int sum = (null == cur1? 0 : cur1.val) + (null == cur2? 0 : cur2.val) + carry;
			if (sum >= 10) {
				sum = sum - 10;
				carry = 1;
			} else {
				carry = 0;
			}
			cur.next = new ListNode(sum);
			cur = cur.next;
			cur1 = (null == cur1) ? null : cur1.next;
			cur2 = (null == cur2) ? null : cur2.next;
		}
		
		return result.next;
        
        
        
        
    }
}