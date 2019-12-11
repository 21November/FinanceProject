package users.aplication;


public class UserNotExistsException extends Exception {
    public UserNotExistsException(){
        super("User not found!");
    }
}
