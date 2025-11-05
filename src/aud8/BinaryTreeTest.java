package aud8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTreeTest {

//    public static BinaryTree<Integer> getExampleIntTree() {
//        TreeNode<Integer> tmp1, tmp2, tmp3;
//        BinaryTree<Integer> intTree = new BinaryTree<>();
//        intTree.makeRoot(1);
//        tmp1 = intTree.addLeftChild(7,intTree.root);
//        tmp2 = intTree.addLeftChild(2,tmp1);
//        tmp2 = intTree.addRightChild(6,tmp1);
//        tmp3 = intTree.addRightChild(5,tmp2);
//        tmp3 = intTree.addRightChild(11,tmp2);
//        tmp1 = intTree.addRightChild(9,intTree.root);
//        tmp2 = intTree.addRightChild(19,tmp1);
//        tmp3 = intTree.addLeftChild(15,tmp2);
//        return intTree;
//    }

//    public static BinaryTree<Integer> getExampleIntTree() {
//        TreeNode<Integer> tmp1, tmp2, tmp3;
//        BinaryTree<Integer> intTree = new BinaryTree<>();
//        intTree.makeRoot(1);
//        tmp1 = intTree.addLeftChild(7,intTree.root);
//        tmp2 = intTree.addLeftChild(2,tmp1);
//        tmp1 = intTree.addRightChild(9,intTree.root);
//        tmp2 = intTree.addRightChild(19,tmp1);
//        tmp3 = intTree.addLeftChild(15,tmp2);
//        return intTree;
//    }

//    public static BinaryTree<Integer> getExampleIntTree() {
//        TreeNode<Integer> tmp1, tmp2, tmp3;
//        BinaryTree<Integer> intTree = new BinaryTree<>();
//        intTree.makeRoot(26);
//        tmp1 = intTree.addLeftChild(10,intTree.root);
//        tmp3 = intTree.addRightChild(6,tmp1);
//        tmp2 = intTree.addLeftChild(4,tmp1);
//        tmp1 = intTree.addRightChild(3,intTree.root);
//        tmp2 = intTree.addRightChild(3,tmp1);
//        return intTree;
//    }

//    public static BinaryTree<Integer> getExampleIntTree() {
//        TreeNode<Integer> left1, left2, left3, left4, right1, right2, right3, right4;
//        BinaryTree<Integer> intTree = new BinaryTree<>();
//        intTree.makeRoot(3);
//        left1 = intTree.addLeftChild(5,intTree.root);
//        right1 = intTree.addRightChild(3,left1);
//        left2 = intTree.addLeftChild(1,left1);
//        right2 = intTree.addRightChild(9,right1);
//        left3 = intTree.addLeftChild(2,right1);
//        right3 = intTree.addRightChild(1,intTree.root);
//        right4 = intTree.addRightChild(1,right3);
//        left4 = intTree.addLeftChild(6,right4);
//        return intTree;
//    }

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

//    public static void exampleFindNode() {
//        BinaryTree<Integer> tree = getExampleIntTree();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter an integer value to search in the binary tree: ");
//        int value = Integer.parseInt(sc.next());
//        if(tree.findNode(value)) {
//            System.out.println("Node with value " + value + " exists in the given binary tree");
//        } else {
//            System.out.println("Node with value " + value + " does not exist in the given binary tree");
//        }
//    }

//    public static void exampleGetLevel() {
//        BinaryTree<Integer> intTree = getExampleIntTree();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter an integer value to get its level in the binary tree: ");
//        int value = Integer.parseInt(sc.next());
//        int level = intTree.getLevel(value);
//        if(level != 0) {
//            System.out.println("Level of " + value + " is " + level);
//        } else {
//            System.out.println(value + " is not present in the tree");
//        }
//    }

//    public static int sumBT(TreeNode<Integer> node) {
//        if(node == null) {
//            return 0;
//        }
//        return (node.data + sumBT(node.left) + sumBT(node.right));
//    }
//
//    public static void exampleSumBT() {
//        BinaryTree<Integer> tree = getExampleIntTree();
//        int sum = sumBT(tree.root);
//        System.out.println("Sum of all the elements in the tree is: " + sum);
//    }

//    public static int sumMinLeftSubtree(TreeNode<Integer> current, int value) {
//        if(current == null) {
//            return 0;
//        }
//        int tmp = sumMinLeftSubtree(current.left, value) + sumMinLeftSubtree(current.right, value);
//        if(current.data < value) {
//            return tmp + current.data;
//        } else {
//            return tmp;
//        }
//    }
//
//    public static int sumMinRightSubtree(TreeNode<Integer> current, int value) {
//        if(current == null) {
//            return 0;
//        }
//        int tmp = sumMinRightSubtree(current.left, value) + sumMinRightSubtree(current.right, value);
//        if(current.data > value) {
//            return tmp + current.data;
//        } else {
//            return tmp;
//        }
//    }

//    public static void exampleSumSubtrees() {
//        BinaryTree<Integer> tree = getExampleIntTree();
//        Scanner input = new Scanner(System.in);
//        int value = Integer.parseInt(input.nextLine());
//        TreeNode<Integer> node = tree.findNode(value);
//        if(node != null) {
//            System.out.println("The sum of the left subtree is " + sumMinLeftSubtree(node, value));
//            System.out.println("The sum of the right subtree is " + sumMinRightSubtree(node, value));
//        } else {
//            System.out.println("Node with value " + value + " not found");
//        }
//    }

//    public static void exampleGetDist() {
//        BinaryTree<Integer> tree = getExampleIntTree();
//        Scanner input = new Scanner(System.in);
//        int value1 = Integer.parseInt(input.next());
//        int value2 = Integer.parseInt(input.next());
//        int dist = tree.getDist(value1,value2);
//        if(dist != 0) {
//            System.out.println("Dist(" + value1 + ", " + value2 + ") = " + dist);
//        } else {
//            System.out.println("Invalid values");
//        }
//    }

//    public static int sum(TreeNode<Integer> node) {
//        if(node == null) return 0;
//        return node.data + sum(node.left) + sum(node.right);
//    }
//
//    public static boolean isSumTree(TreeNode<Integer> node) {
//        if(node == null) return true;
//        if(node.left == null && node.right == null) return true;
//        int leftSum = sum(node.left);
//        int rightSum = sum(node.right);
//        return (node.data == leftSum + rightSum) && isSumTree(node.left) && isSumTree(node.right);
//    }
//
//    public static boolean aggregateTree() {
//        BinaryTree<Integer> tree = getExampleIntTree();
//        if(tree.root == null) return false;
//        return isSumTree(tree.root);
//    }

//    public static void exampleSumLeftChildren() {
//        BinaryTree<Integer> tree = getExampleIntTree();
//        int sum = tree.sumLeftChildren(tree.root);
//        System.out.println("The sum is: " + sum);
//    }

//    public static int sumNumbers(TreeNode<Integer> node, int sum) {
//        if(node == null) {
//            return 0;
//        }
//        sum = sum * 10 + node.data;
//        if(node.left == null && node.right == null) {
//            return sum;
//        }
//        return sumNumbers(node.left, sum) + sumNumbers(node.right, sum);
//    }
//
//    public static int sumRootToLeaf(TreeNode<Integer> node) {
//        if(node == null) {
//            return 0;
//        }
//        return sumNumbers(node,0);
//    }

//    public static void exampleIsBalanced() {
//        BinaryTree<Integer> tree = getExampleIntTree();
//        System.out.println(tree.toString());
//        if(tree.isBalanced(tree.root)) {
//            System.out.println("Balanced");
//        } else {
//            System.out.println("Not Balanced");
//        }
//    }

    public static void exampleKthSmallest() {
        BinaryTree<Integer> tree = getExampleIntTree();
        Scanner input = new Scanner(System.in);
        int k = Integer.parseInt(input.nextLine());
        List<Integer> sorted = new ArrayList<Integer>();
        tree.inorder(sorted);
        int len = sorted.size();
        if(k > 0 && k <= len) {
            System.out.println("The " + k + "th smallest element in BST is " + sorted.get(k-1));
            System.out.println("The " + k + "th smallest element in BST is " + sorted.get(len - k));
        }
    }

    public static void main(String[] args) {
        exampleKthSmallest();
    }

}
