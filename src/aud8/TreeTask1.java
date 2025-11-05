package aud8;

import java.util.Scanner;

public class TreeTask1 {

    public static BinaryTree<Integer> getExampleIntTree() {
        TreeNode<Integer> left1, left2, left3, right1, right2, right3;
        BinaryTree<Integer> intTree = new BinaryTree<>();
        intTree.makeRoot(8);
        left1 = intTree.addLeftChild(2,intTree.root);
        right1 = intTree.addRightChild(11,intTree.root);
        left2 = intTree.addLeftChild(1,right1);
        right2 = intTree.addRightChild(5,left1);
        right3 = intTree.addRightChild(19,right1);
        left3 = intTree.addLeftChild(13,right3);
        return intTree;
    }

    public static int findKthSmallest(TreeNode<Integer> node, int k, int[] count) {
        if(node == null) {
            return -1;
        }
        int left = findKthSmallest(node.left, k, count);
        if(left!=-1) {
            return left;
        }
        count[0]++;
        if(count[0]==k) {
            return node.data;
        }
        return findKthSmallest(node.right, k, count);
    }

    public static int sumElementsUpTo(TreeNode<Integer> node, int target) {
        if(node == null) {
            return 0;
        }
        int sum = 0;
        if(node.data <= target) {
            sum+=node.data;
        }
        sum+=sumElementsUpTo(node.right, target);
        sum+=sumElementsUpTo(node.left, target);
        return sum;
    }

    public static void exampleSumOfKElements() {
        BinaryTree<Integer> tree = getExampleIntTree();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] count = {0};
        int kthSmallest = findKthSmallest(tree.root,k,count);
        if(kthSmallest==-1) {
            System.out.println("No smallest element found");
        } else {
            int sum = sumElementsUpTo(tree.root,kthSmallest);
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        exampleSumOfKElements();
    }

}
