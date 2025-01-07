package combobox;

import ConnectUI.ConnectDB;
import java.sql.*;
import java.util.*;

public class loadtenmh1 {
    ConnectDB cn = new ConnectDB();
    Connection conn;
    String khoa;
    String lop;
    String makhoi;

    public loadtenmh1(){
        
    }
    
    public loadtenmh1(String makhoa, String khoi, String lop) {
        this.khoa = makhoa;
        this.lop = lop;
        this.makhoi = khoi;
    }
    
    public List<monhoc> getAllclasses(){
        try{
            String sql = "SELECT * FROM dbo.monhoc" +
                         " WHERE makhoa ='" + khoa + "'" +
                         " AND makhoi = '" + makhoi + "'" +
                         " AND mamh NOT IN(SELECT mamh FROM dbo.pcgiangday WHERE malop='"+lop+"' GROUP BY mamh)";
            conn = cn.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<monhoc> list = new ArrayList<>();
            while(rs.next()){
                list.add(new monhoc(rs.getString("mamh"),rs.getString("tenmh"), rs.getInt("sotin")));
            }
            return list;
        }catch(Exception e){
        }
        return null;
    }
}
