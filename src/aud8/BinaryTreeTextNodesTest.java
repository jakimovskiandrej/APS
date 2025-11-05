package aud8;

public class BinaryTreeTextNodesTest {

    public static BinaryTree<String> GetExampleStringTree() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.makeRoot("apple");
        TreeNode<String> tmp1 = tree.addLeftChild("pear",tree.root);
        TreeNode<String> tmp2 = tree.addRightChild("banana",tree.root);
        TreeNode<String> tmp3 = tree.addLeftChild("lemon", tmp2);
        TreeNode<String> tmp4 = tree.addRightChild("orange", tmp2);
        return tree;
    }


    public static void main(String[] args) {
        BinaryTree<String> strTree = GetExampleStringTree();
        strTree.inorder();
        System.out.println(strTree.toString());
    }
}
