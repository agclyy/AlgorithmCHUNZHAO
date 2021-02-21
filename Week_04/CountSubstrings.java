package com.agclyy.better.algorithm.week04;

public class CountSubstrings {


    public int countSubstrings(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    count++;
                    dp[j][i] = true;
                }
            }
        }
        return count;

    }

    public int countSubstrings2(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += extend(s, i, i, s.length());
            result += extend(s, i, i + 1, s.length());
        }
        return result;
    }

    private int extend(String s, int i, int j, int n) {
        int res = 0;
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            res++;
        }
        return res;
    }


    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        countSubstrings.countSubstrings("fdsklf");
    }

}
