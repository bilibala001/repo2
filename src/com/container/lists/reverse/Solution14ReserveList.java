package com.container.lists.reverse;

/**
 * @author ng
 * @date 2020/1/13-12:27
 * 别人的代码
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class Solution14ReverseList {
    public static ListNode reverseList(ListNode node)
    {
        ListNode curr = null;
        ListNode secNode = null;
        if(node == null || node.next == null){return node;}
        else
        {
            while(node != null)
            {
                secNode = node.next;
                node.next = curr;   //首元素的next指向自己。
                curr = node;
                node = secNode;
            }
            return curr;
        }
    }

    public static void showListNode(ListNode head)
    {
        while(head != null)
        {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        showListNode(a);
        showListNode(reverseList(a));
    }

}