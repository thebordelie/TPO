package com.lab1.task2;

class AVLNode {

    AVLNode left, right;
    int data;
    int height;

    public AVLNode(int n) {
        left = null;
        right = null;
        data = n;
        height = 0;
    }
}