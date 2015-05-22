package com.springapp.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class DAO<Type> {

    private Class<Type> entityClass;

    @Autowired
    private SessionFactory sessionFactory;

    public DAO(Class<Type> entityClass) {
        this.entityClass = entityClass;
    }

    public void add(Type type) {
        sessionFactory.getCurrentSession().save(type);
    }

    @SuppressWarnings("unchecked")
    public List<Type> list() {

        return sessionFactory.getCurrentSession().createQuery("from "+entityClass.getName())
                .list();
    }

    public void remove(Integer id) {
        Type Type = (Type) sessionFactory.getCurrentSession().load(
                entityClass, id);
        if (null != Type) {
            sessionFactory.getCurrentSession().delete(Type);
        }
    }

    public Type get(Integer id) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(entityClass);
        cr.add(Restrictions.eq("id", id));
        List results = cr.list();
        Type result = (results!=null && !results.isEmpty())?(Type)results.get(0):null;
        return result;
    }

    public void update(Type type) {
        if (null != type) {
            sessionFactory.getCurrentSession().update(type);
        }
    }

}

