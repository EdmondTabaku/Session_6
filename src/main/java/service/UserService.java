package service;

import model.User;
import dto.UserDto;
import repository.User.impl.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserRepositoryImpl userRepository = new UserRepositoryImpl();

    public UserDto save(User user) {
        User u = userRepository.save(user);
        UserDto userDto = new UserDto();
        userDto.setId(u.getId());
        userDto.setUsername(u.getUsername());
        userDto.setPassword(u.getPassword());
        userDto.setRole(u.getRole());

        return userDto;
    }


    public List<UserDto> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User u : userList){
            UserDto userDto = new UserDto();
            userDto.setId(u.getId());
            userDto.setUsername(u.getUsername());
            userDto.setPassword(u.getPassword());
            userDto.setRole(u.getRole());

            userDtoList.add(userDto);
        }

        return userDtoList;
    }


    public UserDto findById(int id) {
        User u = userRepository.findById(id);
        UserDto userDto = new UserDto();
        userDto.setId(u.getId());
        userDto.setUsername(u.getUsername());
        userDto.setPassword(u.getPassword());
        userDto.setRole(u.getRole());

        return userDto;
    }


    public void delete(int id) {
        userRepository.delete(id);
    }
}
