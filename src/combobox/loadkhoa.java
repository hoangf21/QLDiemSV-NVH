package combobox;

import ConnectUI.ConnectDB;
import java.sql.*;
import java.util.*;

public class loadkhoa {
    ConnectDB cn = new ConnectDB();
    Connection conn;
    public List<khoa> getAllclasses(){
        try{
            String sql = "Select * from khoa";
            conn = cn.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<khoa> list = new ArrayList<>();
            while(rs.next()){
                list.add(new khoa(rs.getString("makhoa"),rs.getString("tenkhoa")));
            }
            return list;
        }catch(Exception e){
            
        }
        return null;
    }
}
