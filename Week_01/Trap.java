package com.agclyy.better.algorithm.week01.homework;

public class Trap {

    public int trap(int[] height) {
        if(null== height || height.length == 0){
            return 0;
        }
        int max = getMax(height);
        int sum = 0;
        for (int line = 1; line <= max; line++) {
            boolean start = false;
            int temp = 0;
            for (int j = 0; j < height.length; j++) {
                if (start && height[j] < line) {
                    temp++;
                }
                if (height[j] >= line) {
                    start = true;
                    sum = sum + temp;
                    temp = 0;
                }
            }
        }
        return sum;
    }

    private int getMax(int[] height) {
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            max = Math.max(max, height[i]);
        }
        return max;
    }


    public int trap2(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            int min = Math.min(max_left, max_right);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }


}
