package PanelUser;

import ConnectUI.ConnectDB;
import Transitions.TransitionsForm;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class LichGiangDay extends TransitionsForm {

    ConnectDB cn = new ConnectDB();
    Connection conn;
    final String header[] = {"STT", "Mã GV", "Mã Lớp", "Mã Môn", "Tên Môn", "Học Kỳ"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);
    String username;
    ResultSet rs;

    public LichGiangDay(String user) {
        this.username = user;
        initComponents();
        loadbang();
        AutoCompleteDecorator.decorate(cbLop);
        loadmalop();
    }

    public void loadmalop() {
        conn = cn.getConnection();
        String sql = "select distinct malop from pcgiangday where magv='" + username + "'";
        try {
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

    public LichGiangDay() {
        initComponents();
    }

    public void loadbang() {
        String sql1 = "SELECT ROW_NUMBER() OVER (ORDER BY x.magv) as 'STT',x.magv,x.malop,x.mamh,y.tenmh,x.hocky"
                + " FROM dbo.pcgiangday x JOIN dbo.monhoc y ON x.mamh = y.mamh WHERE x.magv =? and matt='DGD'";
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql1);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            tb.setRowCount(0);
            while (rs.next()) {
                Object personObject[] = {
                    rs.getString("STT"),
                    rs.getString("magv"),
                    rs.getString("malop"),
                    rs.getString("mamh"),
                    rs.getString("tenmh"),
                    rs.getString("hocky")
                };
                tb.addRow(personObject);
                dgvLich.setModel(tb);
                dgvLich.getColumnModel().getColumn(2).setPreferredWidth(40);
                dgvLich.getColumnModel().getColumn(4).setPreferredWidth(230);
                dgvLich.getColumnModel().getColumn(3).setPreferredWidth(30);
                dgvLich.getColumnModel().getColumn(0).setPreferredWidth(20);
                dgvLich.getColumnModel().getColumn(1).setMinWidth(0);
                dgvLich.getColumnModel().getColumn(1).setMaxWidth(0);
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
        dgvLich = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        cbLop = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(1005, 556));
        setPreferredSize(new java.awt.Dimension(1005, 556));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lịch Giảng Dạy");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 320, 50));

        dgvLich.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dgvLich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        dgvLich.setPreferredSize(new java.awt.Dimension(995, 100));
        dgvLich.setRowHeight(25);
        jScrollPane1.setViewportView(dgvLich);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 142, 975, 410));

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 84, 300, 40));

        cbLop.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLopActionPerformed(evt);
            }
        });
        add(cbLop, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 84, 240, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Lọc theo tên môn:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 96, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Lọc theo lớp:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 96, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        if (txtSearch.getText().equals("")) {
            loadbang();
        } else {
            String sql1 = "SELECT ROW_NUMBER() OVER (ORDER BY x.magv) as 'STT',x.magv,x.malop,x.mamh,y.tenmh,x.hocky"
                    + " FROM dbo.pcgiangday x JOIN dbo.monhoc y ON x.mamh = y.mamh WHERE x.magv =? AND matt='DGD' and y.tenmh like N'%" + txtSearch.getText() + "%'";
            conn = cn.getConnection();
            PreparedStatement pst;
            try {
                pst = conn.prepareStatement(sql1);
                pst.setString(1, username);
                ResultSet rs = pst.executeQuery();
                tb.setRowCount(0);
                while (rs.next()) {
                    Object personObject[] = {
                        rs.getString("STT"),
                        rs.getString("magv"),
                        rs.getString("malop"),
                        rs.getString("mamh"),
                        rs.getString("tenmh"),
                        rs.getString("hocky")
                    };
                    tb.addRow(personObject);
                    dgvLich.setModel(tb);
                    dgvLich.getColumnModel().getColumn(2).setPreferredWidth(40);
                    dgvLich.getColumnModel().getColumn(4).setPreferredWidth(230);
                    dgvLich.getColumnModel().getColumn(3).setPreferredWidth(30);
                    dgvLich.getColumnModel().getColumn(0).setPreferredWidth(20);
                    dgvLich.getColumnModel().getColumn(1).setMinWidth(0);
                    dgvLich.getColumnModel().getColumn(1).setMaxWidth(0);
                }
                conn.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cbLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLopActionPerformed
        if (cbLop.getSelectedIndex() == 0 || cbLop.getSelectedIndex() == -1) {
            loadbang();
        } else {
            String sql1 = "SELECT ROW_NUMBER() OVER (ORDER BY x.magv) as 'STT',x.magv,x.malop,x.mamh,y.tenmh,x.hocky"
                    + " FROM dbo.pcgiangday x JOIN dbo.monhoc y ON x.mamh = y.mamh WHERE x.magv =? and x.malop=? and matt='DGD'";
            conn = cn.getConnection();
            PreparedStatement pst;
            try {
                pst = conn.prepareStatement(sql1);
                pst.setString(1, username);
                pst.setString(2, cbLop.getSelectedItem().toString());
                ResultSet rs = pst.executeQuery();
                tb.setRowCount(0);
                while (rs.next()) {
                    Object personObject[] = {
                        rs.getString("STT"),
                        rs.getString("magv"),
                        rs.getString("malop"),
                        rs.getString("mamh"),
                        rs.getString("tenmh"),
                        rs.getString("hocky")
                    };
                    tb.addRow(personObject);
                    dgvLich.setModel(tb);
                    dgvLich.getColumnModel().getColumn(2).setPreferredWidth(40);
                    dgvLich.getColumnModel().getColumn(4).setPreferredWidth(230);
                    dgvLich.getColumnModel().getColumn(3).setPreferredWidth(30);
                    dgvLich.getColumnModel().getColumn(0).setPreferredWidth(20);
                    dgvLich.getColumnModel().getColumn(1).setMinWidth(0);
                    dgvLich.getColumnModel().getColumn(1).setMaxWidth(0);
                }
                conn.close();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }//GEN-LAST:event_cbLopActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbLop;
    private javax.swing.JTable dgvLich;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
