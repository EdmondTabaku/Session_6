package repository.User.impl;

import model.User;
import repository.User.UserRepository;
import util.EntityFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    EntityFactory entityFactory = new EntityFactory();

    @Override
    public User save(User user) {
        EntityManager em = entityFactory.getEntityManager();
        if (user != null){
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
        else {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
        em.close();
        return user;
    }

    @Override
    public List<User> findAll() {
        EntityManager em = entityFactory.getEntityManager();
        Query query = em.createQuery("SELECT u FROM User u");
        List<User> users = query.getResultList();
        em.close();
        return users;
    }

    @Override
    public User findById(int id) {
        EntityManager em = entityFactory.getEntityManager();
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public void delete(int id) {
        User userToDelete = findById(id);
        EntityManager em = entityFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(userToDelete);
        em.getTransaction().commit();
        em.close();
        System.out.println("Deleted user with id: " + id);
    }
}
