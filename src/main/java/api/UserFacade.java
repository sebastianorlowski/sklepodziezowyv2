package api;
import work.User;

public interface UserFacade {
    boolean registerUser(User user);
    boolean loginUser(String login, String password);
}
