package ru.manager;

import ru.ApplicationMain;
import ru.entity.ArchEntity;
import ru.entity.SightEntity;
import ru.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArchEntityManager {
  public static List<ArchEntity> getAllRowsAttik() throws SQLException {
      //idArchitecture, title, description, type, imagePath
      try (Connection connection = ApplicationMain.getConnection()) {
          String query = "SELECT * FROM architecture WHERE type='Аттик';";
          PreparedStatement statement = connection.prepareStatement(query);
          ResultSet resultSet = statement.executeQuery();
          List<ArchEntity> archEntityList = new ArrayList<>();
          while (resultSet.next()) {
              archEntityList.add(new ArchEntity(
                      resultSet.getInt("idArchitecture"),
                      resultSet.getString("title"),
                      resultSet.getString("description"),
                      resultSet.getString("type"),
                      resultSet.getString("imagePath")
              ));
          }
          return archEntityList;
      }
  }
    public static List<ArchEntity> getAllRowsPortik() throws SQLException {
        //idArchitecture, title, description, type, imagePath
        try (Connection connection = ApplicationMain.getConnection()) {
            String query = "SELECT * FROM architecture WHERE type='Портик';";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<ArchEntity> archEntityList = new ArrayList<>();
            while (resultSet.next()) {
                archEntityList.add(new ArchEntity(
                        resultSet.getInt("idArchitecture"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("type"),
                        resultSet.getString("imagePath")
                ));
            }
            return archEntityList;
        }
    }

    public static List<ArchEntity> getAllRowsColumn() throws SQLException {
        //idArchitecture, title, description, type, imagePath
        try (Connection connection = ApplicationMain.getConnection()) {
            String query = "SELECT * FROM architecture WHERE type='Колонна';";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<ArchEntity> archEntityList = new ArrayList<>();
            while (resultSet.next()) {
                archEntityList.add(new ArchEntity(
                        resultSet.getInt("idArchitecture"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("type"),
                        resultSet.getString("imagePath")
                ));
            }
            return archEntityList;
        }
    }
    public static List<ArchEntity> getAllRowsGods() throws SQLException {
        //idArchitecture, title, description, type, imagePath
        try (Connection connection = ApplicationMain.getConnection()) {
            String query = "SELECT * FROM architecture WHERE type='Статуя бога';";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<ArchEntity> archEntityList = new ArrayList<>();
            while (resultSet.next()) {
                archEntityList.add(new ArchEntity(
                        resultSet.getInt("idArchitecture"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("type"),
                        resultSet.getString("imagePath")
                ));
            }
            return archEntityList;
        }
    }
    public static List<ArchEntity> getAllRowsHeroes() throws SQLException {
        //idArchitecture, title, description, type, imagePath
        try (Connection connection = ApplicationMain.getConnection()) {
            String query = "SELECT * FROM architecture WHERE type='Статуя героя';";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<ArchEntity> archEntityList = new ArrayList<>();
            while (resultSet.next()) {
                archEntityList.add(new ArchEntity(
                        resultSet.getInt("idArchitecture"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("type"),
                        resultSet.getString("imagePath")
                ));
            }
            return archEntityList;
        }
    }
}
