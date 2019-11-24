package com.constructor.newincon;

/**
 * @author ng
 * @date 2019/11/12-9:48
 * 为什么要在构造器中为 new替他的class的对象，
 * 即为什么不通过参数引入了。 而是初始化的时候就引入。
 */
public class Tea {
    private String taste;
    private Person p;

    public Tea() {
        //赋值
        p =  new Person("hh",10);
    }

    @Override
    public String toString() {
        return "Tea{" +
                "taste='" + taste + '\'' +
                ", p=" + p +
                '}';
    }

    public Tea(String taste) {
        this.taste = taste;
    }
}
