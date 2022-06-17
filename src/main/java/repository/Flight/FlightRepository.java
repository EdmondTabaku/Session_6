package repository.Flight;

import model.Flight;

import java.util.List;

public interface FlightRepository {
    public Flight save(Flight flight);

    public List<Flight> findAll();

    public Flight findById(int id);

    public void delete(int id);
}
