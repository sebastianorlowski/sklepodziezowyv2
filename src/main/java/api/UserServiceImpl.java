package api;

import work.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<User>();
    }

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUserById(Long userId) {
        for(int i=0;i<users.size();i++) {
            // Wyciągnięcie i-tego usera z lista
            User userFromList = users.get(i);
            // Jeżeli id usera jest równe z listy to usuń
            if (userFromList.getId() == userId) {
                users.remove(i);
                break;
            }
        }

    }


}
