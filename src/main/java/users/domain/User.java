package users.domain;

import halpers.domain.Domain;
//import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.Base64;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class User extends Domain {
    public UserId id;
    public String email;
    public String password;
    public String confirmPassword;


    private User(
            UserId id,
            String email,
            String password,
            String confirmPassword
    ) {
        System.out.println("constructor User");

        this.id = id;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public static User fromJSON(Map map) {
        Base64.Encoder encoder = Base64.getEncoder();
        System.out.println("before put functional 1");
        map.put(
                "password", encoder.encodeToString(
                    ((String)map.get("password")).getBytes())
        );
        System.out.println("after put 1");
        map.put(
                "confirmPassword", encoder.encodeToString(
                    ((String)map.get("confirmPassword")).getBytes())
        );

        System.out.println("fromJSON");


        return new User(
                new UserId(),
                (String) map.get("email"),
                (String) map.get("password"),
                (String) map.get("confirmPassword")

        );
    }

    public static User fromRowTable(Map<String, String> map){
        return new User(
                new UserId(map.get("id")),
                map.get("email"),
                map.get("password"),
                map.get("password"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                confirmPassword.equals(user.confirmPassword
                );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, email, password, confirmPassword
        );
    }


}
