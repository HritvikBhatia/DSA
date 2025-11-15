package BinaryTree;

public class subTree {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Check if T2 is a subtree of T1
    public static boolean isSubtree(TreeNode T1, TreeNode T2) {
        // Empty tree is always a subtree
        if (T2 == null) return true;

        // Main tree empty but T2 not empty false
        if (T1 == null) return false;

        // If same tree starting from this node
        if (isSameTree(T1, T2)) return true;

        // Otherwise, check left and right subtree
        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }

    // Check if two trees are identical
    public static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.val != b.val) return false;

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    public static void main(String[] args) {
        // Tree T1
        TreeNode T1 = new TreeNode(1);
        T1.left = new TreeNode(2);
        T1.right = new TreeNode(3);
        T1.left.left = new TreeNode(4);

        // Tree T2
        TreeNode T2 = new TreeNode(2);
        T2.left = new TreeNode(4);

        System.out.println(isSubtree(T1, T2)); // true
    }
}

