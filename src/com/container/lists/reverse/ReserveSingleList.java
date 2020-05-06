package com.container.lists.reverse;

import org.junit.Test;

/**
 * @author ng
 * @date 2020/1/12-21:13
 * 要求：反转单向链表。  data不变，指针重新设置。
 * <p>
 * 这个实例学到了：
 * 1 画起始模型图和最终模型图。
 * 2 因为要用代码实现模型图，所以还要画出模型图的详细变化步骤。
 * 3 while循环次数的控制，判断条件的重新设置
 * 4 就该例，每次循环里面，只操作当前元素,获取下一次元素。此时还不知道
 * 下一个节点是不是null。
 */
public class ReserveSingleList {
    @Test
    public void fn1() {
        //构建节点
        Node head = new Node();
        head.setValue("aa");
        Node sec = new Node();
        sec.setValue("bb");
        Node third = new Node();
        third.setValue("cc");
        Node four = new Node();
        four.setValue("dd");
        Node five = new Node();
        five.setValue("ee");

        //关联节点
        head.setNext(sec);
        sec.setNext(third);
        third.setNext(four);
        four.setNext(five);

        //反转，遍历打印
        Node node = new ReserveSingleList().reverseNode(head);
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }

    }

    public Node reverseNode(Node node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        Node pre = null;
        Node curr = null;
        /**
         * 如果一个链表长度为5，
         * 那么想迭代5次，就用当前node为判断条件,再把node = node.next()。
         * 如果想迭代4次，就用node的next作为判断条件。
         */
        while (node != null) {
            Node secNode = node.getNext();
             /*
            node.setNext(curr).
            curr = node.
            这2行可以替换下面3行代码。
            */
            curr = node;
            curr.setNext(pre);
            pre = curr;
            node = secNode; //这样可以循环了。
        }

        // 没想到node最终明显会成为null。不能返回node了
        // 没想到curr = node后，操作curr，等于node也变化了。因为node要指向另一个。
        return curr;
    }
}

class Node {
    private Node next;
    private Object value;

    public Node(Node next, Object value) {
        this.next = next;
        this.value = value;
    }

    public Node() {
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}