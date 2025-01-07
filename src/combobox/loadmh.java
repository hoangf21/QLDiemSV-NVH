package combobox;

import ConnectUI.ConnectDB;
import java.sql.*;
import java.util.*;

public class loadmh {
    ConnectDB cn = new ConnectDB();
    Connection conn;
    String mk;
    String username;
    String malop;

    public loadmh(){
        
    }
    
    public loadmh(String makhoa, String user, String malop) {
        this.mk = makhoa;
        this.username = user;
        this.malop = malop;
    }
    
    public List<monhoc> getAllclasses(){
        try{
            String sql = "SELECT * FROM dbo.pcgiangday x JOIN dbo.monhoc y ON y.mamh = x.mamh\n" +
                         "WHERE magv = '"+username+"' AND malop='"+malop+"' AND x.matt = 'DGD'";
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
