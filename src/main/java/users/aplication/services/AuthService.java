package users.aplication.services;

import users.aplication.UserNotExistsException;
import users.domain.User;
import users.domain.UserProfile;
import users.infrastructure.UserProfileRepository;
import users.infrastructure.UserRepository;

import java.sql.SQLException;
import java.util.Map;

public class AuthService {
    private UserRepository userRepository;
    private UserProfileRepository userProfileRepository;
    private UserService userService;

    public AuthService() throws SQLException {
        this.userRepository = new UserRepository();
        this.userProfileRepository = new UserProfileRepository();
        this.userService = new UserService();
    }

    public void singUp(Map data) throws Exception {
        System.out.println("befor singUp");
        User user = User.fromJSON(data);
        System.out.println(user);

        if (!user.password.equals(user.confirmPassword)){
            throw new Exception("password and confirmPassword are not same");
        }
        UserProfile userProfile = UserProfile.fromJSON(data);
        userRepository.insert(user);
        userProfileRepository.insert(userProfile);
    }

    public void signIn (Map data) throws Exception {
        User user = this.userService.getUserByEmail((String)data.get("email"));
        if (user == null){
            throw new UserNotExistsException();
        }

        this.userService.ensureUserDataCorrect(
                user, (String) data.get("password")
        );
    }
}
