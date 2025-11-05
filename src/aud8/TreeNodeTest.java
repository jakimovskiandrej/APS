package aud8;

public class TreeNodeTest {

    public static void main(String[] args) {
        TreeNode<Integer> tmp1, tmp2, tmp3;
        BinaryTree<Integer> tree = new BinaryTree<Integer>();
        tree.makeRoot(1);
        tmp1 = tree.addLeftChild(7,tree.root);
        tmp2 = tree.addLeftChild(2,tmp1);
        tmp2 = tree.addRightChild(6,tmp1);
        tmp3 = tree.addLeftChild(5,tmp2);
        tmp3 = tree.addRightChild(11,tmp2);
        tmp1 = tree.addRightChild(9,tree.root);
        tmp2 = tree.addRightChild(19,tmp1);
        tmp3 = tree.addLeftChild(15,tmp2);

        tree.inorder();
        tree.preorder();
        tree.postorder();
    }

}
