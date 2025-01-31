package Login;

import com.formdev.flatlaf.IntelliJTheme;
import java.awt.Color;
import java.sql.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
import ConnectUI.ConnectDB;

public class ForgotPwd extends javax.swing.JFrame {

    int xMouse;
    int yMouse;

    ConnectDB cn = new ConnectDB();
    Connection conn;
    ResultSet rs;

    String username;

    String randomCode;

    public ForgotPwd() {
        initComponents();
        setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        btnLogin1.setVisible(false);
        btnLogin3.setVisible(false);
        txtEmail.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        iconuser = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnLogin = new javax.swing.JButton();
        btnLogin1 = new javax.swing.JButton();
        lblUser1 = new javax.swing.JLabel();
        iconuser1 = new javax.swing.JLabel();
        txtVertify = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btnLogin2 = new javax.swing.JButton();
        btnLogin3 = new javax.swing.JButton();
        lblUser2 = new javax.swing.JLabel();
        iconuser2 = new javax.swing.JLabel();
        btnSearchEmail = new javax.swing.JButton();
        txtUid = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        main = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(400, 640));
        setUndecorated(true);
        setResizable(false);
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setText("FORGOT-PWD");
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 170, 40));

        lblUser.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("E-Mail");
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        iconuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/email.png"))); // NOI18N
        getContentPane().add(iconuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 28, 20));

        txtEmail.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setText("Email");
        txtEmail.setBorder(null);
        txtEmail.setCaretColor(new java.awt.Color(255, 255, 255));
        txtEmail.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtEmail.setOpaque(false);
        txtEmail.setSelectionColor(new java.awt.Color(102, 102, 255));
        txtEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtEmailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtEmailMouseExited(evt);
            }
        });
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 300, 40));

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

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOpaque(true);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 340, 1));

        btnLogin.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("SEND");
        btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnLogin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnLight.png"))); // NOI18N
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 165, 40));

        btnLogin1.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        btnLogin1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin1.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/send.png"))); // NOI18N
        btnLogin1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
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
        getContentPane().add(btnLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 165, 40));

        lblUser1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUser1.setForeground(new java.awt.Color(255, 255, 255));
        lblUser1.setText("Vertify Code");
        getContentPane().add(lblUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        iconuser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vertify.png"))); // NOI18N
        getContentPane().add(iconuser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 327, 28, 25));

        txtVertify.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        txtVertify.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtVertify.setForeground(new java.awt.Color(255, 255, 255));
        txtVertify.setText("Vertify Code");
        txtVertify.setBorder(null);
        txtVertify.setCaretColor(new java.awt.Color(255, 255, 255));
        txtVertify.setOpaque(false);
        txtVertify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtVertifyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtVertifyMouseExited(evt);
            }
        });
        getContentPane().add(txtVertify, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 300, 40));

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOpaque(true);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 340, 1));

        btnLogin2.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        btnLogin2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin2.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin2.setText("VERTIFY CODE");
        btnLogin2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnLogin2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/btnLight.png"))); // NOI18N
        btnLogin2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin2MouseEntered(evt);
            }
        });
        getContentPane().add(btnLogin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 165, 40));

        btnLogin3.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        btnLogin3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLogin3.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VertifyCode.png"))); // NOI18N
        btnLogin3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnLogin3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogin3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin3MouseExited(evt);
            }
        });
        btnLogin3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogin3ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 165, 40));

        lblUser2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblUser2.setForeground(new java.awt.Color(255, 255, 255));
        lblUser2.setText("Username");
        getContentPane().add(lblUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        iconuser2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        getContentPane().add(iconuser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 168, 28, 20));

        btnSearchEmail.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnSearchEmail.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        btnSearchEmail.setToolTipText("Kiểm tra");
        btnSearchEmail.setBorder(null);
        btnSearchEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchEmailActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearchEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 40, 40));

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

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setOpaque(true);
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 340, 1));

        main.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/QuenMatKhau.png"))); // NOI18N
        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseEntered
        if (txtEmail.getText().equals("Email"))
            txtEmail.setText("");
    }//GEN-LAST:event_txtEmailMouseEntered

    private void txtEmailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmailMouseExited
        if (txtEmail.getText().equals(""))
            txtEmail.setText("Email");
    }//GEN-LAST:event_txtEmailMouseExited

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setVisible(false);
        btnLogin1.setVisible(true);
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLogin1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin1MouseClicked

    }//GEN-LAST:event_btnLogin1MouseClicked

    private void btnLogin1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin1MouseExited
        btnLogin.setVisible(true);
        btnLogin1.setVisible(false);
    }//GEN-LAST:event_btnLogin1MouseExited


    private void btnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin1ActionPerformed
        try {
            StringBuffer sb = new StringBuffer();
            if (txtUid.getText().equals("Username") || txtUid.getText().equals("")) {
                sb.append("Bạn chưa nhập tài khoản!\n");
            }
            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }

            String quyen = "";
            conn = cn.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs1 = st.executeQuery("Select * from login where uid='" + txtUid.getText() + "'");
            if (rs1.next()) {
                quyen = rs1.getString("maquyen");
            }

            String check = "";
            String taikhoan = "";

            if (quyen.equals("SV")) {
                check = "Select * from sinhvien where masv=?";
                taikhoan = "masv";
            } else if (quyen.equals("GV")) {
                check = "Select * from giangvien where magv=?";
                taikhoan = "magv";
            }

            PreparedStatement ps = conn.prepareStatement(check);
            ps.setString(1, txtUid.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString(taikhoan).equalsIgnoreCase(txtUid.getText())) {
                    try {
                        Random rand = new Random();
                        int rd = rand.nextInt(999999);
                        if (rd < 100000) {
                            if (rd < 10000) {
                                if (rd < 1000) {
                                    if (rd < 100) {
                                        if (rd < 10) {
                                            randomCode = "00000" + rd;
                                        } else {
                                            randomCode = "0000" + rd;
                                        }
                                    } else {
                                        randomCode = "000" + rd;
                                    }
                                } else {
                                    randomCode = "00" + rd;
                                }
                            } else {
                                randomCode = "0" + rd;
                            }
                        } else {
                            randomCode = "" + rd;
                        }
                        String sql_name = "Select hoten from sinhvien where masv='" + txtUid.getText() + "'";
                        Statement stt = conn.createStatement();
                        ResultSet rs = stt.executeQuery(sql_name);
                        String ten = "";
                        if (rs.next()) {
                            ten = rs.getString("hoten");
                        }

                        StringBuilder sbb = new StringBuilder();

                        sbb.append("<section style=\"display: flex;justify-content: center; align-items: center;\">");

                        sbb.append("<div style=\"margin: 0; padding: 0; border: 2px dashed #0984e3; border-radius: 15px; margin-left: auto; margin-right: auto;\">");

                        sbb.append("<div style=\"position: relative; align-items: center; justify-content: center; padding: 20px;\">");

                        sbb.append("<img src=\"https://bit.ly/logodhkthn\" width=\"250\" style=\"display: block;margin-left: auto;margin-right: auto;\" alt=\"\">");

                        sbb.append("<div style=\"font-size: 45px;font-weight: 650;margin-top: 20px;margin-bottom: 20px; color:#2d3436;font-family:'Roboto', sans-serif; text-align: center;\">Mã xác minh của bạn là</div>").append(System.lineSeparator());

                        sbb.append("<div style=\"font-size: 60px;color: #0984e3;font-weight: 800; font-family:'Roboto', sans-serif;margin-bottom: 20px; text-align: center;\">").append(System.lineSeparator());

                        sbb.append(randomCode);

                        sbb.append("</div>").append(System.lineSeparator());

                        sbb.append("<p style=\"font-size: 20px;font-weight: 600;color:#2d3436;font-family:'Roboto', sans-serif; padding: 5px; text-align: center;\">Hello, " + ten + "</p>").append(System.lineSeparator());

                        sbb.append("<p style=\"font-size: 20px;font-weight: 600;color:#2d3436;font-family:'Roboto', sans-serif; padding: 5px; text-align: center;\">Vui lòng quay lại trang đã quên và chèn mã ở trên để xác minh danh tính của bạn.</p>").append(System.lineSeparator());

                        sbb.append("<p style=\"font-size: 20px;font-weight: 600;color:#2d3436;font-family:'Roboto', sans-serif; padding: 5px; text-align: center;\">FROM</p>").append(System.lineSeparator());

                        sbb.append("<p style=\"font-size: 25px;font-weight: 700;color:#2d3436;font-family:'Roboto', sans-serif; text-align: center;\">CODE NGUYEN VIET HOANG</p>").append(System.lineSeparator());

                        sbb.append("</div>");

                        sbb.append("</div>");

                        sbb.append("</section>");

                        username = txtUid.getText();
                        String host = "smtp.gmail.com";
                        String user = "Your gmail";
                        String pass = "Password";
                        String to = txtEmail.getText();
                        String subject = "Bạn đang gửi yêu cầu đặt lại mật khẩu";
                        String message = sbb.toString();
                        boolean sessionDebug = false;
                        Properties pros = System.getProperties();
                        pros.put("mail.smtp.starttls.enable", "true");
                        pros.put("mail.smtp.host", "smtp.gmail.com");
                        pros.put("mail.smtp.port", "587");
                        pros.put("mail.smtp.auth", "true");
                        pros.put("mail.smtp.starttls.required", "true");
                        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                        Session mailSession = Session.getDefaultInstance(pros, null);
                        mailSession.setDebug(sessionDebug);
                        Message msg = new MimeMessage(mailSession);
                        msg.setFrom(new InternetAddress(user, "Dai hoc Kien Truc Ha Noi"));
                        InternetAddress[] address = {new InternetAddress(to)};
                        msg.setRecipients(Message.RecipientType.TO, address);
                        msg.setSubject(subject);
                        msg.setContent(message, "text/html; charset=utf-8");
                        Transport transport = mailSession.getTransport("smtp");
                        transport.connect(host, user, pass);
                        transport.sendMessage(msg, msg.getAllRecipients());
                        transport.close();
                        JOptionPane.showMessageDialog(null, "Mã reset đã được gửi tới email của bạn!");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, ex.toString());
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.toString());
        }
    }//GEN-LAST:event_btnLogin1ActionPerformed

    private void txtVertifyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVertifyMouseEntered
        if (txtVertify.getText().equals("Vertify Code")) {
            txtVertify.setText("");
        }
    }//GEN-LAST:event_txtVertifyMouseEntered

    private void txtVertifyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVertifyMouseExited
        if (txtVertify.getText().equals(""))
            txtVertify.setText("Vertify Code");
    }//GEN-LAST:event_txtVertifyMouseExited

    private void btnLogin2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin2MouseEntered
        btnLogin2.setVisible(false);
        btnLogin3.setVisible(true);

    }//GEN-LAST:event_btnLogin2MouseEntered

    private void btnLogin3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin3MouseClicked

    }//GEN-LAST:event_btnLogin3MouseClicked

    private void btnLogin3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogin3MouseExited
        btnLogin2.setVisible(true);
        btnLogin3.setVisible(false);
    }//GEN-LAST:event_btnLogin3MouseExited

    private void btnLogin3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogin3ActionPerformed
        if (txtVertify.getText().equals("Vertify Code") || txtVertify.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã xác nhận!");
            return;
        }
        if (txtVertify.getText().equals(randomCode)) {
            new Reset1(username).setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Mã không khớp, vui lòng thử lại!");
        }
    }//GEN-LAST:event_btnLogin3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.22) {
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

    private void btnSearchEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchEmailActionPerformed
        String quyen = "";
        conn = cn.getConnection();
        try {
            Statement st1 = conn.createStatement();
            ResultSet rs1 = st1.executeQuery("Select * from login where uid='" + txtUid.getText() + "'");
            if (rs1.next()) {
                quyen = rs1.getString("maquyen");
            }
        } catch (Exception e) {
        }

        String check = "";
        if (quyen.equals("SV")) {
            check = "Select email from sinhvien where masv=?";
        } else if (quyen.equals("GV")) {
            check = "Select email from giangvien where magv=?";
        }
        if (txtUid.getText() != null) {
            try {
                conn = cn.getConnection();
                PreparedStatement pst = conn.prepareStatement(check);
                pst.setString(1, txtUid.getText());
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    txtEmail.setText(rs.getString("email"));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Không tồn tại tài khoản này trong hệ thống!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSearchEmailActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_formMouseDragged

    public static void main(String args[]) {
        IntelliJTheme.setup(ForgotPwd.class.getResourceAsStream("/XcodeLight.theme.json"));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPwd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogin1;
    private javax.swing.JButton btnLogin2;
    private javax.swing.JButton btnLogin3;
    private javax.swing.JButton btnSearchEmail;
    private javax.swing.JLabel iconuser;
    private javax.swing.JLabel iconuser1;
    private javax.swing.JLabel iconuser2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUser1;
    private javax.swing.JLabel lblUser2;
    private javax.swing.JLabel main;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUid;
    private javax.swing.JTextField txtVertify;
    // End of variables declaration//GEN-END:variables
}
