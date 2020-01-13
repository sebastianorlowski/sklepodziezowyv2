package dao;

import api.UserDao;
import parser.UserParser;
import utils.FileUtils;
import work.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String fileName = "Users.data";

    private static UserDaoImpl instance = null;

    private UserDaoImpl() {
        try {
            FileUtils.createNewFile(fileName);
        }
        catch (IOException e) {
            System.out.println("Error with file path!");
        }
        System.exit(-1);
    }

    public static UserDaoImpl getInstance() {
        if(instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }


    public void saveUser(User user) throws IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    public void saveUsers(List<User> users) throws IOException {
        FileUtils.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (User user : users) {
            printWriter.write(user.toString() + "\n");
        }

        printWriter.close();

    }

    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String readLine = bufferedReader.readLine();
        while (readLine != null) {
            User user = UserParser.stringToUser(readLine);
            if(user != null) {
                users.add(user);
            }
        }
        return users;
    }

    public User getUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (login.equals(user.getLogin())) {
                return user;
            }
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


    public void removeUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (login.equals(user.getLogin())) {
                users.remove(user);
            } else {
                return;
            }
        }
    }

    public void removeUserById(Long id) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (id == user.getId()) {
                users.remove(user);
            } else {
                return;
            }
        }
    }

}
