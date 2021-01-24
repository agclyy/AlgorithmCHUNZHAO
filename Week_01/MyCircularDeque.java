package com.agclyy.better.algorithm.week01.homework;

class MyCircularDeque {

    private Node head;
    private Node tail;

    private int size;
    private int maxSize;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.head = null;
        this.tail = null;

        this.size = 0;
        this.maxSize = k;
        
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()) {
            return false;
        }
        Node node = new Node(value);
        node.next = head;
        if(head == null) {
            head = node;
            tail = head;
        } else {
            head.prev = node;
            head = node;
        }
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(size == 0) {
            return insertFront(value);
        }
        if(isFull()) {
            return false;
        }
        Node node = new Node(value);
        node.prev = tail;
        tail.next = node;
        tail = tail.next;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        Node next = head.next;
        if(next != null) {
            next.prev = null;
        }
        head.next = null;
        head = next;
        if(next == null) {
            tail = head;
        }
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        Node prev = tail.prev;
        if(prev != null) {
            prev.next = null;
        }
        tail.prev = null;
        tail = prev;
        if(prev == null) {
            head = tail;
        }
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) {
            return -1;
        }
        return head.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) {
            return -1;
        }
        return tail.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == maxSize;
    }

    private class Node {
        private int val;
        private Node prev;
        private Node next;

        private Node(int val) {
            this.val = val;
        }
    }
}

