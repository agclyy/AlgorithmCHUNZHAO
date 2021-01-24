package com.agclyy.better.algorithm.week01.homework;

/**
 * LeetCode 189. Rotate Array
 */
public class RotateArray {


    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0) {
            return;
        }
        int[] newNums = nums.clone();
        int j = 0;
        for (int i = len - k; i < len; i++) {
            nums[j++] = newNums[i];
        }
        for (int i = 0; i < len - k; i++) {
            nums[j++] = newNums[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, len - k - 1);
        reverse(nums, len - k, len - 1);
        reverse(nums, 0, len - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
