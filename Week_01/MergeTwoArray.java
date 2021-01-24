package com.agclyy.better.algorithm.week01.homework;

import java.util.Arrays;

public class MergeTwoArray {

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0) {
            int max = nums1[m - 1] >= nums2[n - 1] ? nums1[--m] : nums2[--n];
            nums1[m + n] = max;
        }
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
    }


}
