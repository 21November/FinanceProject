package users.aplication.services.exceptions;

public class UserPasswordInvalidException extends Exception {
    public UserPasswordInvalidException(){
        super("Invalid password was entered!");
    }
}
