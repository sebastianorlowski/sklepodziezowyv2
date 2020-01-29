package api;
import work.User;

public interface UserRegisterLoginFacade {
    boolean registerUser(User user);
    boolean loginUser(String login, String password);
}
