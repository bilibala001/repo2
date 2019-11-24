package com.dao.impl;

import com.dao.BaseDao;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author ng
 * @date 2019/11/12-20:16
 */
@SuppressWarnings("s")
public class BaseDaoImpl<T> implements BaseDao<T> {
    //    @Resource
//    private SessionFactory sessionFactory;
    private Class<T> clazz;

    public BaseDaoImpl() {

        // this= UserDaoImpl@533;   type1=ParameterizedTypeImpl@567
        Type type1 = this.getClass().getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) type1;//        type=ParameterizedTypeImpl@567
        Type typeArgument = type.getActualTypeArguments()[0];  // typeArgument =Class@567
        clazz = (Class) typeArgument;
        System.out.println(clazz);// class com.constructor.newincon.Person
    }

    @Override
    public void save(T entity) {
        System.out.println("save");
    }

    @Override
    public void delete(Long id) {
        System.out.println("delete");
    }

    @Override
    public void update(T entity) {
        System.out.println("update");
    }

    @Override
    public T getById(Long id) {
        return null;
    }

    @Override
    public List<T> getByIds(Long[] ids) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
}
