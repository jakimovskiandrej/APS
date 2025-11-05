package aud8;

public class StringTreeTest {

    public static BinaryTree<String> getExampleStringTree() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.makeRoot("apple");
        TreeNode<String> node1 = tree.addLeftChild("pear", tree.root);
        TreeNode<String> node2 = tree.addLeftChild("peach", node1);
        TreeNode<String> node3 = tree.addRightChild("banana", tree.root);
        node2 = tree.addLeftChild("lemon", node3);
        node2 = tree.addRightChild("orange", node3);
        return tree;
    }

    public static void main(String[] args) {
        BinaryTree<String> tree = getExampleStringTree();
        tree.inorder();
        System.out.println(tree.toString());
    }

}
