package aud8;

import java.util.Scanner;

public class BinaryTreeSumSubTree {

    public static int sumMinLeftSubtree(TreeNode<Integer> current, int value) {
        if(current == null) {
            return 0;
        }
        int tmp = sumMinLeftSubtree(current.left, value) + sumMinLeftSubtree(current.right, value);
        if(current.data < value) {
            return tmp + current.data;
        } else {
            return tmp;
        }
    }

    public static int sumMaxRightSubtree(TreeNode<Integer> current, int value) {
        if(current == null) {
            return 0;
        }
        int tmp = sumMaxRightSubtree(current.left, value) + sumMaxRightSubtree(current.right, value);
        if(current.data > value) {
            return tmp + current.data;
        } else {
            return tmp;
        }
    }

    public static BinaryTree<Integer> GetExampleIntTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(15);

        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(7);

        root.right.right = new TreeNode<>(20);

        tree.root = root;

        return tree;
    }

    public static void exampleSumSubtrees() {
        BinaryTree<Integer> tree = GetExampleIntTree();
        Scanner sc = new Scanner(System.in);
        int value = Integer.parseInt(sc.next());
        TreeNode<Integer> node = tree.find(value);
        if(node != null) {
            System.out.println("Sum of the left subtree is " + sumMinLeftSubtree(node.left, value));
            System.out.println("Sum of the right subtree is " + sumMaxRightSubtree(node.right, value));
        } else {
            System.out.println(value + " doesn't exist");
        }
    }

    public static void main(String[] args) {
        exampleSumSubtrees();
    }
}
