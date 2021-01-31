package com.agclyy.better.algorithm.week02.homework;


import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class NTreePreorder {

    List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (null != root) {
            result.add(root.val);
            root.children.forEach(child -> {
                preorder(child);
            });
        }
        return result;
    }


}