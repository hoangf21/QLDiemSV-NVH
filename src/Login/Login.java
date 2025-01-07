package Login;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.*;
import java.sql.*;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import ConnectUI.ConnectDB;
import Main.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    ResultSet rs;

    ConnectDB cn = new ConnectDB();
    Connection conn;

    Preferences pref;
    boolean prefReme;

    String user = "";
    String pwd = "";

    Date date;
    int solantruycap, id;
    Date ngay;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void reme() {
        pref = Preferences.userNodeForPackage(this.getClass());
        prefReme = pref.getBoolean("Rememberme", Boolean.valueOf(""));
        if (prefReme) {
            txtUid.setText(pref.get("User", ""));
            txtPwd.setText(pref.get("Pass", ""));
            if (prefReme) {
                Checked.setVisible(true);
                unChecked.setVisible(false);
            } else {
                Checked.setVisible(false);
                unChecked.setVisible(true);
            }
        }
    }

    public void demlantruycap() {
        date = new Date();
        conn = cn.getConnection();
        String sql = "SELECT TOP 1 id ,ngay, solantruycap FROM dbo.lantruycap ORDER BY ngay DESC";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt("id");
                ngay = rs.getDate("ngay");
                solantruycap = rs.getInt("solantruycap");
            }
        } catch (Exception e) {
        }
    }

    public Login() {
        initComponents();
        setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        btnHide.setVisible(false);
        btnShow.setVisible(true);
        txtPwd.setEchoChar((char) '\u25cf');
        btnLogin1.setVisible(false);
        reme();
        demlantruycap();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPwd = new javax.swing.JLabel();
        iconuser = new javax.swing.JLabel();
        iconpwd = new javax.swing.JLabel();
        btnHide = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnLogin1 = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtUid = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtPwd = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        dieukhoan = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        forgotPwd = new javax.swing.JLabel();
        Checked = new javax.swing.JButton();
        unChecked = new javax.swing.JButton();
        forgotPwd1 = new javax.swing.JLabel();
        main = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 640));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setText("LOGIN");
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 80, 40));

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("Username");
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        lblPwd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblPwd.setForeground(new java.awt.Color(255, 255, 255));
        lblPwd.setText("Password");
        getContentPane().add(lblPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        iconuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        getContentPane().add(iconuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 208, 28, 20));

        iconpwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lock.png"))); // NOI18N
        getContentPane().add(iconpwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 291, 28, 20));

        btnHide.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        btnHide.setForeground(new java.awt.Color(255, 255, 255));
        btnHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/see.png"))); // NOI18N
        btnHide.setBorder(null);
        btnHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHideActionPerformed(evt);
            }
        });
        getContentPane().add(btnHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 40, 40));

        btnShow.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        btnShow.setForeground(new java.awt.Color(255, 255, 255));
        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eye_op.png"))); // NOI18N
        btnShow.setBorder(null);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        getContentPane().add(btnShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 40, 40));

        btnLogin.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnLight.png"))); // NOI18N
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 170, 40));

        btnLogin1.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        btnLogin1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnLight.png"))); // NOI18N
        btnLogin1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnLogin1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnLogin1MouseMoved(evt);
            }
        });
        btnLogin1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogin1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin1MouseExited(evt);
            }
        });
        btnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 170, 40));

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

        txtUid.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtUidMousePressed(evt);
            }
        });
        getContentPane().add(txtUid, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 300, 40));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOpaque(true);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 340, 1));

        txtPwd.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
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
        getContentPane().add(txtPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 300, 40));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOpaque(true);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 340, 1));

        dieukhoan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dieukhoan.setForeground(new java.awt.Color(0, 153, 255));
        dieukhoan.setText("Terms & Condition");
        dieukhoan.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                dieukhoanMouseMoved(evt);
            }
        });
        dieukhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dieukhoanMousePressed(evt);
            }
        });
        getContentPane().add(dieukhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, -1, -1));

        btnRegister.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        btnRegister.setForeground(new java.awt.Color(255, 255, 255));
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/signupic.png"))); // NOI18N
        btnRegister.setBorder(null);
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, 45, 45));

        forgotPwd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        forgotPwd.setForeground(new java.awt.Color(255, 255, 255));
        forgotPwd.setText("Forgot Password?");
        forgotPwd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                forgotPwdMouseMoved(evt);
            }
        });
        forgotPwd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                forgotPwdMousePressed(evt);
            }
        });
        getContentPane().add(forgotPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 343, -1, -1));

        Checked.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        Checked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/checked.png"))); // NOI18N
        Checked.setBorder(null);
        Checked.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckedMouseClicked(evt);
            }
        });
        getContentPane().add(Checked, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 340, 26, 26));

        unChecked.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        unChecked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/unchecked.png"))); // NOI18N
        unChecked.setBorder(null);
        unChecked.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                unCheckedMouseClicked(evt);
            }
        });
        getContentPane().add(unChecked, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 340, 26, 26));

        forgotPwd1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        forgotPwd1.setForeground(new java.awt.Color(255, 255, 255));
        forgotPwd1.setText("Save Login");
        forgotPwd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPwd1MouseClicked(evt);
            }
        });
        getContentPane().add(forgotPwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 343, -1, -1));

        main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Untitled-12.png"))); // NOI18N
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
        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        btnHide.setVisible(true);
        btnShow.setVisible(false);
        if (btnHide.isVisible())
            txtPwd.setEchoChar((char) 0);
    }//GEN-LAST:event_btnShowActionPerformed

    private void btnHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHideActionPerformed
        btnHide.setVisible(false);
        btnShow.setVisible(true);
        if (btnShow.isVisible())
            txtPwd.setEchoChar((char) '\u25cf');
    }//GEN-LAST:event_btnHideActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        new Signup().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.25) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setVisible(false);
        btnLogin1.setVisible(true);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        try {
            conn = cn.getConnection();
            StringBuffer sb = new StringBuffer();
            user = txtUid.getText().replaceAll("[!';:]", "");
            pwd = txtPwd.getText().replaceAll("[!';:]", "");
            String sql = "Select * from login where uid=? and pwd=?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, user);
            pst.setString(2, pwd);
            if (user.equals("") || user.equals("Username")) {
                sb.append("Nhập tài khoản\n");
            }
            if (pwd.equals("") || pwd.equals("Password")) {
                sb.append("Nhập mật khẩu");
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString(), "Thông báo!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            rs = pst.executeQuery();
            if (rs.next()) {
                if (Checked.isVisible() && !(prefReme && unChecked.isVisible())) {
                    pref.put("User", user);
                    pref.put("Pass", pwd);
                    pref.putBoolean("Rememberme", true);
                } else if (unChecked.isVisible() && prefReme && !Checked.isVisible()) {
                    pref.put("User", "");
                    pref.put("Pass", "");
                    pref.putBoolean("Rememberme", false);
                }
                JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công!");
                try {
                    int x = sdf.format(date).compareTo(sdf.format(ngay));
                    String sql_update  = "";
                    if (x==0) {
                        solantruycap++;
                        sql_update = "UPDATE dbo.lantruycap SET solantruycap = '" + solantruycap + "' WHERE ngay = '" + sdf.format(date) + "'";
                        Statement st = conn.createStatement();
                        st.executeUpdate(sql_update);
                   } else if(x>0){
                        solantruycap = 1;
                        id++;
                        sql_update = "Insert dbo.lantruycap values(?,?,?)";
                        PreparedStatement ps = conn.prepareStatement(sql_update);
                        ps.setInt(1, id);
                        ps.setString(2, sdf.format(date));
                        ps.setInt(3, solantruycap);
                        ps.executeUpdate();
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
                String quyen = rs.getString("maquyen");
                this.setVisible(false);
                if (quyen.equalsIgnoreCase("admin")) {
                    new DashboardAdmin().setVisible(true);
                } else {
                    new MainND(user, quyen).setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sai tài khoản hoặc mật khẩu!");
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void btnLogin1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin1MouseExited
        btnLogin.setVisible(true);
        btnLogin1.setVisible(false);
    }//GEN-LAST:event_btnLogin1MouseExited

    private void btnLogin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin1MouseClicked

    }//GEN-LAST:event_btnLogin1MouseClicked

    private void CheckedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckedMouseClicked
        Checked.setVisible(false);
        unChecked.setVisible(true);
    }//GEN-LAST:event_CheckedMouseClicked

    private void unCheckedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_unCheckedMouseClicked
        Checked.setVisible(true);
        unChecked.setVisible(false);
    }//GEN-LAST:event_unCheckedMouseClicked

    private void forgotPwd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPwd1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_forgotPwd1MouseClicked

    private void forgotPwdMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPwdMouseMoved
        forgotPwd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_forgotPwdMouseMoved

    private void forgotPwdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPwdMousePressed
        new ForgotPwd().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_forgotPwdMousePressed

    private void dieukhoanMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dieukhoanMouseMoved
        dieukhoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_dieukhoanMouseMoved

    private void dieukhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dieukhoanMousePressed
        new Term().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_dieukhoanMousePressed

    private void btnLogin1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin1MouseMoved
        btnLogin1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnLogin1MouseMoved

    private void txtUidMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUidMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUidMousePressed

    public static void main(String args[]) {
        IntelliJTheme.setup(Login.class.getResourceAsStream("/XcodeLight.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Checked;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHide;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnShow;
    private javax.swing.JLabel dieukhoan;
    private javax.swing.JLabel forgotPwd;
    private javax.swing.JLabel forgotPwd1;
    private javax.swing.JLabel iconpwd;
    private javax.swing.JLabel iconuser;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPwd;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel main;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JTextField txtUid;
    private javax.swing.JButton unChecked;
    // End of variables declaration//GEN-END:variables

}
