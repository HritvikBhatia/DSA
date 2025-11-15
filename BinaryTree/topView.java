package BinaryTree;
import java.util.*;


public class topView {
    
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }
    
    static int minHD = 0, maxHD = 0;

    // Step 1: find horizontal distance range
    static void findWidth(Node root, int hd) {
        if (root == null) return;

        minHD = Math.min(minHD, hd);
        maxHD = Math.max(maxHD, hd);

        findWidth(root.left, hd - 1);
        findWidth(root.right, hd + 1);
    }

    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) { this.node = node; this.hd = hd; }
    }

    public static void topViewBT(Node root) {
        if (root == null) return;

        // Step 1: find width (minHD, maxHD)
        findWidth(root, 0);

        int width = maxHD - minHD + 1;
        Integer[] top = new Integer[width];

        // Step 2: BFS
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int hd = p.hd;
            Node node = p.node;

            int index = hd - minHD;

            // take first node for this HD
            if (top[index] == null)
                top[index] = node.data;

            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        // Step 3: Print top view
        for (int val : top) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {

        /*
                1
              /   \
             2     3
            / \   / \
           4   5 6   7

           Top View = 4 2 1 3 7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        topViewBT(root);
    }
}