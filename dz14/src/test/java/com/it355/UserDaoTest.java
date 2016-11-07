package com.it355;

import com.it355.dao.UserDao;
import com.it355.models.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/Index-servlet.xml"})
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @org.junit.Test
    public void delete() throws Exception {
        User user = new User();
        user.setUsername("Dux");
        user.setPassword("goodPass12$#");

        user = userDao.insert(user);
        int found = userDao.findAll().size();
        userDao.delete(user);

        assertNotNull(user);
        assertEquals(found, 0);
    }

    @org.junit.Test
    public void findById() throws Exception {
        User user = new User();
        user.setUsername("Dux");
        user.setPassword("goodPass12$#");

        user = userDao.insert(user);

        User userFound = userDao.findById(user.getId());
        userDao.delete(user);
        assertNotNull(userFound);
    }

    @org.junit.Test
    public void findAll() throws Exception {
        User user = new User();
        user.setUsername("Dux");
        user.setPassword("goodPass12$#");

        user = userDao.insert(user);
        int found = userDao.findAll().size();
        userDao.delete(user);
        assertEquals(found, 1);
    }

    @org.junit.Test
    public void update() throws Exception {
        User user = new User();
        user.setUsername("Dux");
        user.setPassword("goodPass12$#");

        user = userDao.insert(user);
        user = userDao.update(user);

        userDao.delete(user);
        assertNotNull(user);
    }

    @org.junit.Test
    public void insert() throws Exception {
        User user = new User();
        user.setUsername("Dux");
        user.setPassword("goodPass12$#");

        user = userDao.insert(user);

        userDao.delete(user);
        assertNotNull(user);
    }

}