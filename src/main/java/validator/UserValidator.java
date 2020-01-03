package validator;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import work.User;
import java.util.List;

public class UserValidator {

    List<User> users;
    private static UserValidator instance = null;

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }


    public UserValidator() {


    }

    public boolean isValidate(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException, UserShortLengthPasswordException {
        if (user.getLogin().length() < 4) {
            throw new UserShortLengthLoginException("Login is too short!");
        }
        if (user.getPassword().length() < 6) {
            throw new UserShortLengthPasswordException("Password is too short!");
        }

        if (user.getLogin().equals(users)) {
            throw new UserLoginAlreadyExistException("Login is exist!");
        }

    }

}
