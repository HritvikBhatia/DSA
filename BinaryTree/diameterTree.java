package BinaryTree;

/* 
    Diameter if a tree
    Number  of Nodes in the longest path between 2 leaves

    case1 pass diameter pass through root node 
        Dia = leftheight + rightHeight + 1
    case2 diameter doent pass through root
        left Diameter(leftDia) , right Diameter(rightDia)
        
    return max of (Dia, leftDia, rightDia)
*/
public class diameterTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BT {
        static int idx = -1;

        static int heightBt(Node root){
            if(root == null){
                return 0;
            }

            int leftHeight = heightBt(root.left);
            int rightHeight = heightBt(root.right);
            
            int ans = Math.max(leftHeight, rightHeight) + 1;
            return ans;
        }
        
        static int diameter(Node root){
            if(root == null){
                return 0;
            }
            int leftDia = diameter(root.left);
            int rightDia = diameter(root.right);
            
            int leftHeight = heightBt(root.left);
            int rightHeight = heightBt(root.right);

            int selfDia = leftHeight + rightHeight + 1;

            return Math.max(selfDia, Math.max(rightDia, leftDia));
        }
    }

    public static void main(String[] args) {

    /* 
            1                 
          /   \                  
         2      3
        / \    / \
       4   5  6   7

       4 - 2 - 1 - 3 - 7 = 5
    */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(BT.diameter(root));
    }
}