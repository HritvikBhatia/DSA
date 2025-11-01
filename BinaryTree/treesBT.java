package BinaryTree;

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

    }
}
