package com.agclyy.better.algorithm.week01.homework;

/**
 * LeetCode 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicates {


    public  int removeDuplicates(int[] nums) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        int j = 0;
        for(int i = 1 ;i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }



}
