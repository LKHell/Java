package com.lkhao;

import com.lkhao.eo.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 *
 * * Definition for singly-linked list.
 * * public class ListNode {
 * *     int val;
 * *     ListNode next;
 * *     ListNode(int x) { val = x; }
 * * }
 */
public class E002AddTwoNumbers {

//    private static class ListNode {
//        int val;
//
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        ListNode[] p = new ListNode[2];

        p[0] = l1;
        p[1] = l2;

        int carry = 0;

        while (p[0] != null || p[1] != null) {
            int[] val = new int[2];
            val[0] = p[0] == null ? 0 : p[0].val;
            val[1] = p[1] == null ? 0 : p[1].val;
            int sum = carry + val[0] + val[1];
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (p[0] != null) {
                p[0] = p[0].next;
            }
            if (p[1] != null) {
                p[1] = p[1].next;
            }

        }
        if (carry == 1) {
            current.next = new ListNode(1);
        }
        return dummyHead.next;
    }

    @Test
    public void testSolution() {
        ListNode l1 = stringToListNode("[2,4,3]");

        ListNode l2 = stringToListNode("[5,6,4]");

        ListNode ret = new E002AddTwoNumbers().addTwoNumbers(l1, l2);

        String out = listNodeToString(ret);

        Assert.assertEquals(listNodeToString(ret), "[7, 0, 8]");
        System.out.println(out);
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += (node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

}
