package aud8;

import org.w3c.dom.Node;

import java.util.List;
import java.util.Scanner;

public class BinaryTreeInorder {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BTree<Integer> tree = new BTree<Integer>();
        int n = in.nextInt();
        for(int i = 1; i < n; i++) {
            int value = in.nextInt();
            if(tree.root!=null) {
                if(i%2 == 0) {
                    tree.addChild(tree.root,BNode.LEFT,value);
                } else {
                    tree.addChild(tree.root,BNode.RIGHT,value);
                }
            }
        }
        tree.inorder();
        System.out.println(tree.root.toString());
    }

}
