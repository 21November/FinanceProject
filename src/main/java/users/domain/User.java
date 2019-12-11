package users.domain;

import halpers.domain.Domain;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.Base64;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class User extends Domain {
    public UUID id;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String confirmPassword;


    public User(
            UUID id,
            String firstName,
            String lastName,
            String email,
            String password,
            String confirmPassword
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public static User fromJSON(Map map) {
        Base64.Encoder encoder = Base64.getEncoder();

        map.put(
                "password", encoder.encodeToString(
                    ((String)map.get("password")).getBytes())
        );
        map.put(
                "confirmPassword", encoder.encodeToString(
                    ((String)map.get("confirmPassword")).getBytes())
        );


        return new User(
                UUID.randomUUID(),
                (String)map.get("firstName"),
                (String)map.get("lastName"),
                (String) map.get("email"),
                (String) map.get("password"),
                (String) map.get("confirmPassword")

        );
    }

    public static User fromRowTable(Map<String, String> map){
        return new User(
                UUID.fromString(map.get("id")),
                map.get("firstName"),
                map.get("lastName"),
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
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                confirmPassword.equals(user.confirmPassword
                );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, firstName, lastName, email, password, confirmPassword
        );
    }


}
