package PanelAdmin;

import ConnectUI.*;
import dashboardUI.chart.*;
import java.util.*;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Home extends javax.swing.JPanel {

    ConnectDB cn = new ConnectDB();
    Connection conn;
    ResultSet rs;
    Thread thead;

    public Home() {
        initComponents();
        loadmau();
        initData();
        loadanimation();
    }
    
    public void loadanimation(){
        thead = new Thread(){
            @Override
            public void run() {
                String txt = txtSlider.getText();
                while(true){
                    txt = txt.substring(1, txt.length()) + txt.charAt(0);
                    try {
                        sleep(80);
                    } catch (InterruptedException ex) {
                    }
                    txtSlider.setText(txt);
                }
            }
            
        };
        thead.start();
    }

    Preferences pref;
    boolean prefReme;

    private void initData() {
        String sql_tong = "SELECT SUM(solantruycap) AS [Total] FROM dbo.lantruycap";
        String sql = "SELECT id, ngay, solantruycap\n"
                + " FROM dbo.lantruycap x, (SELECT TOP 1 ID AS [stt] FROM dbo.lantruycap ORDER BY id DESC) y\n"
                + " WHERE x.id > y.stt-7";
        try {
            conn = cn.getConnection();
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            List<ModelChartLine> list = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            while (rs.next()) {
                list.add(new ModelChartLine(sdf.format(rs.getDate("ngay")), rs.getInt("solantruycap")));
            }
            chartLine1.setModel(list);
            Statement stt = conn.createStatement();
            ResultSet rss = stt.executeQuery(sql_tong);
            if(rss.next()){
                txtTong.setText(rss.getString("Total"));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void loadmau() {
        pref = Preferences.userNodeForPackage(this.getClass());
        prefReme = pref.getBoolean("Color", Boolean.valueOf(""));
        if (prefReme) {
            txtHome.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            if (pref.get("selected", "").equalsIgnoreCase("Lam")) {
                Lam.setSelected(true);
            } else if (pref.get("selected", "").equalsIgnoreCase("Tim")) {
                Tim.setSelected(true);
            } else if (pref.get("selected", "").equalsIgnoreCase("Cam")) {
                Cam.setSelected(true);
            } else if (pref.get("selected", "").equalsIgnoreCase("Vang")) {
                Vang.setSelected(true);
            } else if (pref.get("selected", "").equalsIgnoreCase("Do")) {
                Do.setSelected(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtHome = new javax.swing.JLabel();
        chartPie1 = new dashboardUI.chart.ChartPie();
        panelBorder1 = new dashboardUI.swing.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        panelBorder2 = new dashboardUI.swing.PanelBorder();
        jLabel4 = new javax.swing.JLabel();
        panelBorder3 = new dashboardUI.swing.PanelBorder();
        jLabel3 = new javax.swing.JLabel();
        panelBorder4 = new dashboardUI.swing.PanelBorder();
        jLabel5 = new javax.swing.JLabel();
        panelBorder5 = new dashboardUI.swing.PanelBorder();
        jLabel6 = new javax.swing.JLabel();
        Tim = new javax.swing.JRadioButton();
        Lam = new javax.swing.JRadioButton();
        Cam = new javax.swing.JRadioButton();
        Do = new javax.swing.JRadioButton();
        Vang = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        chartLine1 = new dashboardUI.chart.ChartLine();
        chartPie2 = new dashboardUI.chart.ChartPie();
        txtSlider = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTong = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 246, 253));
        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(750, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtHome.setForeground(new java.awt.Color(0, 153, 255));
        txtHome.setText("HOME");
        add(txtHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 32));

        chartPie1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBorder1.setBackground(new java.awt.Color(0, 153, 255));
        panelBorder1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BLUE");
        panelBorder1.add(jLabel1, new java.awt.GridBagConstraints());

        chartPie1.add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, 70));

        panelBorder2.setBackground(new java.awt.Color(255, 102, 0));
        panelBorder2.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ORANGE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 38, 25, 39);
        panelBorder2.add(jLabel4, gridBagConstraints);

        chartPie1.add(panelBorder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 110, -1));

        panelBorder3.setBackground(new java.awt.Color(162, 155, 254));
        panelBorder3.setMinimumSize(new java.awt.Dimension(110, 70));
        panelBorder3.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PURPLE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 38, 25, 39);
        panelBorder3.add(jLabel3, gridBagConstraints);

        chartPie1.add(panelBorder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 60, 110, -1));

        panelBorder4.setBackground(new java.awt.Color(254, 202, 87));
        panelBorder4.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("YELLOW");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 38, 25, 39);
        panelBorder4.add(jLabel5, gridBagConstraints);

        chartPie1.add(panelBorder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 110, -1));

        panelBorder5.setBackground(new java.awt.Color(255, 107, 107));
        panelBorder5.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("RED");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 38, 25, 39);
        panelBorder5.add(jLabel6, gridBagConstraints);

        chartPie1.add(panelBorder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 110, -1));

        Tim.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Tim);
        chartPie1.add(Tim, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 145, -1, -1));

        Lam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Lam);
        Lam.setSelected(true);
        chartPie1.add(Lam, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 145, -1, -1));

        Cam.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Cam);
        chartPie1.add(Cam, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 145, -1, -1));

        Do.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Do);
        chartPie1.add(Do, new org.netbeans.lib.awtextra.AbsoluteConstraints(635, 145, -1, -1));

        Vang.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Vang);
        chartPie1.add(Vang, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 145, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Chọn bảng màu:");
        chartPie1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 30));

        add(chartPie1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 720, 180));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Lưu Lại");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, 90, 30));

        chartLine1.setPreferredSize(new java.awt.Dimension(406, 233));
        add(chartLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 720, 233));

        chartPie2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSlider.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSlider.setText("Xin chào cả nhà, Chúc mọi người một ngày mới tốt lành!                           ");
        chartPie2.add(txtSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 420, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Thông tin:");
        chartPie2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 60, 20));

        txtTong.setBackground(new java.awt.Color(255, 255, 255));
        txtTong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtTong.setForeground(new java.awt.Color(255, 102, 102));
        txtTong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTong.setText("0000");
        chartPie2.add(txtTong, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 60, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Tổng lượt truy cập:");
        chartPie2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 110, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/traffic.png"))); // NOI18N
        chartPie2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 9, 15, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alert.png"))); // NOI18N
        chartPie2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 9, 15, 20));

        add(chartPie2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 720, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String a = "", r = "", g = "", b = "", i = "", btn = "";
        if (Lam.isSelected()) {
            r = "0";
            g = "153";
            b = "255";
            a = "Lam";
            i = "l";
            btn = "2";
        } else if (Tim.isSelected()) {
            r = "162";
            g = "155";
            b = "254";
            a = "Tim";
            i = "t";
            btn = "3";
        } else if (Cam.isSelected()) {
            r = "255";
            g = "102";
            b = "0";
            a = "Cam";
            i = "c";
            btn = "4";
        } else if (Vang.isSelected()) {
            r = "254";
            g = "202";
            b = "87";
            a = "Vang";
            i = "v";
            btn = "5";
        } else if (Do.isSelected()) {
            r = "255";
            g = "107";
            b = "107";
            a = "Do";
            i = "d";
            btn = "6";
        }
        pref.put("r", r);
        pref.put("g", g);
        pref.put("b", b);
        pref.put("selected", a);
        pref.put("i", i);
        pref.put("btn", btn);
        pref.putBoolean("Color", true);
        JOptionPane.showMessageDialog(this, "Lưu cài đặt thành công!");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Cam;
    private javax.swing.JRadioButton Do;
    private javax.swing.JRadioButton Lam;
    private javax.swing.JRadioButton Tim;
    private javax.swing.JRadioButton Vang;
    private javax.swing.ButtonGroup buttonGroup1;
    private dashboardUI.chart.ChartLine chartLine1;
    private dashboardUI.chart.ChartPie chartPie1;
    private dashboardUI.chart.ChartPie chartPie2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private dashboardUI.swing.PanelBorder panelBorder1;
    private dashboardUI.swing.PanelBorder panelBorder2;
    private dashboardUI.swing.PanelBorder panelBorder3;
    private dashboardUI.swing.PanelBorder panelBorder4;
    private dashboardUI.swing.PanelBorder panelBorder5;
    private javax.swing.JLabel txtHome;
    private javax.swing.JLabel txtSlider;
    private javax.swing.JLabel txtTong;
    // End of variables declaration//GEN-END:variables
}
