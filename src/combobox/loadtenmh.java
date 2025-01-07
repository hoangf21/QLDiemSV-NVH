package combobox;

import ConnectUI.ConnectDB;
import java.sql.*;
import java.util.*;

public class loadtenmh {
    ConnectDB cn = new ConnectDB();
    Connection conn;
    String khoa;
    String masv;
    String makhoi;

    public loadtenmh(){
        
    }
    
    public loadtenmh(String makhoa, String user, String khoi) {
        this.khoa = makhoa;
        this.masv = user;
        this.makhoi = khoi;
    }
    
    public List<monhoc> getAllclasses(){
        try{
            String sql = "SELECT * FROM dbo.monhoc" +
                         " WHERE makhoa ='" + khoa + "'" +
                         " AND makhoi = '" + makhoi + "'" +
                         " AND mamh NOT IN(SELECT mamh FROM dbo.ketqua WHERE masv='"+masv+"' GROUP BY mamh)";
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
