package aud8;

import java.util.Scanner;

public class Task1Courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        BTree<String> tree = new BTree<>();
        sc.nextLine();
        for(int i = 0; i < n + q; i++) {
            String command = sc.next();
            if(command.equals("root")) {
                String rootID = sc.next();
                tree.makeRoot(rootID);
            } else if(command.equals("add")) {
                String parentID = sc.next();
                String childID = sc.next();
                String position = sc.next();
                if(position.equals("LEFT")) {
                    tree.addChild(tree.find(tree.root,parentID), 1, childID);
                } else {
                    tree.addChild(tree.find(tree.root,parentID), 2, childID);
                }
            } else {
                String childID = sc.next();
                BNode<String> node = tree.find(tree.root, childID);
                System.out.println(tree.depthR(node));
            }
        }
    }
}
