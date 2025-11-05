package aud8;

public class Task2 {

    static String pathToRoot(BNode<String> node) {
        StringBuilder path = new StringBuilder();
        while (node!=null) {
            path.insert(0, "<" + node.info + "> ");
            node = node.parent;
        }
        return path.toString();
    }

    public static void main(String[] args) {
        BTree<String> tree = new BTree<String>();
        tree.makeRoot("Parent");
        BNode<String> root = tree.root;
        BNode<String> left = tree.addChild(root,BNode.LEFT,"Left");
        BNode<String> right = tree.addChild(root,BNode.RIGHT,"Right");
        BNode<String> left_left = tree.addChild(left,BNode.LEFT,"Left_Left");
        BNode<String> left_right = tree.addChild(left,BNode.LEFT,"Left_Right");
        BNode<String> right_left = tree.addChild(right,BNode.RIGHT,"Right_Left");
        BNode<String> right_right = tree.addChild(right,BNode.RIGHT,"Right_Right");
        System.out.println("Path to root: " + pathToRoot(left_right));
        System.out.println("Path to root: " + pathToRoot(right_left));
    }
}
