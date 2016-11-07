package com.it355;

import com.it355.dao.ContactDao;
import com.it355.models.Contact;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/Index-servlet.xml"})
public class ContactDaoTest {
    @Autowired
    private ContactDao contactDao;

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void delete() throws Exception {
        Contact contact = new Contact();
        contact.setName("Dusan");
        contact.setNumber("0637538100");

        contact = contactDao.insert(contact, 1);
        int found = contactDao.findAllForUser(1).size();
        contactDao.delete(contact);

        assertNotNull(contact);
        assertEquals(found, 0);
    }

    @org.junit.Test
    public void findById() throws Exception {
        Contact contact = new Contact();
        contact.setName("Dusan");
        contact.setNumber("0637538100");

        contact = contactDao.insert(contact, 1);

        Contact contactFound = contactDao.findById(contact.getId());
        contactDao.delete(contact);
        assertNotNull(contactFound);
    }

    @org.junit.Test
    public void findAllForUser() throws Exception {
        Contact contact = new Contact();
        contact.setName("Dusan");
        contact.setNumber("0637538100");

        contact = contactDao.insert(contact, 1);
        int found = contactDao.findAllForUser(1).size();
        contactDao.delete(contact);
        assertEquals(found, 1);
    }

    @org.junit.Test
    public void update() throws Exception {
        Contact contact = new Contact();
        contact.setName("Dusan");
        contact.setNumber("0637538100");

        contact = contactDao.insert(contact, 1);
        contact = contactDao.update(contact);

        contactDao.delete(contact);
        assertNotNull(contact);
    }

    @org.junit.Test
    public void insert() throws Exception {
        Contact contact = new Contact();
        contact.setName("Dusan");
        contact.setNumber("0637538100");

        contact = contactDao.insert(contact, 1);

        contactDao.delete(contact);
        assertNotNull(contact);
    }

}