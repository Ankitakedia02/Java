package com.test.practice.demo;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void put(int key){
        root = putRec(root, key);
    }

    public Node putRec(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key < root.key){
            root.left = putRec(root.left, key);
        } else if (key > root.key){
            root.right = putRec(root.right, key);
        }
        return root;
    }

    public boolean containsKey(int key){

        return containsKeyRec(root, key);
    }

    public boolean containsKeyRec(Node root, int key){

        if(root == null){
            return false;
        }
        if(key < root.key){
            return containsKeyRec(root.left, key);
        } else if (key > root.key){
            return containsKeyRec(root.right, key);
        } else {
            return true;
        }
    }

    public void inOrderTraversal(){
        inOrderTraversalRec(root);
    }

    public void inOrderTraversalRec(Node root){
        if(root != null){
            inOrderTraversalRec(root.left);
            System.out.println(root.key + ", ");
            inOrderTraversalRec(root.right);
        }
    }

}
