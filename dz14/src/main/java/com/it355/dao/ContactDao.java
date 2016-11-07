package com.it355.dao;

import com.it355.models.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public class ContactDao extends HibernateDaoSupport {

    @Autowired
    public ContactDao(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }

    public void delete(Contact contact) {
        getHibernateTemplate().delete(contact);
    }

    public Contact findById(long id) {
        List list = getHibernateTemplate().find(
                "from Contact where id=?", id
        );
        return (Contact) list.get(0);
    }

    public List<Contact> findAllForUser(long userId) {
        return (List<Contact>)getHibernateTemplate().find(
                "from Contact where user_id=?",userId
        );

    }

    public Contact update(Contact contact) {
        getHibernateTemplate().update(contact);
        return contact;
    }
    public Contact insert(Contact contact, long userId) {
        contact.setUserId(userId);
        getHibernateTemplate().save(contact);
        return contact;
    }
}
