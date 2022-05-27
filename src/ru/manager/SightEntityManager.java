package ru.manager;

import ru.ApplicationMain;
import ru.entity.SightEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SightEntityManager {
    public static List<SightEntity> getAllRows() throws SQLException {

        try (Connection connection = ApplicationMain.getConnection()) {
            String query = "SELECT * FROM sight;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<SightEntity> movieList = new ArrayList<>();
            while (resultSet.next()) {
                movieList.add(new SightEntity(
                        resultSet.getInt("idsight"),
                        resultSet.getString("description"),
                        resultSet.getString("adress"),
                        resultSet.getString("phone"),
                        resultSet.getString("webSite"),
                        resultSet.getString("imagePath"),
                        resultSet.getString("title")
                ));
            }
            return movieList;
        }
    }

    public static List<SightEntity> getAllRowsWithLimits(int startLimit, int endLimit) throws SQLException {
        try (Connection connection = ApplicationMain.getConnection()) {
            String query = "SELECT * FROM sight WHERE idsight =?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, startLimit);
            statement.setInt(2, endLimit);
            ResultSet resultSet = statement.executeQuery();
            List<SightEntity> movieList = new ArrayList<>();
            while (resultSet.next()) {
                movieList.add(new SightEntity(
                        // //idsight, description, adress, phone, webSite, imagePath
                        resultSet.getInt("idsight"),
                        resultSet.getString("description"),
                        resultSet.getString("adress"),
                        resultSet.getString("phone"),
                        resultSet.getString("webSite"),
                        resultSet.getString("imagePath"),
                        resultSet.getString("title")
                ));
            }
            return movieList;
        }
    }
}
