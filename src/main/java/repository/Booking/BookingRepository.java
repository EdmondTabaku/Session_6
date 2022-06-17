package repository.Booking;

import model.Booking;

import java.util.List;

public interface BookingRepository {
    public Booking save(Booking booking);

    public List<Booking> findAll();

    public Booking findById(int id);

    public void delete(int id);
}
