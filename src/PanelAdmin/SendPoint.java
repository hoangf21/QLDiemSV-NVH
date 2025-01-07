package PanelAdmin;

import ConnectUI.ConnectDB;
import combobox.tablepoint;
import java.sql.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class SendPoint extends javax.swing.JFrame {

    int xMouse;
    int yMouse;

    List<tablepoint> table = new ArrayList<>();

    String masv = "", hoten = "";
    ConnectDB cn = new ConnectDB();
    Connection conn;

    public SendPoint() {
        initComponents();
    }

    public SendPoint(String msv) {
        this.masv = msv;
        initComponents();
        loadall();
        setBackground(new Color(0, 0, 0, 0));
        AutoCompleteDecorator.decorate(cbHocKy);
    }

    public void loadall() {
        try {
            conn = cn.getConnection();
            Statement st = conn.createStatement();
            String sql = "select hoten from sinhvien where masv='" + masv + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                hoten = rs.getString("hoten");
                txtHoTen.setText(hoten);
            }
            conn.close();
        } catch (Exception e) {
        }
        loadcbb();
        txtMSV.setText(masv);
    }

    public void loadcbb() {
        try {
            conn = cn.getConnection();
            Statement st = conn.createStatement();
            String sql = "select distinct hocky from ketqua where masv='" + masv + "'";
            ResultSet rs = st.executeQuery(sql);
            cbHocKy.removeAllItems();
            cbHocKy.addItem("--Chọn học kỳ--");
            while (rs.next()) {
                cbHocKy.addItem(rs.getString("hocky"));
            }
            conn.close();
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new dashboardUI.swing.PanelBorder();
        txtHoTen = new javax.swing.JTextField();
        txtMSV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbHocKy = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnHuy = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 270));
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

        panelBorder1.setMinimumSize(new java.awt.Dimension(400, 270));
        panelBorder1.setName(""); // NOI18N
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelBorder1.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 230, 40));

        txtMSV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelBorder1.add(txtMSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Học Kỳ:");
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 105, 80, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã Sinh Viên:");
        panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        cbHocKy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        panelBorder1.add(cbHocKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 380, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Họ Tên:");
        panelBorder1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 80, 30));

        btnHuy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        panelBorder1.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 210, 185, 40));

        btnOk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnOk.setText("Xác Nhận");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        panelBorder1.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 185, 40));

        btnClose.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close copy.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        panelBorder1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, -4, 32, 32));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        try {
            String email = "";
            conn = cn.getConnection();
            Statement st = conn.createStatement();
            String sql = "Select email from sinhvien where masv = '" + masv + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                email = rs.getString("email");
            }
            table.removeAll(table);
            String sql_1 = "";
            if(cbHocKy.getSelectedIndex()==0){
                sql_1 = "SELECT n.masv,n.malop,n.mamh,x.tenmh,x.sotin,n.hocky,n.chuyencan,n.giuaky,n.cuoiky,n.tongket,n.danhgia,n.diemchu "
                + " FROM dbo.ketqua n JOIN dbo.monhoc x ON n.mamh = x.mamh WHERE n.masv = '"+masv+"'";
            }else{
                sql_1 = "SELECT n.masv,n.malop,n.mamh,x.tenmh,x.sotin,n.hocky,n.chuyencan,n.giuaky,n.cuoiky,n.tongket,n.danhgia,n.diemchu "
                + " FROM dbo.ketqua n JOIN dbo.monhoc x ON n.mamh = x.mamh WHERE n.masv = '"+masv+"' and hocky='" + cbHocKy.getSelectedItem() + "'";
            }
            ResultSet rss = st.executeQuery(sql_1);
            while (rss.next()) {
                tablepoint tb = new tablepoint();
                tb.setMasv(rss.getString("masv"));
                tb.setMalop(rss.getString("malop"));
                tb.setMamh(rss.getString("mamh"));
                tb.setTenmh(rss.getString("tenmh"));
                tb.setSotin(rss.getString("sotin"));
                tb.setHocky(rss.getString("hocky"));
                tb.setChuyencan(rss.getString("chuyencan"));
                tb.setGiuaky(rss.getString("giuaky"));
                tb.setCuoiky(rss.getString("cuoiky"));
                tb.setTongket(rss.getString("tongket"));
                tb.setDanhgia(rss.getString("danhgia"));
                tb.setDiemchu(rss.getString("diemchu"));
                table.add(tb);
            }

            StringBuilder sb = new StringBuilder();

            sb.append("<table style='font-size:16px;\n"
                    + "    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n"
                    + "    border-collapse: collapse;\n"
                    + "    border-spacing: 0;\n"
                    + "    width: 100%;'>").append(System.lineSeparator());

            sb.append("\t").append("<tr style=' padding-top: 11px;"
                    + "    padding-bottom: 11px;"
                    + "    background-color: #04AA6D;"
                    + "    color: white;'>").append(System.lineSeparator());

            sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                    + "    text-align: left;"
                    + "    padding: 8px;'>").append("Mã SV").append("</td>").append(System.lineSeparator());
            sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                    + "    text-align: left;"
                    + "    padding: 8px;'>").append("Mã Lớp").append("</td>").append(System.lineSeparator());
            sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                    + "    text-align: left;"
                    + "    padding: 8px;'>").append("Mã MH").append("</td>").append(System.lineSeparator());
            sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                    + "    text-align: left;"
                    + "    padding: 8px;'>").append("Tên MH").append("</td>").append(System.lineSeparator());
            sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                    + "    text-align: left;"
                    + "    padding: 8px;'>").append("Số Tín").append("</td>").append(System.lineSeparator());
            sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                    + "    text-align: left;"
                    + "    padding: 8px;'>").append("Học Kỳ").append("</td>").append(System.lineSeparator());
            sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                    + "    text-align: left;"
                    + "    padding: 8px;'>").append("Chuyên Cần").append("</td>").append(System.lineSeparator());
            sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                    + "    text-align: left;"
                    + "    padding: 8px;'>").append("Giữa Kỳ").append("</td>").append(System.lineSeparator());
            sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                    + "    text-align: left;"
                    + "    padding: 8px;'>").append("Cuối Kỳ").append("</td>").append(System.lineSeparator());
            sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                    + "    text-align: left;"
                    + "    padding: 8px;'>").append("Tổng Kết").append("</td>").append(System.lineSeparator());
            sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                    + "    text-align: left;"
                    + "    padding: 8px;'>").append("Đánh Giá").append("</td>").append(System.lineSeparator());
            sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                    + "    text-align: left;"
                    + "    padding: 8px;'>").append("Điểm Chữ").append("</td>").append(System.lineSeparator());

            sb.append("\t").append("</tr>").append(System.lineSeparator());

            for (tablepoint pd : table) {

                sb.append("\t").append("<tr>").append(System.lineSeparator());

                sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                        + "    text-align: left;"
                        + "    padding: 8px;'>").append(pd.getMasv()).append("</td>").append(System.lineSeparator());
                sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                        + "    text-align: left;"
                        + "    padding: 8px;'>").append(pd.getMalop()).append("</td>").append(System.lineSeparator());
                sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                        + "    text-align: left;"
                        + "    padding: 8px;'>").append(pd.getMamh()).append("</td>").append(System.lineSeparator());
                sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                        + "    text-align: left;"
                        + "    padding: 8px;'>").append(pd.getTenmh()).append("</td>").append(System.lineSeparator());
                sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                        + "    text-align: left;"
                        + "    padding: 8px;'>").append(pd.getSotin()).append("</td>").append(System.lineSeparator());
                sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                        + "    text-align: left;"
                        + "    padding: 8px;'>").append(pd.getHocky()).append("</td>").append(System.lineSeparator());
                sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                        + "    text-align: left;"
                        + "    padding: 8px;'>").append(pd.getChuyencan()).append("</td>").append(System.lineSeparator());
                sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                        + "    text-align: left;"
                        + "    padding: 8px;'>").append(pd.getGiuaky()).append("</td>").append(System.lineSeparator());
                sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                        + "    text-align: left;"
                        + "    padding: 8px;'>").append(pd.getCuoiky()).append("</td>").append(System.lineSeparator());
                sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                        + "    text-align: left;"
                        + "    padding: 8px;'>").append(pd.getTongket()).append("</td>").append(System.lineSeparator());
                sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                        + "    text-align: left;"
                        + "    padding: 8px;'>").append(pd.getDanhgia()).append("</td>").append(System.lineSeparator());
                sb.append("\t").append("\t").append("<td style='border: 1px solid #ddd;"
                        + "    text-align: left;"
                        + "    padding: 8px;'>").append(pd.getDiemchu()).append("</td>").append(System.lineSeparator());

                sb.append("\t").append("</tr>").append(System.lineSeparator());

            }

            sb.append("</table>");

            String host = "smtp.gmail.com";
            String user = "viethoang7012@gmail.com";
            String pass = "diue dkfp gane tvrg";
            String to = email;
            String subject = "Hệ thống gửi điểm";
            String message = "";
            if(cbHocKy.getSelectedIndex()==0){
                message = "<h2 style='color: #e17055'>Xin chào: " + txtHoTen.getText() + "</h2>"
                    + "<h3 style='color: #0984e3'> Bạn vừa nhận được bảng điểm toàn khóa từ hệ thống gửi điểm</h3>\n"
                    + sb.toString();
            }else{
                message = "<h2 style='color: #e17055'>Xin chào: " + txtHoTen.getText() + "</h2>"
                    + "<h3 style='color: #0984e3'> Bạn vừa nhận được bảng điểm kỳ: " + cbHocKy.getSelectedItem() + " từ hệ thống gửi điểm</h3>\n"
                    + sb.toString();
            }
            boolean sessionDebug = false;
            Properties pros = System.getProperties();
            pros.put("mail.smtp.starttls.enable", "true");
            pros.put("mail.smtp.host", "host");
            pros.put("mail.smtp.port", "587");
            pros.put("mail.smtp.auth", "true");
            pros.put("mail.smtp.starttls.required", "true");
            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(pros, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(user, "Dai Hoc Kien Truc Ha Noi"));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setContent(message, "text/html; charset=utf-8");
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            JOptionPane.showMessageDialog(null, "Gửi thành công!");

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnHuyActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SendPoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendPoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendPoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendPoint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendPoint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnOk;
    private javax.swing.JComboBox<String> cbHocKy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private dashboardUI.swing.PanelBorder panelBorder1;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMSV;
    // End of variables declaration//GEN-END:variables
}
