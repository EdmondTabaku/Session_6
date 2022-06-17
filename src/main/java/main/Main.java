package main;

import dto.UserDto;
import model.User;
import repository.User.impl.UserRepositoryImpl;
import service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] options = {"1- Save User",
                "2- Find All Users",
                "3- Find User by Id",
                "4- Delete User",
                "5- Exit",

        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=5){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1: option1(); break;
                    case 2: option2(); break;
                    case 3: option3(); break;
                    case 4: option4(); break;
                    case 5: option = 5; break;
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }

    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    // Options
    private static void option1() {
        User user = new User();
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Id of the user you want to insert or update: ");
        int id = scanner.nextInt();
        user.setId(id);
        System.out.println("Enter the username of the user you want to insert or update: ");
        String username = scanner.next();
        user.setUsername(username);

        System.out.println("Enter the password of the user you want to insert or update: ");
        String password = scanner.next();
        user.setPassword(password);

        System.out.println("Enter the role of the user you want to insert or update: ");
        String role = scanner.next();
        user.setRole(role);

        UserDto userDto = userService.save(user);
        System.out.println("Saved user with username: " + userDto.getUsername());
    }
    private static void option2() {

        UserService userService = new UserService();
        List<UserDto> userDtoList = userService.findAll();

        for (UserDto user : userDtoList){
            System.out.println("Username: " + user.getUsername() + "  ||  Role: " + user.getRole());
        }

    }
    private static void option3() {

        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        int id;
        System.out.println("Enter the Id of the user you want to find: ");
        id = scanner.nextInt();
        UserDto user = userService.findById(id);
        System.out.println("Username: " + user.getUsername() + "  ||  Role: " + user.getRole());
    }
    private static void option4() {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        int id;
        System.out.println("Enter the Id of the user you want to delete: ");
        id = scanner.nextInt();
        userService.delete(id);
    }
}
