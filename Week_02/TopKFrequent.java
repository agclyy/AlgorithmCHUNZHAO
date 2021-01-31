package com.agclyy.better.algorithm.week02.homework;

import java.util.*;
import java.util.stream.Collectors;

class TopKFrequent {


    public int[] topKFrequent2(int[] nums, int k) {

        Map<Integer, Integer> numSize = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numSize.get(nums[i]) == null) {
                numSize.put(nums[i], 1);
            } else {
                numSize.put(nums[i], numSize.get(nums[i]) + 1);
            }
        }

        // 频率不会为0 ， 故size 为length + 1
        List<Integer>[] buckets = new List[nums.length + 1];
        //出现的频率一样 报错
        numSize.keySet().stream().forEach(
                num -> {
                    Integer kk = numSize.get(num);
                    if (buckets[kk] == null) {
                        buckets[kk] = new ArrayList<>();
                    }
                    buckets[kk].add(num);
                }
        );

        List<Integer> temp = new ArrayList<>();
        int[] result = new int[k];
        for (int j = nums.length; j >= 0 && temp.size() < k; j--) {
            if (buckets[j] != null) {
                temp.addAll(buckets[j]);
            }
        }
        int index2 = 0;
        for (Integer num : temp) {
            result[index2++] = num;
        }
        return result;
    }

    public static int[] topKFrequent3(int[] nums, int k) {

        Map<Integer, Integer> numSize = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numSize.get(nums[i]) == null) {
                numSize.put(nums[i], 1);
            } else {
                numSize.put(nums[i], numSize.get(nums[i]) + 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return numSize.get(a) - numSize.get(b);
            }
        });
        numSize.keySet().forEach(num ->{
            if(queue.size() < k){
                queue.add(num);
            }else{
                if(numSize.get(num) > numSize.get(queue.peek())){
                    queue.poll();
                    queue.add(num);
                }
            }
        });
        int[] result = new int[k];
        int index = 0;
        while(!queue.isEmpty()){
            result[index++] = queue.remove();
        }
        return result;
    }



}