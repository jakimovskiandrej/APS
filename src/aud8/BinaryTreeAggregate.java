package aud8;

import java.util.Scanner;

public class BinaryTreeAggregate {

    public static BinaryTree<Integer> GetExampleIntTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        TreeNode<Integer> root = new TreeNode<>(26);
        root.left = new TreeNode<>(10);
        root.right = new TreeNode<>(3);

        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(6);

        root.right.right = new TreeNode<>(3);

        tree.root = root;

        return tree;
    }

    public static int sum(TreeNode<Integer> node) {
        if(node == null) {
            return 0;
        }
        return sum(node.left) + node.data + sum(node.right);
    }

    public static boolean aggregateTree(TreeNode<Integer> current) {
        if(current == null) {
            return true;
        }
        if(current.left == null && current.right == null) {
            return true;
        }
        if(aggregateTree(current.left) && aggregateTree(current.right)) {
            int leftSum = sum(current.left);
            int rightSum = sum(current.right);
            return current.data == leftSum + rightSum;
        }
        return false;
    }

    public static void exampleAggregateTree() {
        BinaryTree<Integer> tree = GetExampleIntTree();
        boolean flag = aggregateTree(tree.root);
        if(flag) {
            System.out.println("The following tree is aggregated");
        } else {
            System.out.println("The following tree is not aggregated");
        }
    }

    public static void main(String[] args) {
        exampleAggregateTree();
    }
}
