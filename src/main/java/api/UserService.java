package api;

import work.User;

import java.io.IOException;
import java.util.List;

public interface UserService {


    boolean addUser(User user);
    List<User> getAllUsers() throws IOException;
    void removeUserById(Long userId) throws IOException;

    User getUserById(Long userId) throws IOException;
    User getUserByLogin(String login) throws IOException;

    boolean isCorrectLoginAndPassword(String login, String password);


}
