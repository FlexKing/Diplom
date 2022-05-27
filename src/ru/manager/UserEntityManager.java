package ru.manager;

import ru.ApplicationMain;
import ru.entity.UserEntity;

import java.sql.*;

public class UserEntityManager {
    public static void addRow(UserEntity userEntity) throws SQLException {
        try (Connection connection = ApplicationMain.getConnection()) {
            //id_user, email, password, name
            String query = "INSERT INTO user (email, name, password) VALUES (?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userEntity.getEmail());
            statement.setString(2, userEntity.getName());
            statement.setString(3, userEntity.getPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                userEntity.setId(resultSet.getInt(1));
            }
        }
    }

    public static UserEntity getRowByEmail(String email) throws SQLException {
        try (Connection connection = ApplicationMain.getConnection()) {
            String query = "SELECT * FROM user WHERE email = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new UserEntity(
                        resultSet.getInt("id_user"),
                        resultSet.getString("name"),
                        resultSet.getString("password")
                );
            } else {
                return null;
            }
        }
    }
}
