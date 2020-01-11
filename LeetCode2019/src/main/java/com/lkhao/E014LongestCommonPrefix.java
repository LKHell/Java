package com.lkhao;

import org.junit.Test;

//Write a function to find the longest common prefix string amongst an array of strings.

/**
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class E014LongestCommonPrefix {
    interface SolutionBase {
        String longestCommonPrefix(String[] strs);
    }

    class Solution implements SolutionBase {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) { return ""; }
            String prefix = strs[0];
            int len = strs.length;

            for (int i = 1; i < len; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if (prefix.isEmpty()) {
                        return "";
                    }
                }
            }
            return prefix;
        }

    }

    class SolutionNew implements SolutionBase {
        @Override
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            int firstLen = strs[0].length();
            int arrayLen = strs.length;
            for (int i = 0; i < firstLen; i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < arrayLen; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }

            return null;
        }
    }

    @Test
    public void x() {

        String[] x = {"xxdq", "xxcc", "x"};
        SolutionNew s = new SolutionNew();
        System.out.println(s.longestCommonPrefix(x));
        ;
    }
}

