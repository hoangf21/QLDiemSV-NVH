package PanelAdmin;

import ConnectUI.*;
import combobox.khoa;
import combobox.loadkhoa;
import java.awt.Image;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class QLGiangVien extends javax.swing.JPanel {

    ConnectDB cn = new ConnectDB();
    String quyen = "GV";
    Connection conn;
    final String header[] = {"Mã GV", "Họ Tên", "Ngày Sinh", "Giới Tính", "Điện Thoại", "Email", "Địa Chỉ", "Mã Khoa"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);
    ResultSet rs;
    byte[] anhSV;
    String khoa;

    public QLGiangVien() {
        initComponents();
        loadKhoa();
        loadbang();
        loadmau();
    }

    Preferences pref;
    boolean prefReme;

    public void loadmau() {
        pref = Preferences.userNodeForPackage(this.getClass());
        prefReme = pref.getBoolean("Color", Boolean.valueOf(""));
        if (prefReme) {
            txtGV.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            txtImage.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            txtSpec.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            txtName.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            btnThem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add" + pref.get("btn", "") + ".png")));
            btnSua.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit" + pref.get("btn", "") + ".png")));
            btnXoa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete" + pref.get("btn", "") + ".png")));
            btnLammoi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh" + pref.get("btn", "") + ".png")));
            dgvGV.setSelectionBackground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
        }
    }

    public void loadKhoa() {
        loadkhoa lk = new loadkhoa();
        List<khoa> list = lk.getAllclasses();
        cbKhoa.removeAllItems();
        cbKhoa.addItem("--Chọn Khoa--");
        list.forEach(o -> {
            cbKhoa.addItem(o);
        });
    }

    public void loadanh() {
        int x = dgvGV.getSelectedRow();
        if (x >= 0) {
            try {
                conn = cn.getConnection();
                String magv = (dgvGV.getValueAt(x, 0) + "");
                String sql_image = "Select hoten,anh from giangvien where magv = '" + magv + "'";
                Statement st = conn.createStatement();
                ResultSet rsi = st.executeQuery(sql_image);
                if (rsi.next()) {
                    txtName.setText(rsi.getString("hoten").toUpperCase());
                    Blob blob = rsi.getBlob("anh");
                    if (blob != null) {
                        anhSV = blob.getBytes(1, (int) blob.length());
                        Image img = CircleImage.createImageFromByteArray(anhSV, "jpg");
                        txtImage.setIcon(new ImageIcon(img));
                    } else {
                        ImageIcon icon = new ImageIcon(getClass().getResource("/img/addPicture.png"));
                        txtImage.setIcon(icon);
                    }
                }
                conn.close();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public void loadbang() {
        String sql1 = "select * from giangvien";
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            tb.setRowCount(0);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {
                Object personObject[] = {
                    rs.getString("magv"),
                    rs.getString("hoten"),
                    sdf.format(rs.getDate("ngaysinh")),
                    rs.getString("gioitinh"),
                    rs.getString("sdt"),
                    rs.getString("email"),
                    rs.getString("diachi"),
                    rs.getString("khoa")
                };
                tb.addRow(personObject);
                dgvGV.setModel(tb);
                dgvGV.getColumnModel().getColumn(0).setPreferredWidth(50);
                dgvGV.getColumnModel().getColumn(1).setPreferredWidth(120);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtGV = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbKhoa = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgvGV = new javax.swing.JTable();
        txtSpec = new javax.swing.JSeparator();
        txtImage = new ConnectUI.CircleImage();
        txtName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 246, 253));
        setMinimumSize(new java.awt.Dimension(750, 580));
        setPreferredSize(new java.awt.Dimension(750, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtGV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtGV.setForeground(new java.awt.Color(0, 153, 255));
        txtGV.setText("QUẢN LÝ GIẢNG VIÊN");
        add(txtGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 29));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Chọn Khoa:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 80, 20));

        cbKhoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoaActionPerformed(evt);
            }
        });
        add(cbKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 240, 40));

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add1.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add2.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 105, 40));

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit1.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/penedit2.png"))); // NOI18N
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 105, 40));

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete1.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete2.png"))); // NOI18N
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 105, 40));

        btnLammoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh1.png"))); // NOI18N
        btnLammoi.setText("Làm Mới");
        btnLammoi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh2.png"))); // NOI18N
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });
        add(btnLammoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 130, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 270, 40));

        dgvGV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dgvGV.setModel(new javax.swing.table.DefaultTableModel(
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
        dgvGV.setRowHeight(25);
        dgvGV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvGVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dgvGV);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 740, 360));

        txtSpec.setForeground(new java.awt.Color(0, 153, 255));
        txtSpec.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(txtSpec, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 20, 100));

        txtImage.setForeground(new java.awt.Color(0, 153, 255));
        txtImage.setBorderSize(3);
        txtImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addPicture.png"))); // NOI18N
        txtImage.setMinimumSize(new java.awt.Dimension(100, 100));
        add(txtImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 100, 100));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 153, 255));
        txtName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 140, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void cbKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhoaActionPerformed
        if (cbKhoa.getSelectedIndex() == 0) {
            loadbang();
        } else {
            khoa k = (khoa) cbKhoa.getSelectedItem();
            khoa = k.getMakhoa();
            String sql1 = "select * from giangvien where khoa='" + khoa + "'";
            conn = cn.getConnection();
            PreparedStatement pst;
            try {
                pst = conn.prepareStatement(sql1);
                ResultSet rs = pst.executeQuery();
                tb.setRowCount(0);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                while (rs.next()) {
                    Object personObject[] = {
                        rs.getString("magv"),
                        rs.getString("hoten"),
                        sdf.format(rs.getDate("ngaysinh")),
                        rs.getString("gioitinh"),
                        rs.getString("sdt"),
                        rs.getString("email"),
                        rs.getString("diachi"),
                        rs.getString("khoa")
                    };
                    tb.addRow(personObject);
                    dgvGV.setModel(tb);
                    dgvGV.getColumnModel().getColumn(0).setPreferredWidth(50);
                    dgvGV.getColumnModel().getColumn(1).setPreferredWidth(120);
                }
                conn.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_cbKhoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (cbKhoa.getSelectedIndex() == 0 || cbKhoa.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn khoa!");
        } else {
            khoa k = (khoa)cbKhoa.getSelectedItem();
            khoa = k.getMakhoa();
            new ThemMoi(quyen, khoa).setVisible(true);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (dgvGV.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn giảng viên!");
        } else {
            String magv = dgvGV.getValueAt(dgvGV.getSelectedRow(), 0).toString();
            new SuaTT(quyen, magv).setVisible(true);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (dgvGV.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn giảng viên!");
        } else {
            try {
                conn = cn.getConnection();
                String sql = "Delete giangvien where magv=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, dgvGV.getValueAt(dgvGV.getSelectedRow(), 0) + "");
                int chk = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (chk == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                    pst.executeUpdate();
                    loadbang();
                }
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        btnThem.setEnabled(true);
        cbKhoa.setSelectedIndex(0);
        loadbang();
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (cbKhoa.getSelectedIndex() == 0 && txtSearch.getText().equals("")) {
            loadbang();
        } else {
            if (txtSearch.getText().equals("")) {
                loadbang();
            } else {
                try {
                    conn = cn.getConnection();
                    String search = txtSearch.getText().replaceAll("[-!']", "");
                    String sql = "SELECT * FROM giangvien where khoa = '" + khoa
                            + "' and magv like '%" + search + "%' or hoten like N'%" + search + "%'";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    tb.setRowCount(0);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    while (rs.next()) {
                        Object personObject[] = {
                            rs.getString("magv"),
                            rs.getString("hoten"),
                            sdf.format(rs.getDate("ngaysinh")),
                            rs.getString("gioitinh"),
                            rs.getString("sdt"),
                            rs.getString("email"),
                            rs.getString("diachi"),
                            rs.getString("khoa")
                        };
                        tb.addRow(personObject);
                        dgvGV.setModel(tb);
                        dgvGV.getColumnModel().getColumn(0).setPreferredWidth(50);
                        dgvGV.getColumnModel().getColumn(1).setPreferredWidth(120);
                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void dgvGVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvGVMouseClicked
        loadanh();
    }//GEN-LAST:event_dgvGVMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<Object> cbKhoa;
    private javax.swing.JTable dgvGV;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel txtGV;
    private ConnectUI.CircleImage txtImage;
    private javax.swing.JLabel txtName;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JSeparator txtSpec;
    // End of variables declaration//GEN-END:variables
}
