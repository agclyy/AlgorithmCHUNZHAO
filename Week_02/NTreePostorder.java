package com.agclyy.better.algorithm.week02.homework;


import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class NTreePostorder {

    List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (null != root) {
            for (int i = 0; i < root.children.size(); i++) {
                postorder(root.children.get(i));
            }
            result.add(root.val);
        }
        return result;
    }



}