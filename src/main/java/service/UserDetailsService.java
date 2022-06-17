package service;

import dto.UserDetailsDto;
import model.User;
import dto.UserDto;
import model.UserDetails;
import repository.User.impl.UserRepositoryImpl;
import repository.UserDetails.UserDetailsRepository;
import repository.UserDetails.impl.UserDetailsRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsService {
    UserDetailsRepositoryImpl userDetailsRepository = new UserDetailsRepositoryImpl();

    public UserDetailsDto save(UserDetails userDetails) {
        UserDetails ud = userDetailsRepository.save(userDetails);
        UserDetailsDto userDetailsDto = new UserDetailsDto();
        userDetailsDto.setId(ud.getId());
        userDetailsDto.setFirstName(ud.getFirstName());
        userDetailsDto.setLastName(ud.getLastName());
        userDetailsDto.setEmail(ud.getEmail());
        userDetailsDto.setPhoneNumber(ud.getPhoneNumber());

        return userDetailsDto;
    }


    public List<UserDetailsDto> findAll() {
        List<UserDetails> userDetailsList = userDetailsRepository.findAll();
        List<UserDetailsDto> userDetailsDtoList = new ArrayList<>();

        for (UserDetails ud : userDetailsList){

            UserDetailsDto userDetailsDto = new UserDetailsDto();

            userDetailsDto.setId(ud.getId());
            userDetailsDto.setFirstName(ud.getFirstName());
            userDetailsDto.setLastName(ud.getLastName());
            userDetailsDto.setEmail(ud.getEmail());
            userDetailsDto.setPhoneNumber(ud.getPhoneNumber());

            userDetailsDtoList.add(userDetailsDto);
        }

        return userDetailsDtoList;
    }


    public UserDetailsDto findById(int id) {
        UserDetails ud = userDetailsRepository.findById(id);
        UserDetailsDto userDetailsDto = new UserDetailsDto();

        userDetailsDto.setId(ud.getId());
        userDetailsDto.setFirstName(ud.getFirstName());
        userDetailsDto.setLastName(ud.getLastName());
        userDetailsDto.setEmail(ud.getEmail());
        userDetailsDto.setPhoneNumber(ud.getPhoneNumber());

        return userDetailsDto;
    }


    public void delete(int id) {
        userDetailsRepository.delete(id);
    }
}
