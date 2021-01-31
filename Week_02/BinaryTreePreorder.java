package com.agclyy.better.algorithm.week02.homework;


import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class BinaryTreePreorder {

    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(null != root){
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }


}