package aud8;

import java.util.Scanner;

public class BinaryTreeSumLeftNodes {

    public static BinaryTree<Integer> GetExampleIntTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(7);
        root.right = new TreeNode<>(9);

        root.left.left = new TreeNode<>(2);
        root.right.right = new TreeNode<>(19);

        root.right.right.left = new TreeNode<>(15);

        tree.root = root;

        return tree;
    }

    public static int sumLeftNodes(TreeNode<Integer> current) {
        int sum = 0;
        if(current == null) {
            return 0;
        }
        if(current.left != null) {
            sum += current.left.data + sumLeftNodes(current.left);
        }
        sum+=sumLeftNodes(current.right);
        return sum;
    }

    public static void exampleSumLeftNodes() {
        BinaryTree<Integer> tree = GetExampleIntTree();
        int sum = sumLeftNodes(tree.root);
        System.out.println("Sum of left child nodes: " + sum);
    }

    public static void main(String[] args) {
        exampleSumLeftNodes();
    }
}
