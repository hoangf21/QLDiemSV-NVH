package PanelUser;

import ConnectUI.*;
import Transitions.TransitionsForm;
import java.awt.*;
import java.io.*;
import java.sql.*;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ThongTinCaNhan extends TransitionsForm {

    String username;
    String quyen;

    ConnectDB cn = new ConnectDB();
    Connection conn;
    ResultSet rs;
    byte[] anhSV;

    public ThongTinCaNhan(String user, String quyen1) {
        this.username = user;
        this.quyen = quyen1;
        initComponents();
        if (quyen.equals("SV")) {
            loaddlsv();
        } else if (quyen.equals("GV")) {
            loaddlgv();
        }
    }

    public void loaddlgv() {
        txtMasv.setEnabled(false);
        dtNgaySinh.setEnabled(false);
        txtHoten.setEnabled(false);
        txtLop.setEnabled(false);
        rdNam.setEnabled(false);
        rdNu.setEnabled(false);
        try {
            conn = cn.getConnection();
            String sql = "Select * from giangvien where magv=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtMasv.setText(rs.getString("magv"));
                txtHoten.setText(rs.getString("hoten"));
                dtNgaySinh.setDate(rs.getDate("ngaysinh"));
                if (rs.getString("gioitinh").equalsIgnoreCase("nam")) {
                    rdNam.setSelected(true);
                } else if (rs.getString("gioitinh").equalsIgnoreCase("nữ")) {
                    rdNu.setSelected(true);
                }
                txtSdt.setText(rs.getString("sdt"));
                txtDiachi.setText(rs.getString("diachi"));
                txtEmail.setText(rs.getString("email"));
                txtLop.setText(rs.getString("khoa"));
                Blob blob = rs.getBlob("anh");
                anhSV = blob.getBytes(1, (int) blob.length());
                Image img = CircleImage.createImageFromByteArray(anhSV, "jpg");
                txtImage.setIcon(new ImageIcon(img));
                jLabel2.setText("Mã Khoa: ");
                lblmasv.setText("Mã Giảng Viên: ");
            }
            conn.close();
        } catch (Exception e) {
        }
    }

    public void loaddlsv() {
        txtMasv.setEnabled(false);
        dtNgaySinh.setEnabled(false);
        txtHoten.setEnabled(false);
        txtLop.setEnabled(false);
        rdNam.setEnabled(false);
        rdNu.setEnabled(false);
        try {
            conn = cn.getConnection();
            String sql = "Select * from sinhvien where masv=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtMasv.setText(rs.getString("masv"));
                txtHoten.setText(rs.getString("hoten"));
                dtNgaySinh.setDate(rs.getDate("ngaysinh"));
                if (rs.getString("gioitinh").equalsIgnoreCase("nam")) {
                    rdNam.setSelected(true);
                } else if (rs.getString("gioitinh").equalsIgnoreCase("nữ")) {
                    rdNu.setSelected(true);
                }
                txtSdt.setText(rs.getString("sdt"));
                txtDiachi.setText(rs.getString("diachi"));
                txtEmail.setText(rs.getString("email"));
                txtLop.setText(rs.getString("malop"));
                Blob blob = rs.getBlob("anh");
                anhSV = blob.getBytes(1, (int) blob.length());
                Image img = CircleImage.createImageFromByteArray(anhSV, "jpg");
                txtImage.setIcon(new ImageIcon(img));
            }
            conn.close();
        } catch (Exception e) {
        }
    }

    public ThongTinCaNhan() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtDiachi = new javax.swing.JTextField();
        txtMasv = new javax.swing.JTextField();
        txtHoten = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblmasv = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdNu = new javax.swing.JRadioButton();
        rdNam = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLop = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnLoadAnh = new javax.swing.JButton();
        dtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtImage = new ConnectUI.CircleImage();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(0.0f,0.0f,0.0f,0.0f));
        setMinimumSize(new java.awt.Dimension(985, 556));
        setPreferredSize(new java.awt.Dimension(985, 556));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Lưu Lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 120, 30));

        txtDiachi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        add(txtDiachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 300, 40));

        txtMasv.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        add(txtMasv, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 300, 40));

        txtHoten.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        add(txtHoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, 300, 40));

        txtSdt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 300, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Quê quán:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, -1));

        lblmasv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblmasv.setText("Mã Sinh Viên:");
        add(lblmasv, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Họ và tên:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày Sinh:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, -1));

        rdNu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdNu.setText("Nữ");
        add(rdNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, -1, -1));

        rdNam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdNam.setText("Nam");
        add(rdNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giới tính:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Điện thoại:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        txtLop.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        add(txtLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 300, 40));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 300, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Lớp:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Email:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, -1, -1));

        btnLoadAnh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLoadAnh.setText("Đổi Ảnh");
        btnLoadAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadAnhActionPerformed(evt);
            }
        });
        add(btnLoadAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 120, 30));

        dtNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        dtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        dtNgaySinh.setOpaque(false);
        add(dtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 300, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Thông Tin Cá Nhân");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 400, 60));

        txtImage.setForeground(new java.awt.Color(240, 240, 240));
        txtImage.setBorderSize(3);
        txtImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addPicture.png"))); // NOI18N
        add(txtImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 160, 160));

        jSeparator1.setForeground(new java.awt.Color(0, 153, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, 385));
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadAnhActionPerformed
        String sql = null;
        if(quyen.equals("SV"))
            sql = "Update sinhvien set anh=? where masv=?";
        else if(quyen.equals("GV"))
            sql = "Update giangvien set anh=? where magv=?";
        
        if (btnLoadAnh.getText().equals("Đổi Ảnh")) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Hình ảnh", "png", "jpg");
            fileChooser.setFileFilter(imageFilter);
            fileChooser.setMultiSelectionEnabled(false);
            int x = fileChooser.showDialog(this, "Chọn file");
            if (x == JFileChooser.APPROVE_OPTION) {
                File f = fileChooser.getSelectedFile();
                String filename = f.getAbsolutePath();
                ImageIcon icon = new ImageIcon(filename);
                Image img = icon.getImage();
                txtImage.setIcon(icon);
                try {
                    anhSV = CircleImage.toByteArray(img, "jpg");
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
            }
            btnLoadAnh.setText("Lưu lại");
        } else if (btnLoadAnh.getText().equals("Lưu lại")) {
            conn = cn.getConnection();
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                Blob hinh = new SerialBlob(anhSV);
                pst.setBlob(1, hinh);
                pst.setString(2, username);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.toString());
            }
            btnLoadAnh.setText("Đổi Ảnh");
        }
    }//GEN-LAST:event_btnLoadAnhActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String sql = null;
        if(quyen.equals("SV"))
            sql = "Update sinhvien set sdt=?,diachi=?,email=? where masv=?";
        else if(quyen.equals("GV"))
            sql = "Update giangvien set sdt=?,diachi=?,email=? where magv=?";
        try {
            conn = cn.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtSdt.getText());
            pst.setString(2, txtDiachi.getText());
            pst.setString(4, txtMasv.getText());
            pst.setString(3, txtEmail.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoadAnh;
    private com.toedter.calendar.JDateChooser dtNgaySinh;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblmasv;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoten;
    private ConnectUI.CircleImage txtImage;
    private javax.swing.JTextField txtLop;
    private javax.swing.JTextField txtMasv;
    private javax.swing.JTextField txtSdt;
    // End of variables declaration//GEN-END:variables
}
