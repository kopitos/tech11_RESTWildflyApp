package com.example.tech11;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserEJBImpl implements UserEJB {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> findAll() {
        Query q = em.createQuery("SELECT u FROM User u");
        return q.getResultList();
    }

    @Override
    public User getUser(Long id) {
        User entity = em.find(User.class, id);
        return entity;
    }

    @Override
    public void register(User user) {
        em.persist(user);
    }

    @Override
    public void update(Long id, User user) {
        User entity = em.find(User.class, id);
        entity.setBirthday(user.getBirthday());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setPassword(user.getPassword());
        em.merge(entity);
    }

    @Override
    public void delete(Long id) {

    }
}
