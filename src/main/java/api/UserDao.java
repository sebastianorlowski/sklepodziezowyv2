package api;
import work.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {

    void saveUser(User user) throws IOException;
    List<User> saveUsers() throws IOException;
    List<User> getAllUsers() throws IOException;
    void getUserByLogin(String login) throws IOException;
    void getUserById(Long userId) throws IOException;
    void removeUserByLogin(String login) throws IOException;
    void removeUserById(Long id) throws IOException;
}
