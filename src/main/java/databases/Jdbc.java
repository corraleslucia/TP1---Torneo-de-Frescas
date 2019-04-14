package databases;


import Tournament.Winner;
import models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static properties.DatabaseProperties.DATABASE_PROPERTIES;

public class Jdbc {

    private Connection connection;

    private Connection startConnection() {
        try {
            Class.forName(DATABASE_PROPERTIES.getJdbcDriver());
            connection = DriverManager.getConnection(DATABASE_PROPERTIES.getDbUrl(), DATABASE_PROPERTIES.getDbUser(), DATABASE_PROPERTIES.getDbPass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public void insertWinner(Winner winner) {
        try {
            connection = startConnection();
            String query = "INSERT into winners (name, age, weight, consumed_quantity, human_type) values (?,?,?,?,?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, winner.getWinner().getName());
            preparedStmt.setInt(2, winner.getWinner().getAge());
            preparedStmt.setInt(3, winner.getWinner().getWeight());
            preparedStmt.setDouble(4, winner.getConsumed_quantity());
            preparedStmt.setString(5, winner.getWinner().getClass().getSimpleName());

            preparedStmt.execute();

            preparedStmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Winner> getWinners() {
        List<Winner> winners = new ArrayList<>();
        connection = startConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT name, age, weight, consumed_quantity, human_type FROM winners";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Integer weight = rs.getInt("weight");
                Double consumedQuantity = rs.getDouble("consumed_quantity");
                String humanType = rs.getString("human_type");

                Winner winner = humanType.equals("Spartan")
                        ? new Winner(new Spartan(name, age, weight, new DrinkSpartanImp(), new PeeSpartanImp()), consumedQuantity)
                        : new Winner(new Viking(name, age, weight, new DrinkVikingImp(), new PeeVikingImp()), consumedQuantity);
                winners.add(winner);
            }
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return winners;
    }
}
