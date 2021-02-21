package com.agclyy.better.algorithm.week04;

import java.util.Arrays;

public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {

        int[] buckets = new int[26];

        for (char c : tasks) {
            buckets[c - 'A']++;
        }
        Arrays.sort(buckets);
        int maxTimes = buckets[25];
        int maxCount = 0;
        for (int num : buckets) {
            if (num == buckets[25]) {
                maxCount++;
            }
        }
        return Math.max((maxTimes - 1) * (n+1) + maxCount, tasks.length);
    }

}
