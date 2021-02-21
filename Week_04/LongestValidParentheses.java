package com.agclyy.better.algorithm.week04;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int max = 0;
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 > 0) {
                        dp[i] = dp[i - 2] + 2;
                    }
                } else if (dp[i - 1] > 0) {
                    int matchIndex = i - dp[i - 1] - 1;
                    if (matchIndex >= 0 && s.charAt(matchIndex) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (matchIndex > 0) {
                            dp[i] = dp[i - 1] + 2 + dp[matchIndex - 1];
                        }
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }


    public int longestValidParentheses2(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String cc = ")()((()))()))";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        longestValidParentheses.longestValidParentheses3(cc);
    }


}
