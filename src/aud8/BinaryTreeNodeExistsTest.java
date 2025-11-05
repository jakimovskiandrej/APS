package aud8;

import java.util.Scanner;

public class BinaryTreeNodeExistsTest {

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


    public static void exampleFindNode() {
        BinaryTree<Integer> tree = GetExampleIntTree();
        Scanner sc = new Scanner(System.in);
        int value = Integer.parseInt(sc.next());
        if(tree.find(value) != null) {
            System.out.println("Node found");
        } else {
            System.out.println("Node not found");
        }
    }

    public static void main(String[] args) {
        exampleFindNode();
    }
}
