package com.tree;

/**
 * @author ng
 * @date 2019/11/27-9:53
 */
public class Node {
   char data;
   Node leftchild;
   Node rightchild;


   public Node(char data) {
      this.data = data;
   }

   public Node(char data, Node leftchild, Node rightchild) {
      this.data = data;
      this.leftchild = leftchild;
      this.rightchild = rightchild;
   }

   public Node() {
   }

   @Override
   public String toString() {
      return  data +" ";
   }
}
