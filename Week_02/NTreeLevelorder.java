package com.agclyy.better.algorithm.week02.homework;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
class NTreeLevelorder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }



    List<List<Integer>> result2 = new ArrayList<>();
    public List<List<Integer>> levelOrder2(Node root) {
        if (root != null) {
            traverseNode(root,0);
        }
        return result2;
    }

    private void traverseNode(Node node, int level) {
        if(result2.size() <= level){
            result2.add(new ArrayList<>());
        }
        result2.get(level).add(node.val);
        List<Integer> levelList = new ArrayList<>();
        node.children.forEach(child ->{
            traverseNode(child,level+1);
        });
    }


}