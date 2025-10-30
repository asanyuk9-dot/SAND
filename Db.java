import java.sql.*;

class Db {
    String dbUrl = "jdbc:mysql://localhost:3306/myGame?useSSL=true&serverTimezone=UTC";
    String user = "root";
    String password = "fG45q1209HKlj.";  // замініть xxx на ваш пароль
    Connection con;

    public Db() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(dbUrl, user, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void close() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isUserExists(String username){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM users WHERE username='"+username+"';");
            while (rs.next())
                if (rs.getInt(1) == 1) return true;
                else return false;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean isUserPasswordCorrect(String username, String password) {
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT count(*) FROM users WHERE username='" + username + "' AND password='" + password + "';");
        while (rs.next())
            return rs.getInt(1) == 1;
    } catch (Exception e) {
        System.out.println(e);
    }
    return false;
}
}
