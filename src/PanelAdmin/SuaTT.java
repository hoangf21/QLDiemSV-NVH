package PanelAdmin;

import ConnectUI.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.prefs.Preferences;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SuaTT extends javax.swing.JFrame {

    int xMouse, yMouse;
    String masv,q;
    ConnectDB cn = new ConnectDB();
    Connection conn;
    ResultSet rs;
    byte[] anhSV;
    
    public SuaTT() {
        initComponents();
    }
    
    Preferences pref;
    boolean prefReme;
    
    public void loadmau(){
        pref = Preferences.userNodeForPackage(this.getClass());
        prefReme = pref.getBoolean("Color", Boolean.valueOf(""));
        if (prefReme) {
            txtImage.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
        }
    }
    
    public void loaddlsv() {
        txtMasv.setEnabled(false);
        try {
            conn = cn.getConnection();
            String sql = "Select * from sinhvien where masv=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, masv);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtMasv.setText(rs.getString("masv"));
                txtHoten.setText(rs.getString("hoten"));
                dtNgaySinh.setDate(rs.getDate("ngaysinh"));
                if (rs.getString("gioitinh").equalsIgnoreCase("nam")) {
                    cbGT.setSelectedItem("Nam");
                } else if (rs.getString("gioitinh").equalsIgnoreCase("nữ")) {
                    cbGT.setSelectedItem("Nữ");
                }
                txtSdt.setText(rs.getString("sdt"));
                txtDiachi.setText(rs.getString("diachi"));
                txtEmail.setText(rs.getString("email"));
                txtLop.setText(rs.getString("malop"));
                Blob blob = rs.getBlob("anh");
                if(blob!=null)
                {
                    anhSV = blob.getBytes(1, (int) blob.length());
                    Image img = CircleImage.createImageFromByteArray(anhSV, "jpg");
                    txtImage.setIcon(new ImageIcon(img));
                }else{
                    ImageIcon icon = new ImageIcon(getClass().getResource("/img/addPicture.png"));
                    txtImage.setIcon(icon);
                }
            }
            conn.close();
        } catch (Exception e) {
        }
    }
    
    public void loaddlgv() {
        txtMasv.setEnabled(false);
        try {
            conn = cn.getConnection();
            String sql = "Select * from giangvien where magv=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, masv);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtMasv.setText(rs.getString("magv"));
                txtHoten.setText(rs.getString("hoten"));
                dtNgaySinh.setDate(rs.getDate("ngaysinh"));
                if (rs.getString("gioitinh").equalsIgnoreCase("nam")) {
                    cbGT.setSelectedItem("Nam");
                } else if (rs.getString("gioitinh").equalsIgnoreCase("nữ")) {
                    cbGT.setSelectedItem("Nữ");
                }
                txtSdt.setText(rs.getString("sdt"));
                txtDiachi.setText(rs.getString("diachi"));
                txtEmail.setText(rs.getString("email"));
                txtLop.setText(rs.getString("khoa"));
                Blob blob = rs.getBlob("anh");
                if(blob!=null)
                {
                    anhSV = blob.getBytes(1, (int) blob.length());
                    Image img = CircleImage.createImageFromByteArray(anhSV, "jpg");
                    txtImage.setIcon(new ImageIcon(img));
                }else{
                    ImageIcon icon = new ImageIcon(getClass().getResource("/img/addPicture.png"));
                    txtImage.setIcon(icon);
                }
                lblMa.setText("Mã Khoa");
                lblmasv.setText("Mã Giảng Viên");
            }
            conn.close();
        } catch (Exception e) {
        }
    }
    
    public SuaTT(String quyen, String msv){
        this.q = quyen;
        this.masv = msv;
        initComponents();
        loadmau();
        setBackground(new Color(0,0,0,0));
        if(q.equals("SV"))
            loaddlsv();
        else if(q.equals("GV"))
            loaddlgv();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new dashboardUI.swing.PanelBorder();
        txtImage = new ConnectUI.CircleImage();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHoten = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMa = new javax.swing.JLabel();
        dtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        txtDiachi = new javax.swing.JTextField();
        txtLop = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        txtMasv = new javax.swing.JTextField();
        lblmasv = new javax.swing.JLabel();
        cbGT = new javax.swing.JComboBox<>();
        btnChooseImage = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnAccept = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnClose1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(242, 246, 253));
        setMaximumSize(new java.awt.Dimension(740, 600));
        setMinimumSize(new java.awt.Dimension(740, 600));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setMinimumSize(new java.awt.Dimension(740, 600));
        panelBorder1.setPreferredSize(new java.awt.Dimension(800, 600));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtImage.setBackground(new java.awt.Color(242, 246, 253));
        txtImage.setForeground(new java.awt.Color(0, 153, 255));
        txtImage.setBorderSize(3);
        txtImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addPicture.png"))); // NOI18N
        panelBorder1.add(txtImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 160, 160));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 300, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giới tính:");
        panelBorder1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Điện thoại:");
        panelBorder1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        txtHoten.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtHoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 300, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Quê quán:");
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày Sinh");
        panelBorder1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        lblMa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMa.setText("Lớp:");
        panelBorder1.add(lblMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, -1, -1));

        dtNgaySinh.setBackground(new java.awt.Color(255, 255, 255));
        dtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        dtNgaySinh.setOpaque(false);
        panelBorder1.add(dtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 300, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Họ và tên");
        panelBorder1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        txtDiachi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtDiachi, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 300, 40));

        txtLop.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, 300, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Email:");
        panelBorder1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, -1, -1));

        txtSdt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 300, 40));

        txtMasv.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtMasv, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 300, 40));

        lblmasv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblmasv.setText("Mã Sinh Viên");
        panelBorder1.add(lblmasv, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        cbGT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbGT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        panelBorder1.add(cbGT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 300, 40));

        btnChooseImage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnChooseImage.setText("Chọn Ảnh");
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });
        panelBorder1.add(btnChooseImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 100, 30));

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancel.setText("Làm Mới");
        panelBorder1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 540, 120, 40));

        btnAccept.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAccept.setText("Xác Nhận");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });
        panelBorder1.add(btnAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 120, 40));

        btnClose.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close copy.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        panelBorder1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(711, -4, 32, 32));

        btnClose1.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnClose1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mini1_1.png"))); // NOI18N
        btnClose1.setBorder(null);
        btnClose1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mini1.png"))); // NOI18N
        btnClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClose1ActionPerformed(evt);
            }
        });
        panelBorder1.add(btnClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, -4, 32, 32));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseImageActionPerformed
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
            txtImage.setIcon(new ImageIcon(img));
            try {
                anhSV = CircleImage.toByteArray(img, "jpg");
            } catch (IOException ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_btnChooseImageActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        conn = cn.getConnection();
        String sql_update = "";
        if(q.equals("SV")){
            sql_update = "Update sinhvien set hoten=?,ngaysinh=?,gioitinh=?,sdt=?,email=?,diachi=?,malop=?,anh=? where masv=?";
        } else if(q.equals("GV")){
            sql_update = "Update giangvien set hoten=?,ngaysinh=?,gioitinh=?,sdt=?,email=?,diachi=?,khoa=?,anh=? where magv=?";
        }
        try {
             
            PreparedStatement pst = conn.prepareStatement(sql_update);
            pst.setString(9, txtMasv.getText());
            pst.setString(1, txtHoten.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            pst.setString(2, sdf.format(dtNgaySinh.getDate()));
            pst.setString(3, cbGT.getSelectedItem().toString());
            pst.setString(4, txtSdt.getText());
            pst.setString(5, txtEmail.getText());
            pst.setString(6, txtDiachi.getText());
            pst.setString(7, txtLop.getText());
            Blob hinh = new SerialBlob(anhSV);
            pst.setBlob(8, hinh);
            int ktra = pst.executeUpdate();
            if(ktra>0){
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công!");
                this.setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClose1ActionPerformed
        setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnClose1ActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SuaTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaTT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuaTT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnClose1;
    private javax.swing.JComboBox<String> cbGT;
    private com.toedter.calendar.JDateChooser dtNgaySinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblmasv;
    private dashboardUI.swing.PanelBorder panelBorder1;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoten;
    private ConnectUI.CircleImage txtImage;
    private javax.swing.JTextField txtLop;
    private javax.swing.JTextField txtMasv;
    private javax.swing.JTextField txtSdt;
    // End of variables declaration//GEN-END:variables
}
