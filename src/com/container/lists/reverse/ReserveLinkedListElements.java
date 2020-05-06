package com.container.lists.reverse;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author ng
 * @date 2020/1/12-17:06
 * 要求：反转双向链表中的元素，就是LinkedList
 * 实现：
 *  因为无法获取Node节点，这个是private的。
 *  新建一个linkedlist链表，size相同，只写入data。
 *
 *   node.setNext(curr);
 *             curr = node;
 */
public class ReserveLinkedListElements {
    @Test
    public void fn1(){
        LinkedList<String> lists = new LinkedList<>();
        lists.add("aa");
        lists.add("bb");
        lists.add("cc");
        lists.add("dd");
        LinkedList<String> list = reverseList(lists);
        lists = list;   // 要得到原来的引用。
        System.out.println(lists);
    }

   static LinkedList<String> reverseList(LinkedList<String> list) {
        // 这个是为了是新链表的长度 == list的长度，而不是为了数据。
        LinkedList<String> es = new LinkedList<String>();
        for (int i = list.size() - 1; i >= 0; i--) {
            es.add(list.get(i));
        }
        return es;
    }
}
