package ConnectUI;

import java.sql.*;

public class ConnectDB {
    public Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QLDiemSV";
            String user = "sa";
            String pwd = "sa";
            conn = DriverManager.getConnection(url,user,pwd);
            if(conn!=null)
                System.out.println("Kết nối thành công!");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return conn;
    }
}
