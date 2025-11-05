package aud8;

public class BinaryTreeSum {

    public static int sumBT(TreeNode<Integer> node) {
        if(node == null) {
            return 0;
        }
        return (node.data + sumBT(node.left) + sumBT(node.right));
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

    public static void exampleBTSum() {
        BinaryTree<Integer> tree = GetExampleIntTree();
        int sum = sumBT(tree.root);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        exampleBTSum();
    }
}
