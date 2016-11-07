package com.it355.dao;

import com.it355.mappers.ContactMapper;
import com.it355.mappers.UserMapper;
import com.it355.models.Contact;
import com.it355.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao extends HibernateDaoSupport {

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
    public void delete(User user) {
        getHibernateTemplate().delete(user);
    }

    public User findById(long id) {
        List list = getHibernateTemplate().find("from User where id=?", id);
        return (User) list.get(0);
    }
    public List<User> findAll() {
        return (List<User>)getHibernateTemplate().find("from User");
    }

    public User update(User user) {
        getHibernateTemplate().update(user);
        return user;
    }
    public User insert(User user) {
        getHibernateTemplate().save(user);
        return user;
    }
}