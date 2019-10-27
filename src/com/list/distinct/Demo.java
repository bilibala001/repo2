package com.list.distinct;

import com.list.pojo.Student;

import java.util.*;

/**
 * @author ng
 * @date 2019/10/26-8:33
 */
public class Demo {

    public static void main(String[] args) {

        Random random = new Random(20);
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            list.add( new Student("student"+random.nextInt(5),random.nextInt(10)+10,"address"+random.nextInt(3)));
        }
        System.out.println(list.size());

//        list = (ArrayList<Student>) new Demo().distinct(list);

        list = (ArrayList<Student>) new Demo().distinctWithHashSet(list);
        // 怎么排序呢？
//        Collections.sort(list);
        System.out.println(list.size());
        System.out.println(list);

    }

    /**
     * 用hashset去重；
     * @param list
     * @return
     */
    List<Student>  distinctWithHashSet(List<Student> list){
        Set<Student> hashSet = new HashSet<>(300);
        for (Student s : list) {
            hashSet.add(s);
        }

        List<Student> result = new ArrayList<>();
        for (Student s : hashSet) {
            result.add(s);
        }
        return result;
    }

    /**
     * 去除list中重复的对象。
     * @param list
     * @return
     */
    List<Student> distinct(List<Student> list){
        ArrayList<Student> students = new ArrayList<>();
        for (Student s : list) {
            if(!students.contains(s)){
                students.add(s);
            }
        }
        return students;
    }
}
