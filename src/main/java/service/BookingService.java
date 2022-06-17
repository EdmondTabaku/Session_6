package service;

import dto.BookingDto;
import dto.UserDto;
import model.Booking;
import model.User;
import repository.Booking.impl.BookingRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    BookingRepositoryImpl bookingRepository = new BookingRepositoryImpl();

    public BookingDto save(Booking booking) {
        Booking b = bookingRepository.save(booking);
        BookingDto bookingDto = new BookingDto();

        bookingDto.setId(b.getId());
        bookingDto.setBookingDate(b.getBookingDate());
        bookingDto.setStatus(b.getStatus());

        return bookingDto;
    }


    public List<BookingDto> findAll() {
        List<Booking> bookingList = bookingRepository.findAll();
        List<BookingDto> bookingDtoList = new ArrayList<>();

        for (Booking b : bookingList){
            BookingDto bookingDto = new BookingDto();

            bookingDto.setId(b.getId());
            bookingDto.setBookingDate(b.getBookingDate());
            bookingDto.setStatus(b.getStatus());

            bookingDtoList.add(bookingDto);
        }

        return bookingDtoList;
    }


    public BookingDto findById(int id) {
        Booking b = bookingRepository.findById(id);
        BookingDto bookingDto = new BookingDto();

        bookingDto.setId(b.getId());
        bookingDto.setBookingDate(b.getBookingDate());
        bookingDto.setStatus(b.getStatus());

        return bookingDto;
    }


    public void delete(int id) {
        bookingRepository.delete(id);
    }
}
