package Week9.BT_LapTrinh;

import java.util.Scanner;
import java.util.Vector;

public class Bai5 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node() {
            this.data = -1;
            this.left = null;
            this.right = null;
        }
    }

    static class Tree {
        // List of node data values:
        Vector<Integer> values;
        // Total number of nodes in the tree:
        private int count;

        Tree() {
            this.values = new Vector<Integer>();
            this.count = 0;
        }

        boolean checkBST(Node root) {
            return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        boolean checkBSTHelper(Node root, int min, int max) {
            if (root == null) {
                return true;
            }

            if (root.data <= min || root.data >= max) {
                return false;
            }

            return checkBSTHelper(root.left, min, root.data)
                    && checkBSTHelper(root.right, root.data, max);
        }

        void inOrder(Node root, int levels) {
            if (root != null) {
                // If there are still unfilled levels, fill left subtree:
                if (levels > 0) {
                    // Create a new left child node:
                    root.left = new Node();
                    inOrder(root.left, levels - 1);
                }

                // Set node data:
                root.data = values.elementAt(count);
                count++;

                // If there are still unfilled levels, fill right subtree:
                if (levels > 0) {
                    // Create a new right child node:
                    root.right = new Node();
                    inOrder(root.right, levels - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int height = scanner.nextInt();

        // Read data values for tree's nodes:
        Tree tree = new Tree();

        // Tính tổng số nút: 2^(height + 1) - 1
        int totalNodes = (1 << (height + 1)) - 1;
        for (int i = 0; i < totalNodes; i++) {
            tree.values.add(scanner.nextInt());
        }
        scanner.close();

        // Fill tree:
        Node root = new Node();
        tree.inOrder(root, height);

        // Print result:
        System.out.println((tree.checkBST(root) == true) ? "Yes" : "No");
    }
}