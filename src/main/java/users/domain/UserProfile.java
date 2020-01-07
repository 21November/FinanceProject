package users.domain;

import halpers.domain.Domain;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class UserProfile extends Domain {
    public UserProfileId id;
    public String firstName;
    public String lastName;
    public String jobTitle;
    public String province;
    public String postalCode;
    public String country;
    public String city;
    public String address;
    public UserId userId;

    private UserProfile(
            UserProfileId id,
            String firstName,
            String lastName,
            String jobTitle,
            String province,
            String postalCode,
            String country,
            String city,
            String address,
            UserId userId
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
        this.city = city;
        this.address = address;
        this.userId = userId;
    }


    public static UserProfile fromJSON(Map map) {
        return new UserProfile(
                new UserProfileId(),
                (String)map.get("firstName"),
                (String)map.get("lastName"),
                null,
                null,
                null,
                null,
                null,
                null,
        (UserId)map.get("userId")
        );
    }

    public static UserProfile fromRowTable(Map<String, String> map){
        return new UserProfile(
                new UserProfileId(map.get("id")),
                map.get("firstName"),
                map.get("lastName"),
                map.get("jobTitle"),
                map.get("province"),
                map.get("postCode"),
                map.get("country"),
                map.get("city"),
                map.get("address"),
                new UserId (map.get("userId"))

        );
    }


}
