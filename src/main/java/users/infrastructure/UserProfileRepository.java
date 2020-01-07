package users.infrastructure;

import halpers.IRepository;
import users.domain.UserProfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public class UserProfileRepository implements IRepository<UserProfile> {

    private final Connection connection;

    public UserProfileRepository() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:sqlite:sample.db");
        this.connection = connection;
    }


    @Override
    public void insert(UserProfile userProfile) {
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(
                    String.format
                            (
                            "INSERT INTO userProfiles" +
                                    "(" +
                                    "firstName, " +
                                    "lastName, " +
                                    "jobTitle, " +
                                    "province, " +
                                    "postalCode, " +
                                    "country, " +
                                    "city, " +
                                    "address)" +
                                    "VALUES('%s', '%s', '%s', '%s', " +
                                    "'%s', '%s', '%s', '%s')",
                            userProfile.firstName,
                            userProfile.lastName,
                            userProfile.jobTitle,
                            userProfile.province,
                            userProfile.postalCode,
                            userProfile.country,
                            userProfile.city,
                            userProfile.address
                            )
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(UserProfile userProfile) {

    }

    @Override
    public void delete(String name) {

    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Optional getById(long id) {
        return Optional.empty();
    }
}
