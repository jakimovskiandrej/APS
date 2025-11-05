package aud8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BSTKSmallestBiggest {

    public static BinaryTree<Integer> GetExampleIntTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        TreeNode<Integer> root = new TreeNode<>(8);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(11);

        root.left.left = new TreeNode<>(11);
        root.right.right = new TreeNode<>(19);

        root.right.right.left = new TreeNode<>(13);
        root.left.right = new TreeNode<>(5);
        root.left.right.left = new TreeNode<>(3);
        root.left.right.right = new TreeNode<>(6);

        tree.root = root;

        return tree;
    }

    public static void exampleKthSmallest() {
        BinaryTree<Integer> tree = GetExampleIntTree();
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        List<Integer> sorted = new ArrayList<>();
        tree.inorder(sorted);
        if(k > 0 && k <= sorted.size()) {
            System.out.println("The " + k + "th smallest element is " + sorted.get(k - 1));
            System.out.println("The " + k + "th biggest element is " + sorted.get(sorted.size() - k));
        }
    }

    public static void main(String[] args) {
        exampleKthSmallest();
    }
}
