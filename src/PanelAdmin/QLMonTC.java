package PanelAdmin;

import ConnectUI.ConnectDB;
import combobox.khoa;
import combobox.khoitc;
import combobox.loadkhoa;
import combobox.loadkhoitc;
import java.sql.*;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class QLMonTC extends javax.swing.JPanel {

    ConnectDB cn = new ConnectDB();
    Connection conn;
    final String header[] = {"Mã Môn", "Tên Môn", "Số Tín", "Khoa"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);
    ResultSet rs;
    String khoa, khoi;

    public QLMonTC() {
        initComponents();
        loadkhoa();
        loadbang();
        loadktc();
        loadmau();
        txtMaMH.setEnabled(false);
        AutoCompleteDecorator.decorate(cbKhoa);
    }
    
    Preferences pref;
    boolean prefReme;
    
    public void loadmau(){
        pref = Preferences.userNodeForPackage(this.getClass());
        prefReme = pref.getBoolean("Color", Boolean.valueOf(""));
        if (prefReme) {
            txtMTC.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            btnThem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add" + pref.get("btn", "")+".png")));
            btnSua.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit" + pref.get("btn", "")+".png")));
            btnXoa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete" + pref.get("btn", "")+".png")));
            btnLammoi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh" + pref.get("btn", "")+".png")));
            dgvTC.setSelectionBackground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
        }
    }
    
    public void loadktc() {
        loadkhoitc m = new loadkhoitc();
        List<khoitc> list = m.getAllclasses();
        cbKhoiTC.removeAllItems();
        cbKhoiTC.addItem("--Chọn Khối TC--");
        list.forEach(o -> {
            cbKhoiTC.addItem(o);
        });
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

    public void loadbang() {
        String sql1 = "select * from monhoc";
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            tb.setRowCount(0);
            while (rs.next()) {
                Object personObject[] = {
                    rs.getString("mamh"),
                    rs.getString("tenmh"),
                    rs.getString("sotin"),
                    rs.getString("makhoa")
                };
                tb.addRow(personObject);
                dgvTC.setModel(tb);
                dgvTC.getColumnModel().getColumn(1).setPreferredWidth(250);
            }
            dgvTC.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (dgvTC.getSelectedRow() >= 0) {
                        int x = dgvTC.getSelectedRow();
                        txtMaMH.setText(dgvTC.getValueAt(x, 0) + "");
                        txtTenMH.setText(dgvTC.getValueAt(x, 1) + "");
                        txtSoTC.setText(dgvTC.getValueAt(x, 2) + "");
                        cbKhoa.setSelectedItem(dgvTC.getModel().getValueAt(x, 3) + "");
                        txtMaMH.setEnabled(false);
                    }
                }
            });
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMTC = new javax.swing.JLabel();
        cbKhoa = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtMaMH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenMH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSoTC = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgvTC = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cbKhoiTC = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(242, 246, 253));
        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(762, 432));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMTC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMTC.setForeground(new java.awt.Color(0, 153, 255));
        txtMTC.setText("QUẢN LÝ MÔN TÍN CHỈ");
        add(txtMTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 29));

        cbKhoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoaActionPerformed(evt);
            }
        });
        add(cbKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 170, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã Môn:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, -1));

        txtMaMH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(txtMaMH, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 150, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Khoa:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên Môn:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 80, -1));

        txtTenMH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(txtTenMH, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 270, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số Tín:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 50, -1));

        txtSoTC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(txtSoTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 270, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 270, 40));

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add1.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add2.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 105, 40));

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit1.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit2.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 105, 40));

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete1.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete2.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 105, 40));

        btnLammoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh1.png"))); // NOI18N
        btnLammoi.setText("Làm Mới");
        btnLammoi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh2.png"))); // NOI18N
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });
        add(btnLammoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 130, 40));

        dgvTC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dgvTC.setModel(new javax.swing.table.DefaultTableModel(
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
        dgvTC.setRowHeight(25);
        jScrollPane2.setViewportView(dgvTC);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 740, 350));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Khối:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, -1));

        cbKhoiTC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbKhoiTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoiTCActionPerformed(evt);
            }
        });
        add(cbKhoiTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 170, 40));
    }// </editor-fold>//GEN-END:initComponents


    private void cbKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhoaActionPerformed
        if (cbKhoa.getSelectedIndex() == 0) {
            loadbang();
            khoa = "";
        } else {
            try {
                khoa k = (khoa) cbKhoa.getSelectedItem();
                khoa = k.getMakhoa();
                String sql1 = "select * from monhoc where makhoa='" + khoa + "'";
                conn = cn.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql1);
                tb.setRowCount(0);
                while (rs.next()) {
                    Object personObject[] = {
                        rs.getString("mamh"),
                        rs.getString("tenmh"),
                        rs.getString("sotin"),
                        rs.getString("makhoa")
                    };
                    tb.addRow(personObject);
                    dgvTC.setModel(tb);
                    dgvTC.getColumnModel().getColumn(1).setPreferredWidth(250);
                }
                conn.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_cbKhoaActionPerformed

    public void automa() {
        String sql = "";
        conn = cn.getConnection();
        if (khoa.equals("CNTT")) {
            sql = "SELECT TOP 1 mamh FROM dbo.monhoc where MAKHOA = 'CNTT' ORDER BY mamh DESC";
        } else if (khoa.equals("KT")) {
            sql = "SELECT TOP 1 mamh FROM dbo.monhoc where MAKHOA = 'KT' ORDER BY mamh DESC";
        } else {
            sql = "";
        }
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String rnno = rs.getString("mamh");
                int co = rnno.length();
                String txt = rnno.substring(0, 5);
                String num = rnno.substring(5, co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                String ftxt = txt + snum;
                txtMaMH.setText(ftxt);

            } else {
            }
        } catch (Exception e) {
        }
    }

    public void xoatrang() {
        txtTenMH.setText("");
        txtSoTC.setText("");
        automa();
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        conn = cn.getConnection();
        String sql = "Insert into monhoc values(?,?,?,?,?)";
        PreparedStatement pst;
        if (txtMaMH.getText().equals("") || txtTenMH.getText().equals("") 
                || txtSoTC.getText().equals("") 
                || cbKhoa.getSelectedIndex() == 0 || cbKhoa.getSelectedIndex() == -1
                || cbKhoiTC.getSelectedIndex() == 0 || cbKhoiTC.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Nhập đủ dữ liệu\n");
        } else if (Integer.parseInt(txtSoTC.getText()) > 10 || Integer.parseInt(txtSoTC.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Số tín chỉ nằm trong khoảng từ 1-10!\n");
        } else {
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, txtMaMH.getText());
                pst.setString(2, txtTenMH.getText());
                pst.setString(3, txtSoTC.getText());
                pst.setString(4, khoa);
                pst.setString(5, khoi);
                int a = pst.executeUpdate();
                if (a > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                    xoatrang();
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        xoatrang();
        btnThem.setEnabled(true);
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        conn = cn.getConnection();
        String sql = "Update monhoc set tenmh=?,sotin=?, makhoa=?, makhoi=? where mamh=?";
        PreparedStatement pst;
        if (txtMaMH.getText().equals("") || txtTenMH.getText().equals("") 
                || txtSoTC.getText().equals("") 
                || cbKhoa.getSelectedIndex() == 0 || cbKhoa.getSelectedIndex() == -1
                || cbKhoiTC.getSelectedIndex() == 0 || cbKhoiTC.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Nhập đủ dữ liệu\n");
        } else if (Integer.parseInt(txtSoTC.getText()) > 10 || Integer.parseInt(txtSoTC.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Số tín chỉ nằm trong khoảng từ 1-10!\n");
        } else {
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(5, txtMaMH.getText());
                pst.setString(1, txtTenMH.getText());
                pst.setString(2, txtSoTC.getText());
                pst.setString(3, khoa);
                pst.setString(4, khoi);
                int a = pst.executeUpdate();
                if (a > 0) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                    xoatrang();
                }
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        try {
            conn = cn.getConnection();
            String sql = "Delete monhoc where mamh=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtMaMH.getText());
            int chk = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (chk == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                pst.executeUpdate();
                loadbang();
                xoatrang();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (txtSearch.getText().equals(""))
            loadbang();
        else {
            String sql = "";
            String search = txtSearch.getText().replaceAll("[-'!]", "");
            if (cbKhoa.getSelectedIndex() == 0) {
                sql = "select * from monhoc where tenmh like N'%" + search + "%'";
            } else if (khoa.equals("KT")) {
                sql = "select * from monhoc where makhoa='KT' and tenmh like N'%" + search + "%'";
            } else if (khoa.equals("CNTT")) {
                sql = "select * from monhoc where makhoa='CNTT' and tenmh like N'%" + search + "%'";
            }
            conn = cn.getConnection();
            PreparedStatement pst;
            try {
                pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                tb.setRowCount(0);
                while (rs.next()) {
                    Object personObject[] = {
                        rs.getString("mamh"),
                        rs.getString("tenmh"),
                        rs.getString("sotin"),
                        rs.getString("makhoa")
                    };
                    tb.addRow(personObject);
                    dgvTC.setModel(tb);
                    dgvTC.getColumnModel().getColumn(1).setPreferredWidth(250);
                }
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cbKhoiTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhoiTCActionPerformed
        if(cbKhoiTC.getSelectedIndex()==0 || cbKhoiTC.getSelectedIndex()==-1){
            khoi="";
        }else{
            khoitc k = (khoitc)cbKhoiTC.getSelectedItem();
            khoi = k.getMakhoi();
        }
    }//GEN-LAST:event_cbKhoiTCActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<Object> cbKhoa;
    private javax.swing.JComboBox<Object> cbKhoiTC;
    private javax.swing.JTable dgvTC;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel txtMTC;
    private javax.swing.JTextField txtMaMH;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoTC;
    private javax.swing.JTextField txtTenMH;
    // End of variables declaration//GEN-END:variables
}
