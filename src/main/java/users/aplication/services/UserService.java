package users.aplication.services;

import users.aplication.services.exceptions.UserPasswordInvalidException;
import users.domain.User;
import users.infrastructure.UserRepository;

import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class UserService {
    private UserRepository repository;

    public UserService() throws SQLException {
        this.repository = new UserRepository();
    }

    public void addUser(Map map) throws Exception {
        User user = User.fromJSON(map);
        if (!user.password.equals(user.confirmPassword)){
            throw new Exception("password and confirmPassword are not same");
        }
        repository.insert(user);
    }

    public List<User> getUsers() {
        return this.repository.getAll();
    }

    public User getUserByEmail(String email) {

        return this.repository.getOneByEmail(email);
    }

    public void ensureUserDataCorrect(User user, String password)
            throws Exception{

        String encodedPassword =
                Base64.getEncoder().encodeToString(password.getBytes());
        if (!user.password.equals(encodedPassword)){
            throw new UserPasswordInvalidException();
        }
    }
}
