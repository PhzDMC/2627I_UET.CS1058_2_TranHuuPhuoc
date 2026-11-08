package Week9.BT_LapTrinh;

import java.util.Scanner;

public class Bai6 {
    static class Node{
        int val;
        int ht;
        Node left;
        Node right;
        static Node newNode(int data){
            Node temp = new Node();
            temp.val = data;
            temp.left=null;
            temp.right=null;
            return temp;
        }
    }
    static int ht_hidden(Node T){
        if(T==null){
            return 0;
        }
        int lh = (T.left == null) ? 0 : 1 + T.left.ht;
        int rh = (T.right == null) ? 0 : 1 + T.right.ht;
        return Math.max(lh,rh);
    }
    static Node rolate_right_hidden(Node x){
        Node y = x.left;
        x.left=y.right;
        y.right=x;
        x.ht=ht_hidden(x);
        y.ht=ht_hidden(y);
        return y;
    }
    static Node rolate_left_hidden(Node x){
        Node y = x.right;
        x.right=y.left;
        y.left=x;
        x.ht=ht_hidden(x);
        y.ht=ht_hidden(y);
        return y;
    }
    static Node RR_hidden(Node T){
        return rolate_left_hidden(T);
    }
    static Node LL_hidden(Node T){
        return rolate_right_hidden(T);
    }
    static Node RL_hidden(Node T){
        T.right=rolate_right_hidden(T.right);
        return rolate_left_hidden(T);
    }
    static Node LR_hidden(Node T){
        T.left=rolate_left_hidden(T.left);
        return rolate_right_hidden(T);
    }
    static int BF_hidden(Node T){
        if(T==null){
            return 0;
        }
        int lh = (T.left==null) ? 0 : 1 + T.left.ht;
        int rh = (T.right==null) ? 0 : 1 + T.right.ht;
        return lh-rh;
    }
    static void inorder_hidden(Node T){
        if (T != null) {
            inorder_hidden(T.left);
            System.out.print(T.val+"(BF="+BF_hidden(T)+") ");
            inorder_hidden(T.right);
        }
    }
    static void preorder_hidden(Node T) {
        if (T != null) {
            System.out.print(T.val+"(BF="+BF_hidden(T)+") ");
            preorder_hidden(T.left);
            preorder_hidden(T.right);
        }
    }
    static Node hiddenInsert(Node T, int x){
        if(T==null){
            T = Node.newNode(x);
        }
        else if(x > T.val){
            T.right=hiddenInsert(T.right,x);
            if(BF_hidden(T)==-2){
                if(x > T.right.val){
                    T = RR_hidden(T);
                }
                else{
                    T= RL_hidden(T);
                }
            }
        }
        else if(x < T.val){
            T.left=hiddenInsert(T.left,x);
            if(BF_hidden(T)==2){
                if(x<T.left.val){
                    T = LL_hidden(T);
                }
                else{
                    T = LR_hidden(T);
                }
            }
        }
        T.ht=ht_hidden(T);
        return T;
    }
    static Node insert(Node root, int val){
        return hiddenInsert(root,val);
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        Node root=null;
        for(int i=0;i<n;i++)
        {
            int val;
            val=sc.nextInt();
            root=hiddenInsert(root,val);
        }
        int nv = sc.nextInt();
        root=insert(root,nv);
        inorder_hidden(root);
        System.out.println("");
        preorder_hidden(root);
        System.out.println("");
    }
}
