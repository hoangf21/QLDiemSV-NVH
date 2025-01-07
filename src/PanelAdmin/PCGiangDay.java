package PanelAdmin;

import ConnectUI.ConnectDB;
import combobox.*;
import java.sql.*;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class PCGiangDay extends javax.swing.JPanel {

    Preferences pref;
    boolean prefReme;

    ConnectDB cn = new ConnectDB();
    Connection conn;
    ResultSet rs;

    final String header[] = {"Mã GV", "Họ Tên", "Mã Môn Học", "Tên Môn Học", "Lớp", "Học Kỳ"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);

    String khoa, khoitc, lop, magv, montc;

    String tu = "", den = "", ky = "";

    public void reme() {
        pref = Preferences.userNodeForPackage(this.getClass());
        prefReme = pref.getBoolean("Rememky", Boolean.valueOf(""));
        if (prefReme) {
            txtTu.setText(pref.get("Tu", ""));
            txtDen.setText(pref.get("Den", ""));
            cbHocKy.setSelectedItem(pref.get("Ky", ""));
        }
    }
    
    public void loadmau(){
        pref = Preferences.userNodeForPackage(this.getClass());
        prefReme = pref.getBoolean("Color", Boolean.valueOf(""));
        if (prefReme) {
            txtPCGD.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            btnThem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add" + pref.get("btn", "")+".png")));
            btnSua.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit" + pref.get("btn", "")+".png")));
            btnXoa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete" + pref.get("btn", "")+".png")));
            btnLammoi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh" + pref.get("btn", "")+".png")));
            dgvPCGD.setSelectionBackground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
        }
    }

    public void loadbang() {
        String sql1 = "SELECT x.magv, y.hoten, x.mamh, z.tenmh , x.malop, x.hocky\n"
                + " FROM pcgiangday x \n"
                + " JOIN dbo.giangvien y ON y.magv = x.magv\n"
                + " JOIN dbo.monhoc z ON z.mamh = x.mamh\n"
                + " WHERE x.matt = 'DGD'";
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            tb.setRowCount(0);
            while (rs.next()) {
                Object personObject[] = {
                    rs.getString("magv"),
                    rs.getString("hoten"),
                    rs.getString("mamh"),
                    rs.getString("tenmh"),
                    rs.getString("malop"),
                    rs.getString("hocky")
                };
                tb.addRow(personObject);
                dgvPCGD.setModel(tb);
                dgvPCGD.getColumnModel().getColumn(3).setPreferredWidth(200);
                dgvPCGD.getColumnModel().getColumn(1).setPreferredWidth(100);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void loadkhoa() {
        loadkhoa lk = new loadkhoa();
        List<khoa> list = lk.getAllclasses();
        cbKhoa.removeAllItems();
        cbKhoa.addItem("--Chọn Khoa--");
        list.forEach(o -> {
            cbKhoa.addItem(o);
        });
    }

    public void loadgv() {
        loadgv lk = new loadgv();
        List<giangvien> list = lk.getAllclasses();
        cbGV.removeAllItems();
        cbGV.addItem("--Chọn Giảng Viên--");
        list.forEach(o -> {
            cbGV.addItem(o);
        });
    }

    public void loadkhoitc() {
        loadkhoitc m = new loadkhoitc();
        List<khoitc> list = m.getAllclasses();
        cbKhoiTC.removeAllItems();
        cbKhoiTC.addItem("--Chọn Khối TC--");
        list.forEach(o -> {
            cbKhoiTC.addItem(o);
        });
    }

    public PCGiangDay() {
        initComponents();
        reme();
        loadkhoa();
        loadbang();
        loadmau();
        cbGV.setEnabled(false);
        cbLop.setEnabled(false);
        cbKhoiTC.setEnabled(false);
        cbMonTC.setEnabled(false);
        AutoCompleteDecorator.decorate(cbKhoa);
        AutoCompleteDecorator.decorate(cbLop);
        AutoCompleteDecorator.decorate(cbGV);
        AutoCompleteDecorator.decorate(cbKhoiTC);
        AutoCompleteDecorator.decorate(cbMonTC);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPCGD = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvPCGD = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        txtDen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTu = new javax.swing.JTextField();
        cbHocKy = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        cbLop = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbGV = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbKhoiTC = new javax.swing.JComboBox<>();
        cbKhoa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbMonTC = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 246, 253));
        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(750, 580));
        setPreferredSize(new java.awt.Dimension(750, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPCGD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtPCGD.setForeground(new java.awt.Color(0, 153, 255));
        txtPCGD.setText("PHÂN CÔNG GIẢNG DẠY");
        add(txtPCGD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 29));

        dgvPCGD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dgvPCGD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dgvPCGD.setRowHeight(25);
        dgvPCGD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvPCGDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dgvPCGD);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 740, 240));

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add1.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add2.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 105, 40));

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit1.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit2.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 105, 40));

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete1.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete2.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 105, 40));

        btnLammoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh1.png"))); // NOI18N
        btnLammoi.setText("Làm Mới");
        btnLammoi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh2.png"))); // NOI18N
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });
        add(btnLammoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 130, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 270, 40));

        txtDen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(txtDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 120, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Học Kỳ:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 80, 40));

        txtTu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(txtTu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 120, 40));

        cbHocKy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbHocKy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        add(cbHocKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 180, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Chọn Lớp:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 120, 120, 30));

        btnOK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOK.setText("Lưu Lại");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 90, 40));

        cbLop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLopActionPerformed(evt);
            }
        });
        add(cbLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 150, 210, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Năm Học:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, 40));

        cbGV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGVActionPerformed(evt);
            }
        });
        add(cbGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 210, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Chọn Giảng Viên:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 120, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Chọn Khối Tín Chỉ:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 120, 30));

        cbKhoiTC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbKhoiTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoiTCActionPerformed(evt);
            }
        });
        add(cbKhoiTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 340, 40));

        cbKhoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoaActionPerformed(evt);
            }
        });
        add(cbKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 210, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Chọn Khoa:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, 30));

        cbMonTC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbMonTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonTCActionPerformed(evt);
            }
        });
        add(cbMonTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 340, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Chọn Môn Tín Chỉ:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 120, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (cbKhoa.getSelectedIndex() == 0 || cbKhoa.getSelectedIndex() == -1
                || cbLop.getSelectedIndex() == 0 || cbLop.getSelectedIndex() == -1
                || cbGV.getSelectedIndex() == 0 || cbGV.getSelectedIndex() == -1
                || cbKhoiTC.getSelectedIndex() == 0 || cbKhoiTC.getSelectedIndex() == -1
                || cbMonTC.getSelectedIndex() == 0 || cbMonTC.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đủ dữ liệu");
        } else {
            conn = cn.getConnection();
            String sql = "Insert into pcgiangday values(?,?,?,?,?)";
            String hocky = txtTu.getText() + "_" + txtDen.getText() + "_" + cbHocKy.getSelectedItem();
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, magv);
                pst.setString(2, montc);
                pst.setString(3, lop);
                pst.setString(4, hocky);
                pst.setString(5, "DGD");
                int a = pst.executeUpdate();
                if (a > 0) {
                    JOptionPane.showMessageDialog(this, "Phân công thành công!");
                    lammoi();
                } else {
                    JOptionPane.showMessageDialog(this, "Phân công thất bại!");
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    public void lammoi() {
        cbKhoa.setSelectedIndex(0);
        cbLop.setSelectedIndex(0);
        cbGV.setSelectedIndex(0);
        cbMonTC.setSelectedIndex(0);
        cbKhoiTC.setSelectedIndex(0);
        loadbang();
    }

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (dgvPCGD.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dữ liệu!");
        } else {
            conn = cn.getConnection();
            String sql = "Update pcgiangday set magv=? where mamh=? and malop =?";
            String mon = dgvPCGD.getValueAt(dgvPCGD.getSelectedRow(), 2) + "";
            String lopsua = dgvPCGD.getValueAt(dgvPCGD.getSelectedRow(), 4) + "";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, magv);
                pst.setString(2, mon);
                pst.setString(3, lopsua);
                int a = pst.executeUpdate();
                if (a > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công!");
                    lammoi();
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại!");
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (dgvPCGD.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dữ liệu!");
        } else {
            conn = cn.getConnection();
            String sql = "Delete pcgiangday where mamh=? and malop=?";
            String mon = dgvPCGD.getValueAt(dgvPCGD.getSelectedRow(), 2) + "";
            String lopsua = dgvPCGD.getValueAt(dgvPCGD.getSelectedRow(), 4) + "";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, mon);
                pst.setString(2, lopsua);
                int chk = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (chk == JOptionPane.YES_OPTION) {
                    int a = pst.executeUpdate();
                    if (a > 0) {
                        JOptionPane.showMessageDialog(this, "Xóa thành công!");
                        lammoi();
                    } else {
                        JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                    }
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        lammoi();
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if(txtSearch.getText().equals("")){
            loadbang();
        }else{
            String sql1 = "SELECT x.magv, y.hoten, x.mamh, z.tenmh , x.malop, x.hocky\n"
                + " FROM pcgiangday x \n"
                + " JOIN dbo.giangvien y ON y.magv = x.magv\n"
                + " JOIN dbo.monhoc z ON z.mamh = x.mamh\n"
                + " WHERE x.matt = 'DGD' AND x.malop like N'%"+txtSearch.getText()+"%'";
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            tb.setRowCount(0);
            while (rs.next()) {
                Object personObject[] = {
                    rs.getString("magv"),
                    rs.getString("hoten"),
                    rs.getString("mamh"),
                    rs.getString("tenmh"),
                    rs.getString("malop"),
                    rs.getString("hocky")
                };
                tb.addRow(personObject);
                dgvPCGD.setModel(tb);
                dgvPCGD.getColumnModel().getColumn(3).setPreferredWidth(200);
                dgvPCGD.getColumnModel().getColumn(1).setPreferredWidth(100);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        pref.put("Tu", txtTu.getText());
        pref.put("Den", txtDen.getText());
        pref.put("Ky", cbHocKy.getSelectedItem().toString());
        pref.putBoolean("Rememky", true);
        JOptionPane.showMessageDialog(this, "Lưu Kỳ Thành Công!");
    }//GEN-LAST:event_btnOKActionPerformed

    public void loadlop() {
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("select * from lop where makhoa='" + khoa + "'");
            rs = pst.executeQuery();
            cbLop.removeAllItems();
            cbLop.addItem("--Chọn Lớp--");
            while (rs.next()) {
                cbLop.addItem(rs.getString("malop"));
            }
            conn.close();
        } catch (SQLException e) {
        }
    }

    private void cbKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhoaActionPerformed
        if (cbKhoa.getSelectedIndex() == 0 || cbKhoa.getSelectedIndex() == -1) {
            cbLop.setEnabled(false);
            cbGV.setEnabled(false);
            cbKhoiTC.setEnabled(false);
            khoa = "";
        } else {
            cbLop.setEnabled(true);
            cbGV.setEnabled(true);
            cbKhoiTC.setEnabled(true);
            khoa k = (khoa) cbKhoa.getSelectedItem();
            khoa = k.getMakhoa();
            loadlop();
            loadgv();
            loadkhoitc();
        }
    }//GEN-LAST:event_cbKhoaActionPerformed

    public void loadmontc() {
        loadtenmh1 m = new loadtenmh1(khoa, khoitc, lop);
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
            khoitc = "";
        } else {
            cbMonTC.setEnabled(true);
            khoitc m = (khoitc) cbKhoiTC.getSelectedItem();
            khoitc = m.getMakhoi();
            loadmontc();
        }
    }//GEN-LAST:event_cbKhoiTCActionPerformed

    private void cbLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLopActionPerformed
        if (cbLop.getSelectedIndex() == 0 || cbLop.getSelectedIndex() == -1) {
            lop = "";
        } else {
            lop = cbLop.getSelectedItem().toString();
        }
    }//GEN-LAST:event_cbLopActionPerformed

    private void cbGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGVActionPerformed
        if (cbGV.getSelectedIndex() == 0 || cbGV.getSelectedIndex() == -1) {
            magv = "";
        } else {
            giangvien gv = (giangvien) cbGV.getSelectedItem();
            magv = gv.getMagv();
        }
    }//GEN-LAST:event_cbGVActionPerformed

    private void cbMonTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonTCActionPerformed
        if (cbMonTC.getSelectedIndex() == 0 || cbMonTC.getSelectedIndex() == -1) {
            montc = "";
        } else {
            monhoc k = (monhoc) cbMonTC.getSelectedItem();
            montc = k.getMamh();
        }
    }//GEN-LAST:event_cbMonTCActionPerformed

    private void dgvPCGDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvPCGDMouseClicked

    }//GEN-LAST:event_dgvPCGDMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<Object> cbGV;
    private javax.swing.JComboBox<String> cbHocKy;
    private javax.swing.JComboBox<Object> cbKhoa;
    private javax.swing.JComboBox<Object> cbKhoiTC;
    private javax.swing.JComboBox<String> cbLop;
    private javax.swing.JComboBox<Object> cbMonTC;
    private javax.swing.JTable dgvPCGD;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDen;
    private javax.swing.JLabel txtPCGD;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTu;
    // End of variables declaration//GEN-END:variables
}
