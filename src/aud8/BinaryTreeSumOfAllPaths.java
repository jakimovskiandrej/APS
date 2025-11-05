package aud8;

public class BinaryTreeSumOfAllPaths {

    public static BinaryTree<Integer> GetExampleIntTree() {
        BinaryTree<Integer> tree = new BinaryTree<>();

        TreeNode<Integer> root = new TreeNode<>(3);
        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(1);

        root.left.left = new TreeNode<>(1);
        root.right.right = new TreeNode<>(1);

        root.right.right.left = new TreeNode<>(6);
        root.left.right = new TreeNode<>(3);
        root.left.right.left = new TreeNode<>(2);
        root.left.right.right = new TreeNode<>(9);

        tree.root = root;

        return tree;
    }

    public static int sumOfAllPaths(TreeNode<Integer> node, int current) {
        BinaryTree<Integer> tree = GetExampleIntTree();
        if(node == null) {
            return 0;
        }
        current = current * 10 + node.data;
        if(node.left == null && node.right == null) {
            return current;
        }
        return sumOfAllPaths(node.left, current) + sumOfAllPaths(node.right, current);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = GetExampleIntTree();
        int totalSum = sumOfAllPaths(tree.root,0);
        System.out.println("Sum of all root-to-leaf numbers " + totalSum);
    }
}
