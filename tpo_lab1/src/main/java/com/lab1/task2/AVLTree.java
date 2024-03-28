package com.lab1.task2;


import java.util.ArrayList;
import java.util.Arrays;

public class AVLTree {
    private AVLNode root;

    public AVLTree() {
        root = null;
    }


    private int height(AVLNode avlNode) {
        return avlNode == null ? -1 : avlNode.height;
    }


    private int max(int lHeight, int rHeight) {
        return lHeight > rHeight ? lHeight : rHeight;
    }

    public void insert(int data) {
        root = insert(data, root);
    }

    public void clear() {
        root = null;
    }

    private AVLNode insert(int data, AVLNode avlNode) {
        if (avlNode == null)
            avlNode = new AVLNode(data);
        else if (data < avlNode.data) {
            avlNode.left = insert(data, avlNode.left);
            if (height(avlNode.left) - height(avlNode.right) == 2)
                if (data < avlNode.left.data)
                    avlNode = leftRotation(avlNode);
                else
                    avlNode = leftRightRotation(avlNode);
        } else if (data > avlNode.data) {
            avlNode.right = insert(data, avlNode.right);
            if (height(avlNode.right) - height(avlNode.left) == 2)
                if (data > avlNode.right.data)
                    avlNode = rightRotation(avlNode);
                else
                    avlNode = rightLeftRotation(avlNode);
        }
        avlNode.height = max(height(avlNode.left), height(avlNode.right)) + 1;
        return avlNode;
    }


    private AVLNode leftRotation(AVLNode avlNode) {
        AVLNode k1 = avlNode.left;
        avlNode.left = k1.right;
        k1.right = avlNode;
        avlNode.height = max(height(avlNode.left), height(avlNode.right)) + 1;
        k1.height = max(height(k1.left), avlNode.height) + 1;
        return k1;
    }


    private AVLNode rightRotation(AVLNode avlNode) {
        AVLNode node = avlNode.right;
        avlNode.right = node.left;
        node.left = avlNode;
        avlNode.height = max(height(avlNode.left), height(avlNode.right)) + 1;
        node.height = max(height(node.right), avlNode.height) + 1;
        return node;
    }


    private AVLNode leftRightRotation(AVLNode avlNode) {
        avlNode.left = rightRotation(avlNode.left);
        return leftRotation(avlNode);
    }


    private AVLNode rightLeftRotation(AVLNode avlNode) {
        avlNode.right = leftRotation(avlNode.right);
        return rightRotation(avlNode);
    }


    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(AVLNode avlNode) {
        if (avlNode == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(avlNode.left);
            l += countNodes(avlNode.right);
            return l;
        }
    }


    public boolean search(int data) {
        return search(root, data);
    }

    private boolean search(AVLNode avlNode, int data) {
        boolean found = false;
        while ((avlNode != null) && !found) {
            int rval = avlNode.data;
            if (data < rval)
                avlNode = avlNode.left;
            else if (data > rval)
                avlNode = avlNode.right;
            else {
                found = true;
                break;
            }
            found = search(avlNode, data);
        }
        return found;
    }

    public int[] inorder() {
        ArrayList<Integer> values = new ArrayList<>();
        inorder(root, values);
        int[] data = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            data[i] = values.get(i);
        }
        return data;
    }

    private void inorder(AVLNode avlNode, ArrayList<Integer> values) {
        if (avlNode != null) {
            inorder(avlNode.left, values);
            values.add(avlNode.data);
            inorder(avlNode.right, values);
        }
    }

    public void insert_data(int[] data) {
        Arrays.stream(data).forEach(this::insert);
    }

    public int[] checkData(int[] data) {
        insert_data(data);
        int[] tree = inorder();
        clear();
        return tree;
    }
}

