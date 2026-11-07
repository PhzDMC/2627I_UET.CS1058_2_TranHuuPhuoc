package Week9.BT_LapTrinh;

import java.util.Scanner;

public class Bai4 {
    public static Node lca(Node root, int v1, int v2) {
        int cur = root.data;
        if(v1 < cur && v2 < cur){
            Node ans=lca(root.left, v1, v2);
            return ans;
        }
        else if(v1 > cur && v2 > cur){
            Node ans=lca(root.right, v1, v2);
            return ans;
        }
        else{
            return root;
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}
