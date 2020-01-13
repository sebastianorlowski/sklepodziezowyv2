package api;

import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import work.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> getAllUsers() throws IOException;
    void addUser(User user) throws IOException, UserLoginAlreadyExistException, UserShortLengthLoginException, UserShortLengthPasswordException;
    void removeUserById(Long userId) throws IOException;


}
