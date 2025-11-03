package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*                     

        [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]                         
            1                 
          /   \                  
         2     3
        / \     \
       4   5     6

Preorder means we visit Root first, then the Left child, then the Right child.
In short:
    Root → Left → Right
        [1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1]

Inorder Traversal
You first visit the entire left subtree, then the current node, and then the right subtree.
    Left → Root → Right
        [4, 2, 5, 1, 3, 6]

Postorder Traversal
You visit both subtrees first, and the root node last.
    Left → Right → Root
        [4, 5, 2, 6, 3, 1]

level order
    Top->Bottom && Left->Right
        1
        2 3
        4 5 6
        
*/

public class treesBT {

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

        static Node buildTree(int nodes[]) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
        
        static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        static void levelOrder(Node root){
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+ " ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        static int heightBt(Node root){
            if(root == null){
                return 0;
            }

            int leftHeight = heightBt(root.left);
            int rightHeight = heightBt(root.right);

            int ans = Math.max(leftHeight, rightHeight) + 1;
            return ans;
        }
        
        static int countOFnodesBt(Node root){
            if(root == null){
                return 0;
            }

            int leftCount = countOFnodesBt(root.left);
            int rightCount = countOFnodesBt(root.right);

            int ans = leftCount + rightCount + 1;
            return ans;
        }
        
        static int sumOFnodesBt(Node root){
            if(root == null){
                return 0;
            }

            int leftSum = sumOFnodesBt(root.left);
            int rightSum = sumOFnodesBt(root.right);

            int ans = leftSum + rightSum + root.data;
            return ans;
        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        Node root = BT.buildTree(nodes);


        BT.preorder(root);
        System.out.println(" <- Pre order");
        BT.inorder(root);
        System.out.println(" <- In order");
        BT.postorder(root);
        System.out.println(" <- Post order");
        BT.levelOrder(root);
        System.out.println("<- Level order");
        System.out.println(BT.heightBt(root) + " <- Height of BT");
        System.out.println(BT.countOFnodesBt(root) + " <- Number of Nodes in BT");
        System.out.println(BT.sumOFnodesBt(root) + " <- Sum of Nodes in BT");

    }
}
