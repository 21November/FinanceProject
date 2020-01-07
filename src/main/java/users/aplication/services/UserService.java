package users.aplication.services;

import users.aplication.services.exceptions.UserPasswordInvalidException;
import users.domain.User;
import users.domain.UserProfile;
import users.infrastructure.UserProfileRepository;
import users.infrastructure.UserRepository;

import java.sql.SQLException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class UserService {
    private UserRepository userRepository;
    private UserProfileRepository userProfileRepository;

    public UserService() throws SQLException {
        this.userRepository = new UserRepository();
        this.userProfileRepository = new UserProfileRepository();
    }



    public List<User> getUsers() {
        return this.userRepository.getAll();
    }

    public User getUserByEmail(String email) {

        return this.userRepository.getOneByEmail(email);
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
