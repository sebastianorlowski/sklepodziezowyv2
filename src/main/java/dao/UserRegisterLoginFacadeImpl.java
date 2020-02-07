package dao;

import api.UserFacade;
import api.UserService;
import service.UserServiceImpl;
import validator.UserValidator;
import work.User;

import java.io.IOException;

public class UserRegisterLoginFacadeImpl implements UserFacade {

    private UserService userService = UserServiceImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();


    private static UserRegisterLoginFacadeImpl instance = null;

    public static UserRegisterLoginFacadeImpl getInstance() {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    public boolean registerUser(User user) {
        return userService.addUser(user);

    }

    public boolean loginUser(String login, String password) {
        if (userService.isCorrectLoginAndPassword(login, password)) {
            return true;
        }
        return false;
    }
}
