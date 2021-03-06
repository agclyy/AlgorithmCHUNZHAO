package com.agclyy.better.algorithm.week01;

/**
 * 283. Move Zeroes
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] != 0){
                if(i != j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}