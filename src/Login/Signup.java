package Login;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import ConnectUI.ConnectDB;

public class Signup extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    ResultSet rs;
    public static final int MYSQL_DUPLICATE_PK = 2627;

    public Signup() {
        initComponents();
        setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        btnHide.setVisible(false);
        btnShow.setVisible(true);
        txtPwd.setEchoChar((char) '\u25cf');
        btnHide1.setVisible(false);
        btnShow1.setVisible(true);
        txtPwd1.setEchoChar((char) '\u25cf');
        btnLogin1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SIGNUP = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        txtUid = new javax.swing.JTextField();
        iconuser = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblPwd = new javax.swing.JLabel();
        iconpwd = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnHide = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        txtPwd = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        lblPwd1 = new javax.swing.JLabel();
        iconpwd1 = new javax.swing.JLabel();
        btnHide1 = new javax.swing.JButton();
        btnShow1 = new javax.swing.JButton();
        txtPwd1 = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        btnLogin = new javax.swing.JButton();
        btnLogin1 = new javax.swing.JButton();
        main = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 640));
        setName("Login"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SIGNUP.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SIGNUP.setForeground(new java.awt.Color(255, 255, 255));
        SIGNUP.setText("SIGNUP");
        getContentPane().add(SIGNUP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("Username");
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        txtUid.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        txtUid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUid.setForeground(new java.awt.Color(255, 255, 255));
        txtUid.setText("Username");
        txtUid.setBorder(null);
        txtUid.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUid.setOpaque(false);
        txtUid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtUidMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtUidMouseExited(evt);
            }
        });
        getContentPane().add(txtUid, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 300, 40));

        iconuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        getContentPane().add(iconuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 28, 20));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOpaque(true);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 340, 1));

        lblPwd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblPwd.setForeground(new java.awt.Color(255, 255, 255));
        lblPwd.setText("Password");
        getContentPane().add(lblPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        iconpwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lock.png"))); // NOI18N
        getContentPane().add(iconpwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 28, 21));

        btnClose.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 32, 32));

        btnHide.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnHide.setForeground(new java.awt.Color(255, 255, 255));
        btnHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/see.png"))); // NOI18N
        btnHide.setBorder(null);
        btnHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHideActionPerformed(evt);
            }
        });
        getContentPane().add(btnHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 40, 40));

        btnShow.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnShow.setForeground(new java.awt.Color(255, 255, 255));
        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eye_op.png"))); // NOI18N
        btnShow.setBorder(null);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        getContentPane().add(btnShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 40, 40));

        txtPwd.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        txtPwd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPwd.setForeground(new java.awt.Color(255, 255, 255));
        txtPwd.setText("Password");
        txtPwd.setBorder(null);
        txtPwd.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPwd.setOpaque(false);
        txtPwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtPwdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtPwdMouseExited(evt);
            }
        });
        getContentPane().add(txtPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 300, 40));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOpaque(true);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 340, 1));

        lblPwd1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblPwd1.setForeground(new java.awt.Color(255, 255, 255));
        lblPwd1.setText("Re-Password");
        getContentPane().add(lblPwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        iconpwd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lock.png"))); // NOI18N
        getContentPane().add(iconpwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 28, 21));

        btnHide1.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnHide1.setForeground(new java.awt.Color(255, 255, 255));
        btnHide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/see.png"))); // NOI18N
        btnHide1.setBorder(null);
        btnHide1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHide1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnHide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 40, 40));

        btnShow1.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnShow1.setForeground(new java.awt.Color(255, 255, 255));
        btnShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eye_op.png"))); // NOI18N
        btnShow1.setBorder(null);
        btnShow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShow1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnShow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 40, 40));

        txtPwd1.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        txtPwd1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPwd1.setForeground(new java.awt.Color(255, 255, 255));
        txtPwd1.setText("Re-Password");
        txtPwd1.setBorder(null);
        txtPwd1.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPwd1.setOpaque(false);
        txtPwd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtPwd1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtPwd1MouseExited(evt);
            }
        });
        getContentPane().add(txtPwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 300, 40));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setOpaque(true);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 340, 1));

        btnLogin.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("SIGN UP");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 170, 40));

        btnLogin1.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnLogin1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sign up.png"))); // NOI18N
        btnLogin1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnLogin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin1MouseExited(evt);
            }
        });
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 170, 40));

        main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/signup.png"))); // NOI18N
        main.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mainMouseDragged(evt);
            }
        });
        main.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainMousePressed(evt);
            }
        });
        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mainMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_mainMouseDragged

    private void mainMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_mainMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.2) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtUidMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUidMouseEntered
        if (txtUid.getText().equals("Username"))
            txtUid.setText("");
    }//GEN-LAST:event_txtUidMouseEntered

    private void txtUidMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUidMouseExited
        if (txtUid.getText().equals(""))
            txtUid.setText("Username");
    }//GEN-LAST:event_txtUidMouseExited

    private void txtPwdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPwdMouseEntered
        if (txtPwd.getText().equals("Password"))
            txtPwd.setText("");
    }//GEN-LAST:event_txtPwdMouseEntered

    private void txtPwdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPwdMouseExited
        if (txtPwd.getText().equals(""))
            txtPwd.setText("Password");
    }//GEN-LAST:event_txtPwdMouseExited

    private void btnHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHideActionPerformed
        btnHide.setVisible(false);
        btnShow.setVisible(true);
        if (btnShow.isVisible())
            txtPwd.setEchoChar((char) '\u25cf');
    }//GEN-LAST:event_btnHideActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        btnHide.setVisible(true);
        btnShow.setVisible(false);
        if (btnHide.isVisible())
            txtPwd.setEchoChar((char) 0);
    }//GEN-LAST:event_btnShowActionPerformed

    private void txtPwd1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPwd1MouseEntered
        if (txtPwd1.getText().equals("Re-Password"))
            txtPwd1.setText("");
    }//GEN-LAST:event_txtPwd1MouseEntered

    private void txtPwd1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPwd1MouseExited
        if (txtPwd1.getText().equals(""))
            txtPwd1.setText("Re-Password");
    }//GEN-LAST:event_txtPwd1MouseExited

    private void btnHide1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHide1ActionPerformed
        btnHide1.setVisible(false);
        btnShow1.setVisible(true);
        if (btnShow1.isVisible())
            txtPwd1.setEchoChar((char) '\u25cf');
    }//GEN-LAST:event_btnHide1ActionPerformed

    private void btnShow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShow1ActionPerformed
        btnHide1.setVisible(true);
        btnShow1.setVisible(false);
        if (btnHide1.isVisible())
            txtPwd1.setEchoChar((char) 0);
    }//GEN-LAST:event_btnShow1ActionPerformed

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        try {
            ConnectDB cn = new ConnectDB();
            Connection conn = cn.getConnection();

            StringBuffer sb = new StringBuffer();
            try {
                String sql_check_primarykey = "Select * from login where uid ='" + txtUid.getText() + "'";
                Statement stt = conn.createStatement();
                ResultSet rss = stt.executeQuery(sql_check_primarykey);
                if (rss.next()) {
                    sb.append("Tài khoản này đã được đăng kí, vui lòng đăng nhập!");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }

            String sql_check = "Select * from sinhvien where masv='" + txtUid.getText() + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql_check);
            if (rs.next()) {
                try {
                    String id = txtUid.getText();
                    String check_quyen = id.substring(0, 2);
                    String quyen = "";
                    if (check_quyen.equals("GV")) {
                        quyen = "GV";
                    } else {
                        quyen = "SV";
                    }
                    String sql = "Insert into login(uid, pwd, maquyen) values(?, ?, ?)";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    StringBuffer sbb = new StringBuffer();
                    if (txtUid.getText().equals("") || txtUid.getText().equals("Username")) {
                        sbb.append("Nhập tài khoản\n");
                    }
                    if (txtPwd.getText().equals("") || txtPwd.getText().equals("Password")) {
                        sbb.append("Nhập mật khẩu\n");
                    }
                    if (txtPwd1.getText().equals("") || txtPwd1.getText().equals("Re-Password")) {
                        sbb.append("Nhập lại mật khẩu\n");
                    }
                    if (sbb.length() > 0) {
                        JOptionPane.showMessageDialog(this, sbb.toString());
                        return;
                    }
                    if (txtPwd.getText().equals(txtPwd1.getText())) {
                        ps.setString(1, txtUid.getText());
                        ps.setString(2, txtPwd.getText());
                        ps.setString(3, quyen);
                        int chk = ps.executeUpdate();
                        if (chk > 0) {
                            JOptionPane.showMessageDialog(this, "Đăng ký thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
                            new Login().setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Đăng ký thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Mật khẩu phải giống nhau!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn không tồn tại trong csdl!");
            }
        } catch (SQLException e) {
            if (e.getErrorCode() == MYSQL_DUPLICATE_PK) {
                JOptionPane.showMessageDialog(this, "Đã tồn tại tài khoản này!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setVisible(false);
        btnLogin1.setVisible(true);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLogin1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin1MouseExited
        btnLogin.setVisible(true);
        btnLogin1.setVisible(false);
    }//GEN-LAST:event_btnLogin1MouseExited

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    public static void main(String args[]) {
        IntelliJTheme.setup(Signup.class.getResourceAsStream("/Light.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SIGNUP;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHide;
    private javax.swing.JButton btnHide1;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnShow1;
    private javax.swing.JLabel iconpwd;
    private javax.swing.JLabel iconpwd1;
    private javax.swing.JLabel iconuser;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblPwd;
    private javax.swing.JLabel lblPwd1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel main;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JPasswordField txtPwd1;
    private javax.swing.JTextField txtUid;
    // End of variables declaration//GEN-END:variables

    private String getTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
