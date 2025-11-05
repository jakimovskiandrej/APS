 package aud8;

public class TreeNode<T extends Comparable<T>> {

    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper_space(sb,this,0,7);
        return sb.toString();
    }

    private void toStringHelper_space(StringBuilder sb, TreeNode<T> node, int space, int count) {
        if(node == null) {
            return;
        }
        space+=count;
        toStringHelper_space(sb,node.right,space,count);
        sb.append("\n");
        sb.append(" ".repeat(Math.max(0, space - count)));
        sb.append(node.data).append("\n");
        toStringHelper_space(sb,node.left,space,count);
    }

    public TreeNode<T> findNode(TreeNode<T> n, T key) {
        if(n == null) {
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
        return foundRight == null ? n : foundRight;
    }

}
