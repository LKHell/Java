/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// O(N) O(N)
class Solution {
    public ListNode root;
    public boolean isPalindrome(ListNode head) {
        root = head;
        return (head == null) ? true : _isPalindrome(head);
    
    }

    public boolean _isPalindrome(ListNode head) {
        boolean flag = true;
        if(head.next != null) {
            flag = _isPalindrome(head.next);
        }
        if(flag && root.val == head .val) {
            root = root.next;
            return true;
        }
        return false;
    }
}

// fast slow
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head , slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next_temp = head.next;
            head.next = prev;
            prev = head;
            head = next_temp;
        }
        return prev;
    }
}
