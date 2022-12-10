import java.sql.*;

public class DB {
    public void createSecond(String firstName, String lastName) throws SQLException {
        String sql = "INSERT INTO second(first_name, last_name) VALUES(?,?)";

        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").prepareStatement(sql);
        prSt.setString(1, firstName);
        prSt.setString(2, lastName);
        System.out.println(prSt);

        prSt.executeUpdate();
    }

    public void createFirst(String idHuman,String salary, String gender) throws SQLException {
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
            System.out.println("id: " + res.getString("id") + "  " + "firstName: " + res.getString("first_name")+"  lastName: "+ res.getString("last_name")+"  salary:"+ res.getString("salary")+"  gender:"+ res.getString("gender"));
        }
    }
    public void getSecond() throws SQLException{
        String sql = "SELECT * FROM second";
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/practic", "postgres", "123").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            System.out.println("id: " + res.getString("id") + "  " + "firstName: " + res.getString("first_name")+"  lastName: "+ res.getString("last_name"));
        }
    }
}