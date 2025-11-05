package aud8;

import java.util.Scanner;

public class BinaryTreeNodeLevel {

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

    public static void findLevel() {
        BinaryTree<Integer> tree = GetExampleIntTree();
        Scanner sc = new Scanner(System.in);
        int value = Integer.parseInt(sc.next());
        int level = tree.getLevel(value);
        if(level != 0) {
            System.out.println(level);
        } else {
            System.out.println("Invalid value");
        }

    }

    public static void main(String[] args) {
        findLevel();
    }
}
