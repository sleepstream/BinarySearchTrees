package com.aristovga;

import java.util.*;
import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Solution{

    public static int getHeight(Node root){
        return getInDeep(root, -1);
    }

    public static int getInDeep(Node current, int deep)
    {
        if(current == null)
            return deep;
        deep+=1;
        int tmpRight = getInDeep(current.right, deep);
        int tmpLeft = getInDeep(current.left, deep);

        return tmpLeft >tmpRight ? tmpLeft : tmpRight;

    }

    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }

    private static final InputStreamReader isr=new InputStreamReader(System.in);
    public static void main(String args[]) throws IOException {
        BufferedReader br= new BufferedReader(isr);
        int T = Integer.valueOf(br.readLine());
        Node root=null;
        while(T-->0){
            int data=Integer.valueOf(br.readLine());
            root=insert(root,data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }
}