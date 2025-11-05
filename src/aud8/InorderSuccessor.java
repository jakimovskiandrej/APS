package aud8;

import java.util.Scanner;

public class InorderSuccessor {

    public static void insertIntoBST(BTree<Integer> tree, int value) {
        tree.root = insertRecursive(tree.root,value);
    }

    public static BNode<Integer> insertRecursive(BNode<Integer> node, int value) {
        if(node == null) {
            return new BNode<>(value);
        }
        if(value < node.info) {
            node.left = insertRecursive(node.left,value);
        } else if(value > node.info) {
            node.right = insertRecursive(node.right,value);
        }
        return node;
    }

    public static BNode<Integer> findNode(BNode<Integer> root, int value) {
        if(root == null) {
            return null;
        }
        if(value < root.info) {
            return findNode(root.left,value);
        } else {
            return findNode(root.right,value);
        }
    }

    public static BNode<Integer> findMin(BNode<Integer> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static BNode<Integer> inorderSuccessor(BNode<Integer> root, int target) {
        BNode<Integer> targetNode = findNode(root,target);
        if(targetNode == null) {
            return null;
        }
        if(targetNode.right != null) {
            return findMin(targetNode.right);
        }
        BNode<Integer> successor = null;
        BNode<Integer> ancestor = root;
        while (ancestor != targetNode) {
            if(targetNode.info < ancestor.info) {
                successor = ancestor;
                ancestor = ancestor.left;
            } else {
                ancestor = ancestor.right;
            }
        }
        return successor;
    }

    public static void printInorder(BNode<Integer> node) {
        if(node!=null) {
            printInorder(node.left);
            System.out.print(node.info + "\n");
            printInorder(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BTree<Integer> tree = new BTree<>();
        for(int i = 0; i < n; i++) {
            int value = sc.nextInt();
            insertIntoBST(tree,value);
        }
        printInorder(tree.root);
    }

}
