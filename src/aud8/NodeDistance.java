package aud8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NodeDistance {

    public static BNode<String> findLCA(BNode<String> root, String n1, String n2) {
        if(root == null) {
            return null;
        }
        if(root.info.equals(n1) || root.info.equals(n2)) {
            return root;
        }
        BNode<String> leftLCA = findLCA(root.left, n1, n2);
        BNode<String> rightLCA = findLCA(root.right, n1, n2);
        if(leftLCA != null && rightLCA != null) {
            return root;
        }
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static int findDistance(BNode<String> root, String target, int level) {
        if(root == null) {
            return 0;
        }
        if(root.info.equals(target)) {
            return level;
        }
        int left = findDistance(root.left, target, level + 1);
        if(left != -1) {
            return left;
        }
        return findDistance(root.right, target, level + 1);
    }

    private static boolean nodeExists(BNode<String> root, String target) {
        if(root == null) {
            return false;
        }
        if(root.info.equals(target)) {
            return true;
        }
        return nodeExists(root.left, target) || nodeExists(root.right, target);
    }

    public static void main(String[] args) throws Exception {
        int i, j, k;
        int index;
        String action;

        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        BNode<String> nodes[] = new BNode[N];
        BTree<String> tree = new BTree<String>();

        for (i=0;i<N;i++)
            nodes[i] = new BNode<String>();

        for (i = 0; i < N; i++) {
            line = br.readLine();
            st = new StringTokenizer(line);
            index = Integer.parseInt(st.nextToken());
            nodes[index].info = st.nextToken();
            action = st.nextToken();
            if (action.equals("LEFT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.LEFT, nodes[index]);
            } else if (action.equals("RIGHT")) {
                tree.addChildNode(nodes[Integer.parseInt(st.nextToken())], BNode.RIGHT, nodes[index]);
            } else {
                // this node is the root
                tree.makeRootNode(nodes[index]);
            }
        }


        int cases = Integer.parseInt(br.readLine());
        for (int l = 0; l < cases; l++) {
            String split[] = br.readLine().split(" +");
            String from = split[0];
            String to = split[1];
            BNode<String> root = tree.root;
            if(!nodeExists(root,from) || !nodeExists(root,to)) {
                System.out.println("ERROR");
                continue;
            }
            BNode<String> lca = findLCA(root,from,to);
            int distanceFromLCAToFrom = findDistance(lca,from,0);
            int distanceFromLCAToTo = findDistance(lca,to,0);
            int shortestDistance = (distanceFromLCAToFrom + distanceFromLCAToTo) * 2;
            System.out.println(shortestDistance);
        }
        br.close();
    }
}
