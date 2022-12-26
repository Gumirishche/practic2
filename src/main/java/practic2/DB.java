package practic2;

import practic3.Human;
import practic4.First;
import practic4.Second;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    public void createSecond(String firstName, String lastName) throws SQLException {
        String sql = "INSERT INTO second(first_name, last_name) VALUES(?,?)";

        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").prepareStatement(sql);
        prSt.setString(1, firstName);
        prSt.setString(2, lastName);
        System.out.println(prSt);

        prSt.executeUpdate();
    }

    public void createFirst(String idHuman, String salary, String gender) throws SQLException {
        String sql = "INSERT INTO first(id_human, salary,gender) VALUES(?,?,?)";
        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").prepareStatement(sql);
        prSt.setInt(1, Integer.parseInt(idHuman));
        prSt.setInt(2, Integer.parseInt(salary));
        prSt.setString(3, gender);
        System.out.println(prSt);

        prSt.executeUpdate();
    }

    public void deleteSecond(int id) throws SQLException {
        String sql = "DELETE FROM second WHERE id = ?";

        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").prepareStatement(sql);
        prSt.setInt(1, id);
        System.out.println(prSt);

        prSt.executeUpdate();
    }

    public void deleteFirst(int id) throws SQLException {
        String sql = "DELETE FROM first WHERE id = ?";

        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").prepareStatement(sql);
        prSt.setInt(1, id);
        System.out.println(prSt);

        prSt.executeUpdate();
    }

    public void getAll() throws SQLException {
        String sql = "SELECT second.id, first_name, last_name, salary, gender FROM second LEFT OUTER JOIN first ON second.id=first.id_human;";
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            System.out.println("id: " + res.getString("id") + "  " + "firstName: " + res.getString("first_name") + "  lastName: " + res.getString("last_name") + "  salary:" + res.getString("salary") + "  gender:" + res.getString("gender"));
        }
    }

    public ArrayList<Human> getAll2() throws SQLException, ClassNotFoundException {
        ArrayList<Human> humans = new ArrayList<>();
        String sql = "SELECT second.id, first_name, last_name, salary, gender FROM second LEFT OUTER JOIN first ON second.id=first.id_human;";
        Class.forName("org.postgresql.Driver");
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            humans.add(new Human(res.getString("id"), res.getString("first_name"), res.getString("last_name"), res.getString("salary"), res.getString("gender")));
            System.out.println("id: " + res.getString("id") + "  " + "firstName: " + res.getString("first_name") + "  lastName: " + res.getString("last_name") + "  salary:" + res.getString("salary") + "  gender:" + res.getString("gender"));
        }
        return humans;
    }

    public void getSecond() throws SQLException {
        String sql = "SELECT * FROM second";
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            System.out.println("id: " + res.getString("id") + "  " + "firstName: " + res.getString("first_name") + "  lastName: " + res.getString("last_name"));
        }
    }

    public ArrayList<Second> getSecond2() throws SQLException, ClassNotFoundException {
        ArrayList<Second> seconds = new ArrayList<>();
        String sql = "SELECT * FROM second";
        Class.forName("org.postgresql.Driver");
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            seconds.add(new Second(res.getString("id"), res.getString("first_name"), res.getString("last_name")));
            //System.out.println("id: " + res.getString("id") + "  " + "firstName: " + res.getString("first_name")+"  lastName: "+ res.getString("last_name"));
        }
        return seconds;
    }

    public ArrayList<First> getFirst() throws SQLException, ClassNotFoundException {
        ArrayList<First> firsts = new ArrayList<>();
        String sql = "SELECT * FROM first";
        Class.forName("org.postgresql.Driver");
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            firsts.add(new First(res.getString("id"), res.getString("id_human"), res.getString("salary"), res.getString("gender")));
            //System.out.println("id: " + res.getString("id") + "  " + "firstName: " + res.getString("first_name")+"  lastName: "+ res.getString("last_name"));
        }
        return firsts;
    }

    public Second findSecond(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM second where id=" + id;
        Class.forName("org.postgresql.Driver");
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            return new Second(res.getString("id"), res.getString("first_name"), res.getString("last_name"));
        }
        return null;
    }

    public First findFirst(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM first where id=" + id;
        Class.forName("org.postgresql.Driver");
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()){
        return new First(res.getString("id"), res.getString("id_human"), res.getString("salary"), res.getString("gender"));
    }
    return null;
    }
}