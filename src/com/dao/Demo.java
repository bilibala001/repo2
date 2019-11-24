package com.dao;

import com.dao.impl.UserDaoImpl;

/**
 * @author ng
 * @date 2019/11/12-20:24
 */
public class Demo {
    public static void main(String[] args) {
        UserDao dao = new UserDaoImpl();
        dao.findAll();
    }
}
