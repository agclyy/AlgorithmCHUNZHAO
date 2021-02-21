package com.agclyy.better.algorithm.week04;

public class NumDecoding {

    public int numDecodings(String s) {
        final int length = s.length();
        if (length == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                } else {
                    dp[i + 1] = dp[i];
                }
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        NumDecoding numDecoding = new NumDecoding();
        numDecoding.numDecodings("1010");

    }

    public int numDecodings2(String s) {
        final int length = s.length();
        if (length == 0) return 0;
        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[length + 1];
        dp[0] = 1;

        for (int i = 0; i < length; i++) {
            dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                dp[i + 1] += dp[i - 1];
            }
        }

        return dp[length];
    }
}
