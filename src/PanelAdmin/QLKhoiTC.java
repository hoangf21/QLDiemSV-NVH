package PanelAdmin;

import ConnectUI.ConnectDB;
import java.sql.*;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QLKhoiTC extends javax.swing.JPanel {

    ConnectDB cn = new ConnectDB();
    Connection conn;
    final String header[] = {"Mã Khối", "Tên Khối"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);
    ResultSet rs;
    Preferences pref;
    boolean prefReme;

    public QLKhoiTC() {
        initComponents();
        loadbang();
        loadmau();
    }

    public void loadmau(){
        pref = Preferences.userNodeForPackage(this.getClass());
        prefReme = pref.getBoolean("Color", Boolean.valueOf(""));
        if (prefReme) {
            txtKTC.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            btnThem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add" + pref.get("btn", "")+".png")));
            btnSua.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit" + pref.get("btn", "")+".png")));
            btnXoa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete" + pref.get("btn", "")+".png")));
            btnLammoi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh" + pref.get("btn", "")+".png")));
            dgvHK.setSelectionBackground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
        }
    }

    public void xoatrang() {
        txtMaky.setText("");
        txtTenky.setText("");
        loadbang();
    }

    public void loadbang() {
        String sql1 = "select * from nhommonhoc";
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            tb.setRowCount(0);
            while (rs.next()) {
                Object personObject[] = {
                    rs.getString("makhoi"),
                    rs.getString("tenkhoi")
                };
                tb.addRow(personObject);
                dgvHK.setModel(tb);
                dgvHK.getColumnModel().getColumn(1).setPreferredWidth(600);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtKTC = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaky = new javax.swing.JTextField();
        txtTenky = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgvHK = new javax.swing.JTable();

        setBackground(new java.awt.Color(242, 246, 253));
        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(760, 581));
        setPreferredSize(new java.awt.Dimension(760, 581));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtKTC.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtKTC.setForeground(new java.awt.Color(0, 153, 255));
        txtKTC.setText("QUẢN LÝ KHỐI TÍN CHỈ");
        add(txtKTC, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 29));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã khối:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, -1));

        txtMaky.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(txtMaky, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 670, 40));

        txtTenky.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add(txtTenky, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 670, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên khối:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, -1));

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

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 270, 40));

        dgvHK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dgvHK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        dgvHK.setRowHeight(25);
        dgvHK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvHKMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dgvHK);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 740, 350));
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        conn = cn.getConnection();
        String sql = "Insert into nhommonhoc values(?,?)";
        PreparedStatement pst;
        if (txtMaky.getText().equals("") || txtTenky.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập đủ dữ liệu!");
        } else {
            try {
                String sql_check = "Select * from nhommonhoc where makhoi='" + txtMaky.getText() + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql_check);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Đã tồn tại khối TC này!");
                } else {
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, txtMaky.getText());
                    pst.setString(2, txtTenky.getText());
                    int a = pst.executeUpdate();
                    if (a > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm mới thành công!");
                        xoatrang();
                    }
                }
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        conn = cn.getConnection();
        String sql = "Update nhommonhoc set tenkhoi=? where makhoi=?";
        PreparedStatement pst;
        if (txtMaky.getText().equals("") || txtTenky.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nhập đủ dữ liệu!");
        } else {
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(2, txtMaky.getText());
                pst.setString(1, txtTenky.getText());
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
            String sql = "Delete nhommonhoc where makhoi=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtMaky.getText());
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

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        xoatrang();
        btnThem.setEnabled(true);
        txtMaky.setEnabled(true);
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (txtSearch.getText().equals(""))
            loadbang();
        else {
            String search = txtSearch.getText().replaceAll("[-'!]", "");
            String sql = "select * from nhommonhoc where tenkhoi like N'%" + search + "%' or makhoi like N'%" + search + "%'";
            conn = cn.getConnection();
            PreparedStatement pst;
            try {
                pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                tb.setRowCount(0);
                while (rs.next()) {
                    Object personObject[] = {
                        rs.getString("makhoi"),
                        rs.getString("tenkhoi")
                    };
                    tb.addRow(personObject);
                    dgvHK.setModel(tb);
                    dgvHK.getColumnModel().getColumn(1).setPreferredWidth(600);
                }
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void dgvHKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvHKMouseClicked
        if (dgvHK.getSelectedRow() >= 0) {
            int x = dgvHK.getSelectedRow();
            txtMaky.setText(dgvHK.getValueAt(x, 0) + "");
            txtTenky.setText(dgvHK.getValueAt(x, 1) + "");
            txtMaky.setEnabled(false);
        }
    }//GEN-LAST:event_dgvHKMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JTable dgvHK;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel txtKTC;
    private javax.swing.JTextField txtMaky;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTenky;
    // End of variables declaration//GEN-END:variables
}
