package ru.manager;

import ru.ApplicationMain;
import ru.entity.OrderEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderEntityManager {
    public static List<OrderEntity> getAllRowsDorion() throws SQLException {
        //idOrder, description, title, type, imagePath
        try (Connection connection = ApplicationMain.getConnection()) {
            String query = "SELECT * FROM piter.order where type = 'Дорический';";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<OrderEntity> orderEntityList = new ArrayList<>();
            while (resultSet.next()) {
                orderEntityList.add(new OrderEntity(
                        resultSet.getInt("idOrder"),
                        resultSet.getString("description"),
                        resultSet.getString("title"),
                        resultSet.getString("type"),
                        resultSet.getString("imagePath")
                ));
            }
            return orderEntityList;
        }
    }
             //"Дорический Ионический Коринфский Тосканский Композитный"
             public static List<OrderEntity> getAllRowsIon() throws SQLException {
                 try (Connection connection = ApplicationMain.getConnection()) {
                     String query = "SELECT * FROM piter.order where type = 'Ионический';";
                     PreparedStatement statement = connection.prepareStatement(query);
                     ResultSet resultSet = statement.executeQuery();
                     List<OrderEntity> orderEntityList = new ArrayList<>();
                     while (resultSet.next()) {
                         orderEntityList.add(new OrderEntity(
                                 resultSet.getInt("idOrder"),
                                 resultSet.getString("description"),
                                 resultSet.getString("title"),
                                 resultSet.getString("type"),
                                 resultSet.getString("imagePath")
                         ));
                     }
                     return orderEntityList;
                 }
             }
    public static List<OrderEntity> getAllRowsKorinf() throws SQLException {
        try (Connection connection = ApplicationMain.getConnection()) {
            String query = "SELECT * FROM piter.order where type = 'Коринфский';";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<OrderEntity> orderEntityList = new ArrayList<>();
            while (resultSet.next()) {
                orderEntityList.add(new OrderEntity(
                        resultSet.getInt("idOrder"),
                        resultSet.getString("description"),
                        resultSet.getString("title"),
                        resultSet.getString("type"),
                        resultSet.getString("imagePath")
                ));
            }
            return orderEntityList;
        }
    }
    public static List<OrderEntity> getAllRowsTosk() throws SQLException {
        try (Connection connection = ApplicationMain.getConnection()) {
            String query = "SELECT * FROM piter.order where type = 'Тосканский';";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<OrderEntity> orderEntityList = new ArrayList<>();
            while (resultSet.next()) {
                orderEntityList.add(new OrderEntity(
                        resultSet.getInt("idOrder"),
                        resultSet.getString("description"),
                        resultSet.getString("title"),
                        resultSet.getString("type"),
                        resultSet.getString("imagePath")
                ));
            }
            return orderEntityList;
        }
    }
    public static List<OrderEntity> getAllRowsKompozitn() throws SQLException {
        try (Connection connection = ApplicationMain.getConnection()) {
            String query = "SELECT * FROM piter.order where type = 'Композитный';";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            List<OrderEntity> orderEntityList = new ArrayList<>();
            while (resultSet.next()) {
                orderEntityList.add(new OrderEntity(
                        resultSet.getInt("idOrder"),
                        resultSet.getString("description"),
                        resultSet.getString("title"),
                        resultSet.getString("type"),
                        resultSet.getString("imagePath")
                ));
            }
            return orderEntityList;
        }
    }
}
