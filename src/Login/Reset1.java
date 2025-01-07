package Login;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;
import ConnectUI.ConnectDB;

public class Reset1 extends javax.swing.JFrame {

    int xMouse;
    int yMouse;
    public String user;
    ConnectDB cn = new ConnectDB();
    Connection conn;
    
    
    public Reset1(String username) {
        this.user = username;
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

    public Reset1() {
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

        iconpwd1 = new javax.swing.JLabel();
        btnHide = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        btnHide1 = new javax.swing.JButton();
        btnShow1 = new javax.swing.JButton();
        txtPwd1 = new javax.swing.JPasswordField();
        jSeparator3 = new javax.swing.JSeparator();
        iconpwd = new javax.swing.JLabel();
        txtPwd = new javax.swing.JPasswordField();
        lblPwd1 = new javax.swing.JLabel();
        lblPwd = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        SIGNUP = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnLogin1 = new javax.swing.JButton();
        main = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconpwd1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lock.png"))); // NOI18N
        getContentPane().add(iconpwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 28, 21));

        btnHide.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnHide.setForeground(new java.awt.Color(255, 255, 255));
        btnHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/see.png"))); // NOI18N
        btnHide.setBorder(null);
        btnHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHideActionPerformed(evt);
            }
        });
        getContentPane().add(btnHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 40, 40));

        btnShow.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnShow.setForeground(new java.awt.Color(255, 255, 255));
        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eye_op.png"))); // NOI18N
        btnShow.setBorder(null);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });
        getContentPane().add(btnShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 40, 40));

        btnHide1.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnHide1.setForeground(new java.awt.Color(255, 255, 255));
        btnHide1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/see.png"))); // NOI18N
        btnHide1.setBorder(null);
        btnHide1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHide1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnHide1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 40, 40));

        btnShow1.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnShow1.setForeground(new java.awt.Color(255, 255, 255));
        btnShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eye_op.png"))); // NOI18N
        btnShow1.setBorder(null);
        btnShow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShow1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnShow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 40, 40));

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
        getContentPane().add(txtPwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 300, 40));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setOpaque(true);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 340, 1));

        iconpwd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lock.png"))); // NOI18N
        getContentPane().add(iconpwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 28, 21));

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
        getContentPane().add(txtPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 300, 40));

        lblPwd1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblPwd1.setForeground(new java.awt.Color(255, 255, 255));
        lblPwd1.setText("Re-Password");
        getContentPane().add(lblPwd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        lblPwd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblPwd.setForeground(new java.awt.Color(255, 255, 255));
        lblPwd.setText("Password");
        getContentPane().add(lblPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOpaque(true);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 340, 1));

        SIGNUP.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        SIGNUP.setForeground(new java.awt.Color(255, 255, 255));
        SIGNUP.setText("RESET-PWD");
        getContentPane().add(SIGNUP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

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

        btnLogin.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("RESET");
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
        btnLogin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Reset.png"))); // NOI18N
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

        main.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/XacNhanOTP.png"))); // NOI18N
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

    private void txtPwd1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPwd1MouseEntered
        if (txtPwd1.getText().equals("Re-Password"))
            txtPwd1.setText("");
    }//GEN-LAST:event_txtPwd1MouseEntered

    private void txtPwd1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPwd1MouseExited
        if (txtPwd1.getText().equals(""))
            txtPwd1.setText("Re-Password");
    }//GEN-LAST:event_txtPwd1MouseExited

    private void btnHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHideActionPerformed
        btnHide.setVisible(false);
        btnShow.setVisible(true);
        if (btnShow.isVisible())
            txtPwd.setEchoChar((char) '\u25cf');
    }//GEN-LAST:event_btnHideActionPerformed

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

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setVisible(false);
        btnLogin1.setVisible(true);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLogin1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin1MouseExited
        btnLogin.setVisible(true);
        btnLogin1.setVisible(false);
    }//GEN-LAST:event_btnLogin1MouseExited

    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        if (txtPwd.getText().equals(txtPwd1.getText())) {
            try {
                conn = cn.getConnection();
                PreparedStatement pst;
                String updateQuery = "UPDATE login SET pwd=? WHERE uid=?";
                pst = conn.prepareStatement(updateQuery);
                pst.setString(1, txtPwd.getText());
                pst.setString(2, user);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Reset mật khẩu thành công!\n" + "Hãy đăng nhập bằng mặt khẩu mới: " + txtPwd.getText());
                new Login().setVisible(true);
                this.setVisible(false);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Mật khẩu phải trùng nhau!");
        }
        
        
        
    }//GEN-LAST:event_btnLogin1ActionPerformed

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

    public static void main(String args[]) {
        IntelliJTheme.setup(Reset1.class.getResourceAsStream("/XcodeLight.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reset1().setVisible(true);
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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblPwd;
    private javax.swing.JLabel lblPwd1;
    private javax.swing.JLabel main;
    private javax.swing.JPasswordField txtPwd;
    private javax.swing.JPasswordField txtPwd1;
    // End of variables declaration//GEN-END:variables
}
