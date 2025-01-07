package PanelAdmin;

import ConnectUI.*;
import combobox.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class VaoDiem extends javax.swing.JFrame {

    Preferences pref;
    boolean prefReme;
    
    int xMouse, yMouse;
    ConnectDB cn = new ConnectDB();
    Connection conn;
    final String header[] = {"Mã HP", "Tên HP", "Số Tín", "Chuyên Cần", "Giữa Kỳ", "Cuối Kỳ", "Tổng Kết", "Đánh Giá", "Điểm Chữ"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);
    ResultSet rs;
    String msv, lop, khoa, khoi, mamh, tenmh, magv;
    int sotc;

    public VaoDiem() {
        initComponents();
    }
    
    public void loadmau(){
        pref = Preferences.userNodeForPackage(this.getClass());
        prefReme = pref.getBoolean("Color", Boolean.valueOf(""));
        if (prefReme) {
            txtNDSV.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            btnThem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add" + pref.get("btn", "")+".png")));
            btnSua.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit" + pref.get("btn", "")+".png")));
            btnTinh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gpa" + pref.get("btn", "")+".png")));
            btnLammoi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh" + pref.get("btn", "")+".png")));
            dgvSinhvien.setSelectionBackground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
        }
    }

    public VaoDiem(String masv, String malop, String makhoa, String mamh, String tenmh, int sotc, String username) {
        this.msv = masv;
        this.lop = malop;
        this.khoa = makhoa;
        this.mamh = mamh;
        this.tenmh = tenmh;
        this.sotc = sotc;
        this.magv = username;
        initComponents();
        reme();
        setBackground(new Color(0, 0, 0, 0));
        loadbang();
        loadKhoa();
        loadmau();
        AutoCompleteDecorator.decorate(cbKhoiTC);
        AutoCompleteDecorator.decorate(cbMonTC);
        txtMaSV.setText(msv);
        txtMaLop.setText(lop);
        txtKhoa.setText(khoa);
        txtKhoa.setEnabled(false);
        txtMaSV.setEnabled(false);
        txtTenMon.setEnabled(false);
        txtMaLop.setEnabled(false);
        txtTK.setEnabled(false);
        txtDC.setEnabled(false);
        txtDG.setEnabled(false);
        txtSoTC.setEnabled(false);
        if (mamh.equals("") || tenmh.equals("") || sotc == 0 || magv.equals("")) {

        } else {
            cbKhoiTC.setEnabled(false);
            cbMonTC.setSelectedItem(tenmh);
            txtTenMon.setText(mamh);
            txtSoTC.setText(sotc + "");
            String hocky = "";
            try {
                conn = cn.getConnection();
                String sql = "SELECT hocky FROM dbo.pcgiangday\n"
                        + "WHERE magv = '"+magv+"' \n"
                        + "AND matt ='DGD'\n"
                        + "AND malop = '"+malop+"'\n"
                        + "AND mamh = '"+mamh+"'";
                Statement st = conn.createStatement();
                rs = st.executeQuery(sql);
                if (rs.next()) {
                    hocky = rs.getString("hocky");
                }
            } catch (Exception e) {
            }
            int kitu = hocky.length();
            String namtu = hocky.substring(0, 4);
            String namden = hocky.substring(5, 9);
            String ki = hocky.substring(10, kitu);
            txtNamTu.setText(namtu);
            txtNamDen.setText(namden);
            cbHocKy.setSelectedItem(ki);
        }
    }

    public void loadbang() {
        String sql1 = "SELECT n.mamh,x.tenmh,x.sotin,n.chuyencan,n.giuaky,n.cuoiky,n.tongket,n.danhgia,n.diemchu "
                + " FROM dbo.ketqua n JOIN dbo.monhoc x ON n.mamh = x.mamh WHERE n.masv = ?";
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            int sodong;
            Vector row;
            pst = conn.prepareStatement(sql1);
            pst.setString(1, msv);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData metadata = rs.getMetaData();
            sodong = metadata.getColumnCount();
            tb.setRowCount(0);
            while (rs.next()) {
                row = new Vector();
                for (int i = 1; i <= sodong; i++) {
                    row.addElement(rs.getString(i));
                }
                tb.addRow(row);
                dgvSinhvien.setModel(tb);
                dgvSinhvien.getColumnModel().getColumn(0).setPreferredWidth(50);
                dgvSinhvien.getColumnModel().getColumn(1).setPreferredWidth(230);
                dgvSinhvien.getColumnModel().getColumn(2).setPreferredWidth(30);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void loadKhoa() {
        loadkhoitc m = new loadkhoitc();
        List<khoitc> list = m.getAllclasses();
        cbKhoiTC.removeAllItems();
        cbKhoiTC.addItem("--Chọn Khối TC--");
        list.forEach(o -> {
            cbKhoiTC.addItem(o);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        dgvSinhvien = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        panelBorder1 = new dashboardUI.swing.PanelBorder();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnTinh = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        cbKhoiTC = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbMonTC = new javax.swing.JComboBox<>();
        txtNDSV = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenMon = new javax.swing.JTextField();
        txtMaSV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaLop = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNamDen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbHocKy = new javax.swing.JComboBox<>();
        txtNamTu = new javax.swing.JTextField();
        txtCC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtGK = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        txtCK = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDC = new javax.swing.JTextField();
        txtDG = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtSoTC = new javax.swing.JTextField();
        btnLammoi = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtKhoa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(950, 600));
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dgvSinhvien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dgvSinhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        dgvSinhvien.setRowHeight(25);
        dgvSinhvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvSinhvienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dgvSinhvien);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 930, 230));

        btnClose.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close copy.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, -1, 32, 32));

        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add1.png"))); // NOI18N
        btnThem.setText("Vào điểm");
        btnThem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add2.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        panelBorder1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 160, 40));

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit1.png"))); // NOI18N
        btnSua.setText("Cập nhật");
        btnSua.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit2.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        panelBorder1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 300, 160, 40));

        btnTinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gpa.png"))); // NOI18N
        btnTinh.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gpa2.png"))); // NOI18N
        btnTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhActionPerformed(evt);
            }
        });
        panelBorder1.add(btnTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 300, 50, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelBorder1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, 340, 40));

        cbKhoiTC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbKhoiTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoiTCActionPerformed(evt);
            }
        });
        panelBorder1.add(cbKhoiTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 190, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Chọn khối TC:");
        panelBorder1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Môn TC:");
        panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 40));

        cbMonTC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbMonTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonTCActionPerformed(evt);
            }
        });
        panelBorder1.add(cbMonTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 190, 40));

        txtNDSV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtNDSV.setForeground(new java.awt.Color(0, 153, 255));
        txtNDSV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNDSV.setText("NHẬP ĐIỂM SINH VIÊN");
        panelBorder1.add(txtNDSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 230, 29));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Chọn môn TC:");
        panelBorder1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, 20));

        txtTenMon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtTenMon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 190, 40));

        txtMaSV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtMaSV, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 170, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mã SV:");
        panelBorder1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 80, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã Lớp:");
        panelBorder1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 80, 20));

        txtMaLop.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtMaLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 170, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Năm học:");
        panelBorder1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 80, 20));

        txtNamDen.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtNamDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 110, 80, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Học kì:");
        panelBorder1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 70, 20));

        cbHocKy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbHocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        panelBorder1.add(cbHocKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 180, 40));

        txtNamTu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtNamTu, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 85, 40));

        txtCC.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 130, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Chuyên cần:");
        panelBorder1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 80, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Giữa kỳ:");
        panelBorder1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 220, 80, 20));

        txtGK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtGK, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 240, 130, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Tổng Kết:");
        panelBorder1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 220, 80, 20));

        txtTK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 240, 130, 40));

        txtCK.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtCK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCKKeyReleased(evt);
            }
        });
        panelBorder1.add(txtCK, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 130, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Cuối kỳ:");
        panelBorder1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 80, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Điểm Chữ:");
        panelBorder1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 220, 80, 20));

        txtDC.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtDC, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 130, 40));

        txtDG.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 130, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Đánh giá:");
        panelBorder1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, 80, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Số TC:");
        panelBorder1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 80, 20));

        txtSoTC.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtSoTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 180, 40));

        btnLammoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh1.png"))); // NOI18N
        btnLammoi.setText("Làm Mới");
        btnLammoi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh2.png"))); // NOI18N
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });
        panelBorder1.add(btnLammoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 160, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Khoa:");
        panelBorder1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 80, 20));

        txtKhoa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        panelBorder1.add(txtKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 170, 40));

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void dgvSinhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvSinhvienMouseClicked
        int x = dgvSinhvien.getSelectedRow();
        String mamh = dgvSinhvien.getValueAt(x, 0).toString();
        txtCC.setText(dgvSinhvien.getValueAt(x, 3) + "");
        txtGK.setText(dgvSinhvien.getValueAt(x, 4) + "");
        txtCK.setText(dgvSinhvien.getValueAt(x, 5) + "");
        txtTK.setText(dgvSinhvien.getValueAt(x, 6) + "");
        txtDG.setText(dgvSinhvien.getValueAt(x, 7) + "");
        txtDC.setText(dgvSinhvien.getValueAt(x, 8) + "");
        cbMonTC.setSelectedItem(dgvSinhvien.getValueAt(x, 1) + "");
        txtSoTC.setText(dgvSinhvien.getValueAt(x, 2) + "");
        txtTenMon.setText(mamh);
        String hocky = "";
        try {
            conn = cn.getConnection();
            String sql = "Select hocky from ketqua where masv ='" + msv + "' and mamh='" + mamh + "'";
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()) {
                hocky = rs.getString("hocky");
            }
        } catch (Exception e) {
        }
        int kitu = hocky.length();
        String namtu = hocky.substring(0, 4);
        String namden = hocky.substring(5, 9);
        String ki = hocky.substring(10, kitu);
        txtNamTu.setText(namtu);
        txtNamDen.setText(namden);
        cbHocKy.setSelectedItem(ki);
        btnThem.setEnabled(false);
    }//GEN-LAST:event_dgvSinhvienMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    public void xoatrang() {
        txtCC.setText(0 + "");
        txtGK.setText(0 + "");
        txtCK.setText(0 + "");
        txtTK.setText(0 + "");
        txtDC.setText("");
        txtDG.setText("");
        txtNamTu.setText("");
        txtNamDen.setText("");
        btnThem.setEnabled(true);

    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtNamTu.getText().equals("") || txtNamDen.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập năm");
            return;
        }
        String masv = txtMaSV.getText();
        String malop = txtMaLop.getText();
        String mamh = txtTenMon.getText();
        String hocky = txtNamTu.getText() + "_" + txtNamDen.getText() + "_" + cbHocKy.getSelectedItem().toString();
        String cc = txtCC.getText();
        String gk = txtGK.getText();
        String ck = txtCK.getText();
        String tk = txtTK.getText();
        String danhgia = txtDG.getText();
        String diemchu = txtDC.getText();
        String sql = "Insert into ketqua values(?,?,?,?,?,?,?,?,?,?)";
        conn = cn.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, masv);
            pst.setString(2, malop);
            pst.setString(3, mamh);
            pst.setString(4, hocky);
            pst.setString(5, cc);
            pst.setString(6, gk);
            pst.setString(7, ck);
            pst.setString(8, tk);
            pst.setString(9, danhgia);
            pst.setString(10, diemchu);
            int daxua = pst.executeUpdate();
            if (daxua > 0) {
                JOptionPane.showMessageDialog(this, "Thành công!");
                loadbang();
                xoatrang();
            } else {
                JOptionPane.showMessageDialog(this, "Thất bại!");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (txtNamTu.getText().equals("") || txtNamDen.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập năm");
            return;
        }
        String masv = txtMaSV.getText();
        String mamh = dgvSinhvien.getValueAt(dgvSinhvien.getSelectedRow(), 0).toString();
        String cc = txtCC.getText();
        String gk = txtGK.getText();
        String ck = txtCK.getText();
        String tk = txtTK.getText();
        String danhgia = txtDG.getText();
        String diemchu = txtDC.getText();
        String sql = "Update ketqua set chuyencan=?,giuaky=?,cuoiky=?,tongket=?,danhgia=?,diemchu=? where masv=? and mamh=?";
        conn = cn.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cc);
            pst.setString(2, gk);
            pst.setString(3, ck);
            pst.setString(4, tk);
            pst.setString(5, danhgia);
            pst.setString(6, diemchu);
            pst.setString(7, masv);
            pst.setString(8, mamh);
            int daxua = pst.executeUpdate();
            if (daxua > 0) {
                JOptionPane.showMessageDialog(this, "Thành công!");
                loadbang();
                xoatrang();
            } else {
                JOptionPane.showMessageDialog(this, "Thất bại!");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhActionPerformed
        float cc = 0, gk = 0, ck = 0, tk = 0;
        StringBuffer sb = new StringBuffer();
        if (Float.parseFloat(txtCC.getText()) > 10 || Float.parseFloat(txtCC.getText()) < 0 || Float.parseFloat(txtGK.getText()) > 10 || Float.parseFloat(txtGK.getText()) < 0 || Float.parseFloat(txtCK.getText()) > 10 || Float.parseFloat(txtCK.getText()) < 0) {
            sb.append("Điểm phải nằm trong khoảng từ 0 đến 10");
        }
        if (txtCC.getText().equals("")) {
            sb.append("Nhập điểm chuyên cần\n");
        }
        if (txtGK.getText().equals("")) {
            sb.append("Nhập điểm giữa kì\n");
        }
        if (txtCC.getText().equals("")) {
            sb.append("Nhập điểm cuối kì\n");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString());
            return;
        }
        if (txtCK.getText().equals("")) {
        } else {
            cc = Float.parseFloat(txtCC.getText());
            gk = Float.parseFloat(txtGK.getText());
            ck = Float.parseFloat(txtCK.getText());
            tk = (float) (cc * 0.1 + gk * 0.2 + ck * 0.7);
            txtTK.setText((float) Math.round(tk * 10) / 10 + "");
            if (tk < 4) {
                txtDG.setText("THILAI");
            } else if (tk >= 4 && tk <= 10) {
                txtDG.setText("DAT");
            }
            if (tk < 4 && tk >= 0) {
                txtDC.setText("F");
            } else if (tk >= 4 && tk < 5) {
                txtDC.setText("D");
            } else if (tk >= 5 && tk < 5.5) {
                txtDC.setText("D+");
            } else if (tk >= 5.5 && tk < 6) {
                txtDC.setText("C");
            } else if (tk >= 6 && tk < 7) {
                txtDC.setText("C+");
            } else if (tk >= 7 && tk < 8) {
                txtDC.setText("B");
            } else if (tk >= 8 && tk <= 8.4) {
                txtDC.setText("B+");
            } else {
                txtDC.setText("A");
            }
        }
    }//GEN-LAST:event_btnTinhActionPerformed

    public void loadmontc() {
        loadtenmh m = new loadtenmh(khoa, msv, khoi);
        List<monhoc> list = m.getAllclasses();
        cbMonTC.removeAllItems();
        cbMonTC.addItem("--Chọn Môn TC--");
        list.forEach(o -> {
            cbMonTC.addItem(o);
        });
    }

    private void cbKhoiTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhoiTCActionPerformed
        if (cbKhoiTC.getSelectedIndex() == 0 || cbKhoiTC.getSelectedIndex() == -1) {
            cbMonTC.setEnabled(false);
            khoi = "";
        } else {
            cbMonTC.setEnabled(true);
            khoitc m = (khoitc) cbKhoiTC.getSelectedItem();
            khoi = m.getMakhoi();
            loadmontc();
        }
    }//GEN-LAST:event_cbKhoiTCActionPerformed

    private void cbMonTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonTCActionPerformed
        if (cbMonTC.getSelectedIndex() == 0 || cbMonTC.getSelectedIndex() == -1) {
        } else {
            monhoc k = (monhoc) cbMonTC.getSelectedItem();
            txtTenMon.setText(k.getMamh());
            txtSoTC.setText(k.getSotin() + "");
        }
    }//GEN-LAST:event_cbMonTCActionPerformed

    private void txtCKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCKKeyReleased

    }//GEN-LAST:event_txtCKKeyReleased

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        xoatrang();
    }//GEN-LAST:event_btnLammoiActionPerformed

    public void reme() {
        pref = Preferences.userNodeForPackage(PCGiangDay.class);
        prefReme = pref.getBoolean("Rememky", Boolean.valueOf(""));
        if (prefReme) {
            txtNamTu.setText(pref.get("Tu", ""));
            txtNamDen.setText(pref.get("Den", ""));
            cbHocKy.setSelectedItem(pref.get("Ky", ""));
        }
    }
    
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
            java.util.logging.Logger.getLogger(VaoDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VaoDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VaoDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VaoDiem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VaoDiem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTinh;
    private javax.swing.JComboBox<String> cbHocKy;
    private javax.swing.JComboBox<Object> cbKhoiTC;
    private javax.swing.JComboBox<Object> cbMonTC;
    private javax.swing.JTable dgvSinhvien;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private dashboardUI.swing.PanelBorder panelBorder1;
    private javax.swing.JTextField txtCC;
    private javax.swing.JTextField txtCK;
    private javax.swing.JTextField txtDC;
    private javax.swing.JTextField txtDG;
    private javax.swing.JTextField txtGK;
    private javax.swing.JTextField txtKhoa;
    private javax.swing.JTextField txtMaLop;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JLabel txtNDSV;
    private javax.swing.JTextField txtNamDen;
    private javax.swing.JTextField txtNamTu;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoTC;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTenMon;
    // End of variables declaration//GEN-END:variables
}
