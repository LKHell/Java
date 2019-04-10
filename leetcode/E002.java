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
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

// 69ms
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode p = l1, q = l2, curr = prev;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            if (sum > 9) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            
            curr.next = new ListNode(sum);
            curr = curr.next;
            if (p != null) { p = p.next; }
            if (q != null) { q = q.next; }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return prev.next;
    }
}

// 64ms
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1) { d.next = new ListNode(1); }
        return sentinel.next;
    }
}

// 48ms
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) { return null; }
        
        ListNode sum_head = null;
        ListNode sum_tail = null;
        
        int carry = 0;
        
        while (l1 != null && l2 != null) {
            int s = l1.val + l2.val + carry;
            carry = s / 10;
            int value = s % 10;
            
            if (sum_head == null) {
                sum_head = new ListNode(value);
                sum_tail = sum_head;
            } else {
                sum_tail.next = new ListNode(value);
                sum_tail = sum_tail.next;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        ListNode longest = null;
        if (l1 != null) {
            longest = l1;
        } else if (l2 != null) {
            longest = l2;
        }
        
        while (longest != null) {
            int s = longest.val + carry;
            carry = s / 10;
            int value = s % 10;
            
            if (sum_head == null) {
                sum_head = new ListNode(value);
                sum_tail = sum_head;
            } else {
                sum_tail.next = new ListNode(value);
                sum_tail = sum_tail.next;
            }
            
            longest = longest.next;
        }
        
        if (carry != 0) {
            sum_tail.next = new ListNode(carry);
            return sum_head;
        }
        
        return sum_head;
    }
}

