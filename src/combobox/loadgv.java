package combobox;

import ConnectUI.ConnectDB;
import java.sql.*;
import java.util.*;

public class loadgv {
    ConnectDB cn = new ConnectDB();
    Connection conn;

    public loadgv() {
    }

    public List<giangvien> getAllclasses(){
        try{
            String sql = "Select * from giangvien";
            conn = cn.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<giangvien> list = new ArrayList<>();
            while(rs.next()){
                list.add(new giangvien(rs.getString("magv"),rs.getString("hoten")));
            }
            return list;
        }catch(Exception e){
            
        }
        return null;
    }
}
