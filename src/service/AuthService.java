package service;
import entity.User;
import static db.DataSource.*;

public class AuthService {
    public User signIn(String email, String password){

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;

    }
}
