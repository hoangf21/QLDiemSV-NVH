package combobox;

import ConnectUI.ConnectDB;
import java.sql.*;
import java.util.*;

public class loadkhoitc {
    ConnectDB cn = new ConnectDB();
    Connection conn;
    public List<khoitc> getAllclasses(){
        try{
            String sql = "Select * from nhommonhoc";
            conn = cn.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<khoitc> list = new ArrayList<>();
            while(rs.next()){
                list.add(new khoitc(rs.getString("makhoi"),rs.getString("tenkhoi")));
            }
            return list;
        }catch(Exception e){
            
        }
        return null;
    }
}
