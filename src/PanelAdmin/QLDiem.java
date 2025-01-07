package PanelAdmin;

import ConnectUI.*;
import combobox.khoa;
import combobox.loadkhoa;
import java.awt.Color;
import java.awt.Image;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.prefs.Preferences;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class QLDiem extends javax.swing.JPanel {

    ConnectDB cn = new ConnectDB();
    String quyen = "SV";
    Connection conn;
    final String header[] = {"Mã SV", "Họ Tên", "Ngày Sinh", "Giới Tính", "Mã Lớp"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);
    ResultSet rs;
    byte[] anhSV;
    String makhoa;

    public QLDiem() {
        initComponents();
        cbLop.setEnabled(false);
        loadkhoa();
        loadbang();
        AutoCompleteDecorator.decorate(cbKhoa);
        AutoCompleteDecorator.decorate(cbLop);
        loadmau();
    }
    
    Preferences pref;
    boolean prefReme;
    
    public void loadmau(){
        pref = Preferences.userNodeForPackage(this.getClass());
        prefReme = pref.getBoolean("Color", Boolean.valueOf(""));
        if (prefReme) {
            txtQLD.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            txtName.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            txtImage.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            txtSperator.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            btnThem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add" + pref.get("btn", "")+".png")));
            btnGui.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sent" + pref.get("btn", "")+".png")));
            btnLammoi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh" + pref.get("btn", "")+".png")));
            dgvSV.setSelectionBackground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
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

    public void loadanh() {
        int x = dgvSV.getSelectedRow();
        if (x >= 0) {
            try {
                conn = cn.getConnection();
                String msv = (dgvSV.getValueAt(x, 0) + "");
                String sql_image = "Select hoten,anh from sinhvien where masv = '" + msv + "'";
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
        String sql1 = "select masv,hoten,ngaysinh,gioitinh,malop from sinhvien";
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql1);
            ResultSet rs = pst.executeQuery();
            tb.setRowCount(0);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while (rs.next()) {
                Object personObject[] = {
                    rs.getString("masv"),
                    rs.getString("hoten"),
                    sdf.format(rs.getDate("ngaysinh")),
                    rs.getString("gioitinh"),
                    rs.getString("malop")
                };
                tb.addRow(personObject);
                dgvSV.setModel(tb);
                dgvSV.getColumnModel().getColumn(0).setPreferredWidth(50);
                dgvSV.getColumnModel().getColumn(1).setPreferredWidth(120);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtQLD = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        dgvSV = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnGui = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        cbLop = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbKhoa = new javax.swing.JComboBox<>();
        txtSperator = new javax.swing.JSeparator();
        txtName = new javax.swing.JLabel();
        txtImage = new ConnectUI.CircleImage();

        setBackground(new java.awt.Color(242, 246, 253));
        setMinimumSize(new java.awt.Dimension(760, 580));
        setPreferredSize(new java.awt.Dimension(760, 580));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtQLD.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtQLD.setForeground(new java.awt.Color(0, 153, 255));
        txtQLD.setText("QUẢN LÝ ĐIỂM");
        add(txtQLD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 29));

        dgvSV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dgvSV.setModel(new javax.swing.table.DefaultTableModel(
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
        dgvSV.setRowHeight(25);
        dgvSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dgvSVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dgvSV);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 740, 360));

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add1.png"))); // NOI18N
        btnThem.setText("Nhập điểm");
        btnThem.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add2.png"))); // NOI18N
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 140, 40));

        btnGui.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sent1.png"))); // NOI18N
        btnGui.setText("Gửi điểm");
        btnGui.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sent2.png"))); // NOI18N
        btnGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiActionPerformed(evt);
            }
        });
        add(btnGui, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 130, 40));

        btnLammoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh1.png"))); // NOI18N
        btnLammoi.setText("Làm Mới");
        btnLammoi.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh2.png"))); // NOI18N
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });
        add(btnLammoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 130, 40));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 310, 40));

        cbLop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLopActionPerformed(evt);
            }
        });
        add(cbLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 240, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Chọn Lớp:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Chọn Khoa:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 20));

        cbKhoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbKhoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoaActionPerformed(evt);
            }
        });
        add(cbKhoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 240, 40));

        txtSperator.setForeground(new java.awt.Color(0, 153, 255));
        txtSperator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(txtSperator, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 20, 110));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 153, 255));
        txtName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 140, 30));

        txtImage.setForeground(new java.awt.Color(0, 153, 255));
        txtImage.setBorderSize(3);
        txtImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addPicture.png"))); // NOI18N
        txtImage.setMinimumSize(new java.awt.Dimension(100, 100));
        add(txtImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 100, 100));
    }// </editor-fold>//GEN-END:initComponents

    private void dgvSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dgvSVMouseClicked
        loadanh();
    }//GEN-LAST:event_dgvSVMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (cbKhoa.getSelectedIndex() == 0 || cbKhoa.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn khoa!");
        } else if (dgvSV.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sinh viên!");
        } else {
            String masv = dgvSV.getValueAt(dgvSV.getSelectedRow(), 0).toString();
            String malop = dgvSV.getValueAt(dgvSV.getSelectedRow(), 4).toString();
            String mamh = "";
            String tenmh = "";
            String magv = "";
            int sotc = 0;
            new VaoDiem(masv, malop, makhoa, mamh, tenmh, sotc, magv).setVisible(true);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnGuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiActionPerformed
        if (dgvSV.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sinh viên!");
        } else {
            String masv = dgvSV.getValueAt(dgvSV.getSelectedRow(), 0).toString();
            new SendPoint(masv).setVisible(true);
        }
    }//GEN-LAST:event_btnGuiActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        btnThem.setEnabled(true);
        loadbang();
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (txtSearch.getText().equals(""))
            loadbang();
        else {
            try {
                conn = cn.getConnection();
                String search = txtSearch.getText().replaceAll("[-!']", "");
                String sql = "SELECT masv,hoten,ngaysinh,gioitinh,malop FROM sinhvien where masv like N'%" + search + "%' or hoten like N'%" + search + "%'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                tb.setRowCount(0);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                while (rs.next()) {
                    Object personObject[] = {
                        rs.getString("masv"),
                        rs.getString("hoten"),
                        sdf.format(rs.getDate("ngaysinh")),
                        rs.getString("gioitinh"),
                        rs.getString("malop")
                    };
                    tb.addRow(personObject);
                    dgvSV.setModel(tb);
                    dgvSV.getColumnModel().getColumn(0).setPreferredWidth(50);
                    dgvSV.getColumnModel().getColumn(1).setPreferredWidth(120);
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cbLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLopActionPerformed
        if (cbLop.getSelectedIndex() == 0 || cbLop.getSelectedIndex() == -1) {
            loadbang();
        } else {
            String sql1 = "select * from sinhvien where malop='" + cbLop.getSelectedItem() + "'";
            conn = cn.getConnection();
            PreparedStatement pst;
            try {
                pst = conn.prepareStatement(sql1);
                ResultSet rs = pst.executeQuery();
                tb.setRowCount(0);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                while (rs.next()) {
                    Object personObject[] = {
                        rs.getString("masv"),
                        rs.getString("hoten"),
                        sdf.format(rs.getDate("ngaysinh")),
                        rs.getString("gioitinh"),
                        rs.getString("malop")
                    };
                    tb.addRow(personObject);
                    dgvSV.setModel(tb);
                    dgvSV.getColumnModel().getColumn(0).setPreferredWidth(50);
                    dgvSV.getColumnModel().getColumn(1).setPreferredWidth(120);
                }
            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_cbLopActionPerformed

    private void cbKhoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhoaActionPerformed
        if (cbKhoa.getSelectedIndex() == 0 || cbKhoa.getSelectedIndex() == -1) {
            cbLop.setEnabled(false);
            makhoa = "";
        } else {
            cbLop.setEnabled(true);
            conn = cn.getConnection();
            khoa k = (khoa) cbKhoa.getSelectedItem();
            makhoa = k.getMakhoa();
            PreparedStatement pst;
            try {
                pst = conn.prepareStatement("select * from lop where makhoa='" + makhoa + "'");
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
    }//GEN-LAST:event_cbKhoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGui;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<Object> cbKhoa;
    private javax.swing.JComboBox<String> cbLop;
    private javax.swing.JTable dgvSV;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private ConnectUI.CircleImage txtImage;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtQLD;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JSeparator txtSperator;
    // End of variables declaration//GEN-END:variables
}
