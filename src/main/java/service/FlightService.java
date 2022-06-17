package service;

import dto.FlightDto;
import dto.UserDto;
import model.Flight;
import model.User;
import repository.Flight.impl.FlightRepositoryImpl;
import repository.User.impl.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class FlightService {
    FlightRepositoryImpl flightRepository = new FlightRepositoryImpl();


    public FlightDto save(Flight flight) {
        Flight f = flightRepository.save(flight);
        FlightDto flightDto = new FlightDto();

        flightDto.setId(f.getId());
        flightDto.setOrigin(f.getOrigin());
        flightDto.setDestination(f.getDestination());
        flightDto.setAirline(f.getAirline());
        flightDto.setFlightNumber(f.getFlightNumber());
        flightDto.setDepartureDate(f.getDepartureDate());
        flightDto.setArrivalDate(f.getArrivalDate());
        flightDto.setStatus(f.getStatus());

        return flightDto;
    }


    public List<FlightDto> findAll() {
        List<Flight> flightList = flightRepository.findAll();
        List<FlightDto> flightDtoList = new ArrayList<>();
        for (Flight f : flightList){
            FlightDto flightDto = new FlightDto();

            flightDto.setId(f.getId());
            flightDto.setOrigin(f.getOrigin());
            flightDto.setDestination(f.getDestination());
            flightDto.setAirline(f.getAirline());
            flightDto.setFlightNumber(f.getFlightNumber());
            flightDto.setDepartureDate(f.getDepartureDate());
            flightDto.setArrivalDate(f.getArrivalDate());
            flightDto.setStatus(f.getStatus());

            flightDtoList.add(flightDto);
        }

        return flightDtoList;
    }


    public FlightDto findById(int id) {
        Flight f = flightRepository.findById(id);
        FlightDto flightDto = new FlightDto();

        flightDto.setId(f.getId());
        flightDto.setOrigin(f.getOrigin());
        flightDto.setDestination(f.getDestination());
        flightDto.setAirline(f.getAirline());
        flightDto.setFlightNumber(f.getFlightNumber());
        flightDto.setDepartureDate(f.getDepartureDate());
        flightDto.setArrivalDate(f.getArrivalDate());
        flightDto.setStatus(f.getStatus());

        return flightDto;
    }


    public void delete(int id) {
        flightRepository.delete(id);
    }
}
