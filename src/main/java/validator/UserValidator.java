package validator;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import work.User;

import java.util.List;

public class UserValidator {

    List<User> users;
    private static UserValidator instance = null;
    private int MIN_LENGTH_PASSWORD = 5;
    private int MIN_LENGTH_LOGIN = 3;

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }


    private UserValidator() {


    }

    public boolean isValidate(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException, UserShortLengthPasswordException {

        if (passwordEnoughLength(user.getPassword()))
            throw new UserShortLengthLoginException("Password is too short!");

        if (loginEnoughLength(user.getLogin()))
            throw new UserShortLengthPasswordException("Login is too short!");

        if (loginIsExist(user.getLogin()))
            throw new UserLoginAlreadyExistException("Login is exist!");

        return true;
    }

    private boolean passwordEnoughLength(String password) {
        return password.length() >= MIN_LENGTH_PASSWORD;
    }

    private boolean loginEnoughLength(String login) {
        return login.length() >= MIN_LENGTH_LOGIN;
    }

    private boolean loginIsExist(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return true;
            }
                   }
        return false;

    }



}
