package dao;

import api.UserDao;
import utils.FileUtils;
import work.User;

import java.io.*;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private String fileName = "User.txt";


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







    }

}
