package PanelUser;

import ConnectUI.ConnectDB;
import Transitions.TransitionsForm;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.Color;

public class DoiMatKhau extends TransitionsForm {

    public String username;

    public DoiMatKhau(String user) {
        this.username = user;
        initComponents();
    }

    public DoiMatKhau() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        txtPwdNew1 = new javax.swing.JPasswordField();
        txtPwdOld = new javax.swing.JPasswordField();
        txtPwdNew = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();

        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(985, 556));
        setPreferredSize(new java.awt.Dimension(985, 556));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Đổi Mật Khẩu");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 400, 60));

        txtPwdNew1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(txtPwdNew1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 210, 40));

        txtPwdOld.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(txtPwdOld, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 210, 40));

        txtPwdNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(txtPwdNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 210, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nhập lại mật khẩu mới:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nhập mật khẩu cũ:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nhập mật khẩu mới:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, -1, -1));

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancel.setText("Làm mới");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 170, 40));

        btnOk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 170, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        txtPwdNew.setText("");
        txtPwdNew1.setText("");
        txtPwdOld.setText("");
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        if (txtPwdOld.getText().equals("") || txtPwdNew.getText().equals("") || txtPwdNew1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ các trường!");
        } else if (txtPwdNew.getText().equals(txtPwdOld.getText())) {
            JOptionPane.showMessageDialog(this, "Mật khẩu mới phải khác mật khẩu cũ!");
        } else if (!txtPwdNew.getText().equals(txtPwdNew1.getText())) {
            JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không khớp!");
        } else {
            ConnectDB cn = new ConnectDB();
            Connection conn = cn.getConnection();
            String sql = "Select * from login where uid=? and pwd=?";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, txtPwdOld.getText());
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                } else {
                    JOptionPane.showMessageDialog(this, "Sai mật khẩu cũ");
                }
            } catch (Exception e) {
            }
            int hdz = JOptionPane.showConfirmDialog(this, "Bạn có muốn thay đổi không!", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (hdz == JOptionPane.YES_OPTION) {
                conn = cn.getConnection();
                String sql1 = "Update login set pwd=? where uid=?";
                try {
                    PreparedStatement pst = conn.prepareStatement(sql1);
                    pst.setString(1, txtPwdNew.getText());
                    pst.setString(2, username);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Thay đổi thành công!");
                    this.setVisible(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.toString());
                }
            }
        }
    }//GEN-LAST:event_btnOkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField txtPwdNew;
    private javax.swing.JPasswordField txtPwdNew1;
    private javax.swing.JPasswordField txtPwdOld;
    // End of variables declaration//GEN-END:variables
}
