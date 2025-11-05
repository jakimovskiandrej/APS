package aud8;

public class BSTBalancedTest {

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

    public static void exampleIsBalanced() {
        BinaryTree<Integer> tree = GetExampleIntTree();
        System.out.println(tree.toString());
        if(tree.isBalanced(tree.root)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }


    public static void main(String[] args) {
        exampleIsBalanced();
    }
}
