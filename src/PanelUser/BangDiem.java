package PanelUser;

import ConnectUI.ConnectDB;
import Transitions.TransitionsForm;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Desktop;
import java.io.*;
import java.util.Hashtable;
import javax.swing.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class BangDiem extends TransitionsForm {

    ConnectDB cn = new ConnectDB();
    Connection conn;
    final String header[] = {"Mã SV", "Mã Lớp", "Mã HP", "Tên HP", "Số Tín", "Học Kỳ", "Chuyên Cần", "Giữa Kỳ", "Cuối Kỳ", "Tổng Kết", "Đánh Giá", "Điểm Chữ"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);
    String username;
    ResultSet rs;

    public BangDiem() {
        initComponents();
    }

    public BangDiem(String user) {
        this.username = user;
        initComponents();
        cbHocKy.setVisible(false);
        txtLocTheo.setVisible(false);
        excel.setVisible(false);
        print.setVisible(false);
        AutoCompleteDecorator.decorate(cbHocKy);
        AutoCompleteDecorator.decorate(cbDTK);
        loadky();
    }

    public void loadbang() {
        String sql1 = "SELECT n.masv,n.malop,n.mamh,x.tenmh,x.sotin,n.hocky,n.chuyencan,n.giuaky,n.cuoiky,n.tongket,n.danhgia,n.diemchu "
                + " FROM dbo.ketqua n JOIN dbo.monhoc x ON n.mamh = x.mamh WHERE n.masv = ?";
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            int sodong;
            Vector row;
            pst = conn.prepareStatement(sql1);
            pst.setString(1, username);
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
                dgvSinhvien.getColumnModel().getColumn(2).setPreferredWidth(50);
                dgvSinhvien.getColumnModel().getColumn(3).setPreferredWidth(230);
                dgvSinhvien.getColumnModel().getColumn(4).setPreferredWidth(30);
                dgvSinhvien.getColumnModel().getColumn(5).setMinWidth(0);
                dgvSinhvien.getColumnModel().getColumn(5).setMaxWidth(0);
                dgvSinhvien.getColumnModel().getColumn(1).setMinWidth(0);
                dgvSinhvien.getColumnModel().getColumn(1).setMaxWidth(0);
                dgvSinhvien.getColumnModel().getColumn(0).setMinWidth(0);
                dgvSinhvien.getColumnModel().getColumn(0).setMaxWidth(0);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void loadCbb() {
        conn = cn.getConnection();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("select distinct hocky from ketqua where masv='" + username + "'");
            rs = pst.executeQuery();
            cbHocKy.removeAllItems();
            cbHocKy.addItem("--Chọn học kỳ--");
            while (rs.next()) {
                cbHocKy.addItem(rs.getString("hocky"));
            }
        } catch (SQLException e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtLocTheo = new javax.swing.JLabel();
        cbHocKy = new javax.swing.JComboBox<>();
        panel1 = new javax.swing.JScrollPane();
        dgvSinhvien = new javax.swing.JTable();
        cbDTK = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        print = new javax.swing.JButton();
        excel = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(985, 556));
        setPreferredSize(new java.awt.Dimension(985, 556));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bảng Điểm");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 11, 254, 50));

        txtLocTheo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtLocTheo.setText("LỌC THEO:");
        add(txtLocTheo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 90, 40));

        cbHocKy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbHocKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHocKyActionPerformed(evt);
            }
        });
        add(cbHocKy, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 210, 40));

        dgvSinhvien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dgvSinhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Mã Lớp", "Mã môn học", "Tên môn học", "Số Tín", "Học Kỳ", "Chuyên Cần", "Giữa kỳ", "Cuối kỳ", "Tổng Kết", "Điểm Chữ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dgvSinhvien.setMinimumSize(new java.awt.Dimension(985, 100));
        dgvSinhvien.setPreferredSize(new java.awt.Dimension(985, 2100));
        dgvSinhvien.setRowHeight(25);
        dgvSinhvien.getTableHeader().setReorderingAllowed(false);
        panel1.setViewportView(dgvSinhvien);

        add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 130, 975, 420));

        cbDTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbDTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Điểm Tổng Kết", "Bảng Điểm Chi Tiết" }));
        cbDTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDTKActionPerformed(evt);
            }
        });
        add(cbDTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 210, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("XEM:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 40));

        print.setBackground(new Color(0,0,0,0));
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_32px.png"))); // NOI18N
        print.setBorder(null);
        print.setOpaque(false);
        print.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_32px_2.png"))); // NOI18N
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        add(print, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 70, 40, 40));

        excel.setBackground(new Color(0,0,0,0));
        excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_microsoft_excel_32px_1.png"))); // NOI18N
        excel.setBorder(null);
        excel.setOpaque(false);
        excel.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_microsoft_excel_32px_2.png"))); // NOI18N
        excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelActionPerformed(evt);
            }
        });
        add(excel, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 70, 40, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void cbHocKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHocKyActionPerformed
        if (cbHocKy.getSelectedIndex() == 0) {
            loadbang();
        } else {
            conn = cn.getConnection();
            PreparedStatement pst;
            try {
                int sodong;
                Vector row;
                String sql = "SELECT n.masv,n.malop,n.mamh,x.tenmh,x.sotin,n.hocky,n.chuyencan,n.giuaky,n.cuoiky,n.tongket,n.danhgia,n.diemchu "
                        + " FROM dbo.ketqua n JOIN dbo.monhoc x ON n.mamh = x.mamh WHERE n.masv = ? and n.hocky=?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, username);
                pst.setString(2, cbHocKy.getSelectedItem().toString());
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
                    dgvSinhvien.getColumnModel().getColumn(2).setPreferredWidth(40);
                    dgvSinhvien.getColumnModel().getColumn(3).setPreferredWidth(230);
                    dgvSinhvien.getColumnModel().getColumn(4).setPreferredWidth(30);
                    dgvSinhvien.getColumnModel().getColumn(5).setMinWidth(0);
                    dgvSinhvien.getColumnModel().getColumn(5).setMaxWidth(0);
                    dgvSinhvien.getColumnModel().getColumn(1).setMinWidth(0);
                    dgvSinhvien.getColumnModel().getColumn(1).setMaxWidth(0);
                    dgvSinhvien.getColumnModel().getColumn(0).setMinWidth(0);
                    dgvSinhvien.getColumnModel().getColumn(0).setMaxWidth(0);
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_cbHocKyActionPerformed

    public void loadky() {
        final String header[] = {"Mã SV", "Năm Học", "Học Kỳ", "Điểm TB hệ 10", "Điểm TB hệ 4", "Số Tín"};
        final DefaultTableModel tb = new DefaultTableModel(header, 0);
        dgvSinhvien.setModel(tb);
    }

    private void cbDTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDTKActionPerformed
        if (cbDTK.getSelectedIndex() == 0) {
            loadky();
            excel.setVisible(false);
            print.setVisible(false);
            txtLocTheo.setVisible(false);
            cbHocKy.setVisible(false);
        } else {
            loadCbb();
            loadbang();
            excel.setVisible(true);
            print.setVisible(true);
            txtLocTheo.setVisible(true);
            cbHocKy.setVisible(true);
        }
    }//GEN-LAST:event_cbDTKActionPerformed

    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private void excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelActionPerformed
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();

            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("customer");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < dgvSinhvien.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(dgvSinhvien.getColumnName(i));
                }

                for (int j = 0; j < dgvSinhvien.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < dgvSinhvien.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (dgvSinhvien.getValueAt(j, k) != null) {
                            cell.setCellValue(dgvSinhvien.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Hủy xuất file!");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException io) {
            System.out.println(io);
        }
    }//GEN-LAST:event_excelActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        String hocky = "";
        if (cbHocKy.getSelectedIndex() == 0) {
            hocky = "";
        } else {
            hocky = cbHocKy.getSelectedItem().toString();
        }
        conn = cn.getConnection();
        String link = "src/report/rptBangDiemSV.jrxml";
        Hashtable map = new Hashtable();
        try {
            JasperReport report = JasperCompileManager.compileReport(link);

            map.put("masv", username.toString());

            map.put("hocky", hocky);

            JasperPrint print = JasperFillManager.fillReport(report, map, conn);

            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_printActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbDTK;
    private javax.swing.JComboBox<String> cbHocKy;
    private javax.swing.JTable dgvSinhvien;
    private javax.swing.JButton excel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane panel1;
    private javax.swing.JButton print;
    private javax.swing.JLabel txtLocTheo;
    // End of variables declaration//GEN-END:variables
}
