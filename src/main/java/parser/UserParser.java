package parser;
import work.User;
public class UserParser {

    public static User stringToUser(String readLine) {
        String [] usersInfo = readLine.split(User.USER_SEPARATOR);

        Long userId = Long.parseLong(usersInfo[0]);
        String login = usersInfo[1];
        String password = usersInfo[2];

        return new User(userId, login, password);
    }
}
