package com.agclyy.better.algorithm.week02.homework;



import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class BinaryTreeInorder {

    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (null != root) {
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }


}