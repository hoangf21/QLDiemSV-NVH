package PanelUser;

import Transitions.TransitionsForm;
import ConnectUI.ConnectDB;
import combobox.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class VaoDiem extends TransitionsForm {

    ConnectDB cn = new ConnectDB();
    Connection conn;
    final String header[] = {"Mã SV", "Họ Tên", "Ngày Sinh", "Giới Tính", "Mã Lớp", "Có Điểm"};
    private boolean[] edittable = {false, false, false, false, false, true};
    final DefaultTableModel tb = new DefaultTableModel(header, 0) {
        Class[] type = new Class[]{java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class,};

        public Class getColumnClass(int columnIndex) {
            return type[columnIndex];
        }
    };

    String username;
    String makhoa;
    ResultSet rs;
    String malop, mamon;

    public VaoDiem(String user) {
        this.username = user;
        initComponents();
        loadkhoa();
        AutoCompleteDecorator.decorate(cbKhoa);
        AutoCompleteDecorator.decorate(cbLop);
        AutoCompleteDecorator.decorate(cbMonTC);
        cbMonTC.setEnabled(false);
    }

    public VaoDiem() {
        initComponents();
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

    public void loadlop(String makhoa) {
        try {
            String sql = "select DISTINCT x.malop from pcgiangday x join lop y on x.malop = y.malop "
                    + " WHERE matt='DGD' AND makhoa = '" + makhoa + "' AND magv ='" + username + "'";
            conn = cn.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            cbLop.removeAllItems();
            cbLop.addItem("--Chọn Lớp--");
            while (rs.next()) {
                cbLop.addItem(rs.getString("malop"));
            }
        } catch (Exception e) {
        }
    }

    public void loadm() {
        loadmh m = new loadmh(makhoa, username, malop);
        List<monhoc> list = m.getAllclasses();
        cbMonTC.removeAllItems();
        cbMonTC.addItem("--Chọn Môn TC--");
        list.forEach(o -> {
            cbMonTC.addItem(o);
        });
    }

    public void loadbang(String malop) {
        String sql = "SELECT masv,hoten,ngaysinh,gioitinh,malop FROM dbo.sinhvien where malop='" + malop + "'";
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            tb.setRowCount(0);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {
                Boolean cb = false;
                String mamh = "";
                if (cbMonTC.getSelectedIndex() == 0 || cbMonTC.getSelectedIndex() == -1) {
                    mamh = "";
                } else {
                    monhoc m = (monhoc) cbMonTC.getSelectedItem();
                    mamh = m.getMamh();
                }
                String sql_check = "SELECT mamh FROM dbo.ketqua WHERE masv ='" + rs.getString("masv") + "' AND mamh ='" + mamh + "'";
                Statement st = conn.createStatement();
                ResultSet rss = st.executeQuery(sql_check);
                if (rss.next()) {
                    cb = true;
                } else {
                    cb = false;
                }
                Object personObject[] = {
                    rs.getString("masv"),
                    rs.getString("hoten"),
                    sdf.format(rs.getDate("ngaysinh")),
                    rs.getString("gioitinh"),
                    rs.getString("malop"),
                    cb
                };
                tb.addRow(personObject);
                dgvSinhvien.setModel(tb);
                dgvSinhvien.getColumnModel().getColumn(0).setPreferredWidth(50);
                dgvSinhvien.getColumnModel().getColumn(1).setPreferredWidth(120);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvSinhvien = new javax.swing.JTable();
        cbLop = new javax.swing.JComboBox<>();
        cbMonTC = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        btnNhap = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbKhoa = new javax.swing.JComboBox<>();

        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(985, 556));
        setPreferredSize(new java.awt.Dimension(985, 556));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vào Điểm");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 0, 190, 50));

        dgvSinhvien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dgvSinhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Họ Tên", "Giới Tính", "Ngày Sinh", "Lớp", "Tùy Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvSinhvien.setRowHeight(25);
        jScrollPane1.setViewportView(dgvSinhvien);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 200, 975, 350));

        cbLop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbLop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn Lớp --" }));
        cbLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLopActionPerformed(evt);
            }
        });
        add(cbLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 240, 40));

        cbMonTC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbMonTC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn Môn TC--" }));
        cbMonTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMonTCActionPerformed(evt);
            }
        });
        add(cbMonTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, 230, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Chọn Môn TC:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Chọn Lớp:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 70, 30));

        btnOK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lockcl1.png"))); // NOI18N
        btnOK.setText("Khóa Sửa");
        btnOK.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lockcl2.png"))); // NOI18N
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 140, 40));

        btnNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add1.png"))); // NOI18N
        btnNhap.setText("Nhập Điểm");
        btnNhap.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add2.png"))); // NOI18N
        btnNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapActionPerformed(evt);
            }
        });
        add(btnNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 140, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 350, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Chọn Khoa:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 60, 100, 30));

        cbKhoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoaActionPerformed(evt);
            }
        });
        add(cbKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 90, 230, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        conn = cn.getConnection();
        String sql = "Update pcgiangday set matt='KTGD' where mamh=? and malop =?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, mamon);
            pst.setString(2, cbLop.getSelectedItem().toString());
            int a = pst.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(this, "Thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Thất bại!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        if (dgvSinhvien.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Chọn Sinh Viên");
        } else {
            String masv = dgvSinhvien.getValueAt(dgvSinhvien.getSelectedRow(), 0).toString();
            String malop = cbLop.getSelectedItem().toString();
            khoa x = (khoa) cbKhoa.getSelectedItem();
            String khoa = x.getMakhoa();
            monhoc k = (monhoc) cbMonTC.getSelectedItem();
            String mamh = k.getMamh();
            String tenmh = k.getTenmh();
            int sotc = k.getSotin();
            new PanelAdmin.VaoDiem(masv, malop, khoa, mamh, tenmh, sotc, username).setVisible(true);
        }
    }//GEN-LAST:event_btnNhapActionPerformed

    private void cbKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhoaActionPerformed
        if (cbKhoa.getSelectedIndex() == 0 || cbKhoa.getSelectedIndex() == -1) {
            cbLop.setEnabled(false);
            makhoa = "";
        } else {
            khoa k = (khoa) cbKhoa.getSelectedItem();
            makhoa = k.getMakhoa();
            loadlop(makhoa);
            cbLop.setEnabled(true);
        }
    }//GEN-LAST:event_cbKhoaActionPerformed

    private void cbLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLopActionPerformed
        if (cbLop.getSelectedIndex() == 0 || cbLop.getSelectedIndex() == -1) {
            cbMonTC.setEnabled(false);
            malop = "";
            loadbang(malop);
        } else {
            cbMonTC.setEnabled(true);
            malop = cbLop.getSelectedItem().toString();
            loadbang(malop);
            loadm();
        }
    }//GEN-LAST:event_cbLopActionPerformed

    private void cbMonTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMonTCActionPerformed
        if (cbMonTC.getSelectedIndex() == 0 || cbMonTC.getSelectedIndex() == -1) {
        } else {
            loadbang(malop);
            monhoc m = (monhoc)cbMonTC.getSelectedItem();
            mamon = m.getMamh();
        }
    }//GEN-LAST:event_cbMonTCActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String sql = "SELECT masv,hoten,ngaysinh,gioitinh,malop FROM dbo.sinhvien where malop='" + malop + "' and hoten like N'%" + txtSearch.getText() + "%'";
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            tb.setRowCount(0);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {
                Boolean cb = false;
                String mamh = "";
                if (cbMonTC.getSelectedIndex() == 0 || cbMonTC.getSelectedIndex() == -1) {
                    mamh = "";
                } else {
                    monhoc m = (monhoc) cbMonTC.getSelectedItem();
                    mamh = m.getMamh();
                }
                String sql_check = "SELECT mamh FROM dbo.ketqua WHERE masv ='" + rs.getString("masv") + "' AND mamh ='" + mamh + "'";
                Statement st = conn.createStatement();
                ResultSet rss = st.executeQuery(sql_check);
                if (rss.next()) {
                    cb = true;
                } else {
                    cb = false;
                }
                Object personObject[] = {
                    rs.getString("masv"),
                    rs.getString("hoten"),
                    sdf.format(rs.getDate("ngaysinh")),
                    rs.getString("gioitinh"),
                    rs.getString("malop"),
                    cb
                };
                tb.addRow(personObject);
                dgvSinhvien.setModel(tb);
                dgvSinhvien.getColumnModel().getColumn(0).setPreferredWidth(50);
                dgvSinhvien.getColumnModel().getColumn(1).setPreferredWidth(120);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhap;
    private javax.swing.JButton btnOK;
    private javax.swing.JComboBox<Object> cbKhoa;
    private javax.swing.JComboBox<String> cbLop;
    private javax.swing.JComboBox<Object> cbMonTC;
    private javax.swing.JTable dgvSinhvien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
