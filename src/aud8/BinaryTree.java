package aud8;

import java.util.List;

import static aud8.InorderSuccessor.findMin;

public class BinaryTree<T extends Comparable<T>> {

    public TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public TreeNode<T> addLeftChild(T x, TreeNode<T> parent) {
        TreeNode<T> newNode = new TreeNode<>(x);
        if(parent == null) {
            this.root = newNode;
            System.out.println("Added " + x + " as the root.");
        } else {
            newNode.left = parent.left;
            parent.left = newNode;
            System.out.println("Added " + x + " as the left child of " + parent.data);
        }
        return newNode;
    }

    public TreeNode<T> addRightChild(T x, TreeNode<T> parent) {
        TreeNode<T> newNode = new TreeNode<>(x);
        if(parent == null) {
            this.root = newNode;
            System.out.println("Added " + x + " as the root.");
        } else {
            newNode.right = parent.right;
            parent.right = newNode;
            System.out.println("Added " + x + " as the right child of " + parent.data);
        }
        return newNode;
    }

    private TreeNode<T> findNode(TreeNode<T> n, T key) {
        if (n == null) {
            return null;
        }
        if(n.data.equals(key)) {
            return n;
        }
        TreeNode<T> foundLeft = findNode(n.left, key);
        if(foundLeft != null) {
            return foundLeft;
        }
        TreeNode<T> foundRight = findNode(n.right, key);
        return foundRight;
    }

    public void findNode(T data) {
        if(findNode(root,data) != null) {
            System.out.println("Node with value " + data + " exists in the given binary tree");
        } else {
            System.out.println("Node with value " + data + " does not exist in the given binary tree");
        }
    }

    private TreeNode<T> findLCA(TreeNode<T> node, T n1, T n2) {
        if(node == null) {
            return null;
        }
        if(node.data.equals(n1) || node.data.equals(n2)) {
            return node;
        }
        TreeNode<T> left = findLCA(node.left, n1, n2);
        TreeNode<T> right = findLCA(node.right, n1, n2);

        if(left != null && right != null) {
            return node;
        }
        if(left == null && right == null) {
            return null;
        }
        if(left != null) {
            return left;
        } else {
            return right;
        }
    }

    public int getDist(T n1, T n2) {
        TreeNode<T> lca = findLCA(root, n1, n2);
        int d1 = getLevel(lca,n1,0);
        int d2 = getLevel(lca,n2,0);
        return d1 + d2;
    }

    private TreeNode<T> find(TreeNode<T> node, T x) {
        if(node == null) {
            return null;
        }
        if(x.compareTo(node.data) < 0) {
            return find(node.left, x);
        } else if (x.compareTo(node.data) > 0) {
            return find(node.right, x);
        } else {
            return node;
        }
    }

    public TreeNode<T> find(T x) {
        return find(root, x);
    }

    public void makeRoot(T data) {
        root = new TreeNode<>(data);
    }

    private TreeNode<T> insert(TreeNode<T> node, T x) {
        if(node == null) {
            return new TreeNode<>(x);
        }
        if(x.compareTo(node.data) < 0) {
            node.left = insert(node.left, x);
        } else if(x.compareTo(node.data) > 0) {
            node.right = insert(node.right, x);
        }
        return node;
    }

    public void insert(T x) {
        root = insert(root, x);
    }

    private TreeNode<T> findMin(TreeNode<T> node) {
        if(node == null) {
            return null;
        } else if(node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    private TreeNode<T> remove(TreeNode<T> node, T x) {
        if(node == null) {
            return null;
        }
        if(x.compareTo(node.data) < 0) {
            node.left = remove(node.left, x);
        } else if(x.compareTo(node.data) > 0) {
            node.right = remove(node.right, x);
        } else if(node.left != null && node.right != null) {
            node.data = findMin(node.right).data;
            node.right = remove(node.right, node.data);
        } else {
            if(node.left != null) {
                return node.left;
            } else {
                return node.right;
            }
        }
        return node;
    }

    public int height(TreeNode<T> node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private void inorder(TreeNode<T> node, List<T> sortedInorder) {
        if(node != null) {
            inorder(node.left, sortedInorder);
            sortedInorder.add(node.data);
            inorder(node.right, sortedInorder);
        }
    }

    public void inorder(List<T> sortedInorder) {
        inorder(root, sortedInorder);
    }

    public boolean isBalanced(TreeNode<T> node) {
        int left_h, right_h;
        if(node == null) {
            return true;
        }
        left_h = height(node.left);
        right_h = height(node.right);
        if(Math.abs(left_h - right_h) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
            return true;
        }
        return false;
    }

    public void inorder() {
        System.out.println("Inorder traversal: ");
        inorder(root);
        System.out.println();
    }

    public void postorder() {
        System.out.println("Postorder traversal: ");
        postorder(root);
        System.out.println();
    }

    public void preorder() {
        System.out.println("Preorder traversal: ");
        preorder(root);
        System.out.println();
    }

    private void inorder(TreeNode<T> node) {
        if(node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    private void postorder(TreeNode<T> node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    private void preorder(TreeNode<T> node) {
        if(node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    private int getLevel(TreeNode<T> node, T data, int level) {
        if(node == null) {
            return 0;
        }
        if(node.data.equals(data)) {
            return level;
        }
        int tempLevel = getLevel(node.left, data, level + 1);
        if(tempLevel != 0) {
            return tempLevel;
        }
        tempLevel = getLevel(node.right, data, level + 1);
        return tempLevel;
    }

    public int sumLeftChildren(TreeNode<Integer> node) {
        if(node == null) return 0;
        int sum = 0;
        if(node.left != null && node.right == null) {
            sum += node.left.data;
        }
        return sum + sumLeftChildren(node.left) + sumLeftChildren(node.right);
    }

    public int getLevel(T data) {
        int level = getLevel(root,data,1);
        return level;
    }

    public String toString() {
        return (root!=null) ? root.toString() : "The tree is empty.";
    }
}
