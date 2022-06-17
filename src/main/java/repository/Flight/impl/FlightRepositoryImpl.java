package repository.Flight.impl;

import model.Flight;
import repository.Flight.FlightRepository;
import util.EntityFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class FlightRepositoryImpl implements FlightRepository {
    EntityFactory entityFactory = new EntityFactory();

    @Override
    public Flight save(Flight flight) {
        EntityManager em = entityFactory.getEntityManager();
        if (flight != null){
            em.getTransaction().begin();
            em.merge(flight);
            em.getTransaction().commit();
        }
        else {
            em.getTransaction().begin();
            em.persist(flight);
            em.getTransaction().commit();
        }
        em.close();
        return flight;
    }

    @Override
    public List<Flight> findAll() {
        EntityManager em = entityFactory.getEntityManager();
        Query query = em.createQuery("SELECT f FROM Flight f");
        List<Flight> flights = query.getResultList();
        em.close();
        return flights;
    }

    @Override
    public Flight findById(int id) {
        EntityManager em = entityFactory.getEntityManager();
        Flight flight = em.find(Flight.class, id);
        return flight;
    }

    @Override
    public void delete(int id) {
        Flight flightToDelete = findById(id);
        EntityManager em = entityFactory.getEntityManager();
        em.getTransaction().begin();
        em.remove(flightToDelete);
        em.getTransaction().commit();
        em.close();
        System.out.println("Deleted flight with id: " + id);
    }
}
