package service;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import exception.UserLoginAlreadyExistException;
import validator.UserValidator;
import work.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserServiceImpl instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() {


    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }


    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }


    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }

    public User getUserByLogin(String login) {
        List<User> users = null;

        try {
            users = getAllUsers();
            for (User user : users
            ) {
                boolean isFoundUser = user.getLogin().equals(login);
                if (isFoundUser) {
                    return user;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

        public User getUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (userId.equals(user.getId())) {
                return user;
            }
        }
        return null;
    }

    public boolean isLoginAlreadyExist(String login) throws IOException {
        User user = getUserByLogin(login);
        return user != null;
    }

    public boolean addUser(User user) {
        try {
            if (isLoginAlreadyExist(user.getLogin())) {
                throw new UserLoginAlreadyExistException();
            }

            else if (userValidator.isValidate(user)) {
                userDao.saveUser(user);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return false;

    }


     public boolean isCorrectLoginAndPassword(String login, String password) {

        User foundUser = getUserByLogin(login);
        if (foundUser == null) {
            return false;
     }


            boolean isCorrectLogin = foundUser.getLogin().equals(login);
            boolean isCorrectPassword = foundUser.getPassword().equals(password);
            return isCorrectLogin && isCorrectPassword;
        }
    }


    /** public boolean isCorrectLoginAndPassword(String login, String password) {
        if(userValidator.login)

        }
     **/






