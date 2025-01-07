package PanelUser;

import ConnectUI.*;
import Login.Login;
import Transitions.TransitionsForm;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Home extends TransitionsForm {
    
    ConnectDB cn = new ConnectDB();
    Connection conn;
    ResultSet rs;
    byte[] anhSV;
    String username;
    String quyen;
    int chk;
    
    public Home(String user, String quyen1) {
        this.username = user;
        this.quyen = quyen1;
        initComponents();
        if(quyen.equals("SV"))
            loadSV();
        else if(quyen.equals("GV"))
            loadGV();
        loadquyen();
    }
    
    public void loadSV() {
        conn = cn.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement("Select * from sinhvien where masv=?");
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNguoiDung.setText(rs.getString("hoten"));
                Blob blob = rs.getBlob("anh");
                anhSV = blob.getBytes(1, (int) blob.length());
                Image img = CircleImage.createImageFromByteArray(anhSV, "jpg");
                txtImage.setIcon(new ImageIcon(img));                
            }
            conn.close();
        } catch (Exception e) {
        }
    }
    
    public void loadGV() {
        conn = cn.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement("Select * from giangvien where magv=?");
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNguoiDung.setText(rs.getString("hoten"));
                Blob blob = rs.getBlob("anh");
                anhSV = blob.getBytes(1, (int) blob.length());
                Image img = CircleImage.createImageFromByteArray(anhSV, "jpg");
                txtImage.setIcon(new ImageIcon(img));                
            }
            conn.close();
        } catch (Exception e) {
        }
    }
    
    public void loadquyen() {
        try {
            conn = cn.getConnection();
            PreparedStatement pst = conn.prepareStatement("Select * from quyen where maquyen=?");
            pst.setString(1, quyen);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtQuyen.setText(rs.getString("tenquyen"));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public Home() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transitionsForm1 = new Transitions.TransitionsForm();
        txtQuyen = new javax.swing.JLabel();
        txtNguoiDung = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtImage = new ConnectUI.CircleImage();

        setMinimumSize(new java.awt.Dimension(1005, 540));
        setPreferredSize(new java.awt.Dimension(1005, 540));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        transitionsForm1.setPreferredSize(new java.awt.Dimension(1005, 540));
        transitionsForm1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtQuyen.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtQuyen.setForeground(new java.awt.Color(255, 102, 102));
        txtQuyen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtQuyen.setText("QUYỀN ");
        transitionsForm1.add(txtQuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 160, -1));

        txtNguoiDung.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        txtNguoiDung.setForeground(new java.awt.Color(51, 153, 255));
        txtNguoiDung.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNguoiDung.setText("TÊN NGƯỜI DÙNG");
        transitionsForm1.add(txtNguoiDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 400, 90));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CHÀO MỪNG");
        jLabel3.setPreferredSize(new java.awt.Dimension(160, 32));
        transitionsForm1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, -1, -1));

        txtImage.setForeground(new java.awt.Color(240, 240, 240));
        txtImage.setBorderSize(3);
        txtImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addPicture.png"))); // NOI18N
        transitionsForm1.add(txtImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 160, 160));

        add(transitionsForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1005, 540));
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private Transitions.TransitionsForm transitionsForm1;
    private ConnectUI.CircleImage txtImage;
    private javax.swing.JLabel txtNguoiDung;
    private javax.swing.JLabel txtQuyen;
    // End of variables declaration//GEN-END:variables

}
