package PanelUser;

import ConnectUI.ConnectDB;
import Transitions.TransitionsForm;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class LichHoc extends TransitionsForm {

    ConnectDB cn = new ConnectDB();
    Connection conn;
    final String header[] = {"STT", "Mã HP", "Tên HP", "Số TC", "Học Kỳ", "Giảng Viên"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);
    String username, malop;
    ResultSet rs;

    public LichHoc() {
        initComponents();
    }

    public LichHoc(String user) {
        this.username = user;
        initComponents();
        String sql_lop = "select malop from sinhvien where masv='"+username+"'";
        try {
            conn = cn.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql_lop);
            if(rs.next()){
                malop = rs.getString("malop");
            }
        } catch (Exception e) {
        }
        loadbang();
    }

    public void loadbang() {
        String sql1 = "SELECT ROW_NUMBER() OVER (ORDER BY x.magv) as 'STT',x.mamh,y.tenmh, y.sotin,x.hocky, z.hoten \n"
                + "FROM dbo.pcgiangday x JOIN dbo.monhoc y ON x.mamh = y.mamh \n"
                + "JOIN dbo.giangvien z ON z.magv = x.magv \n"
                + "WHERE x.malop = ? AND matt = 'DGD'";
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(sql1);
            pst.setString(1, malop);
            ResultSet rs = pst.executeQuery();
            tb.setRowCount(0);
            while (rs.next()) {
                Object personObject[] = {
                    rs.getString("STT"),
                    rs.getString("mamh"),
                    rs.getString("tenmh"),
                    rs.getString("sotin"),
                    rs.getString("hocky"),
                    rs.getString("hoten")
                };
                tb.addRow(personObject);
                dgvLich.setModel(tb);
                dgvLich.getColumnModel().getColumn(0).setPreferredWidth(10);
                dgvLich.getColumnModel().getColumn(1).setPreferredWidth(40);
                dgvLich.getColumnModel().getColumn(2).setPreferredWidth(400);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        dgvLich = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(985, 556));
        setPreferredSize(new java.awt.Dimension(985, 556));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 100, 975, 40));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 152, 975, 400));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tìm Kiếm gì đó:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lịch Học");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 320, 50));
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable dgvLich;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
