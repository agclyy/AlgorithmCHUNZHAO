package com.agclyy.better.algorithm.week02.homework;

class UglyNumber {


    public int nthUglyNumber(int n) {
        int[] uglyNums = new int[n];
        uglyNums[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            uglyNums[i] = Math.min(Math.min(uglyNums[a]*2,uglyNums[b]*3),uglyNums[c]*5);
            if(uglyNums[i] == uglyNums[a]*2){
                a++;
            }
            if(uglyNums[i] == uglyNums[b]*2){
                b++;
            }
            if(uglyNums[i] == uglyNums[c]*2){
                c++;
            }
        }
        return uglyNums[n-1];

    }


}