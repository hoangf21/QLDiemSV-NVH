package PanelAdmin;

import java.util.prefs.Preferences;


public class Profile extends javax.swing.JPanel {


    public Profile() {
        initComponents();
        loadmau();
    }

    Preferences pref;
    boolean prefReme;
    
    public void loadmau(){
        pref = Preferences.userNodeForPackage(this.getClass());
        prefReme = pref.getBoolean("Color", Boolean.valueOf(""));
        if (prefReme) {
            txtADMIN.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
            txtQLHT.setForeground(new java.awt.Color(Integer.parseInt(pref.get("r", "")), Integer.parseInt(pref.get("g", "")), Integer.parseInt(pref.get("b", ""))));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        circleImage1 = new ConnectUI.CircleImage();
        txtADMIN = new javax.swing.JLabel();
        txtQLHT = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        circleImage1.setBackground(new java.awt.Color(51, 153, 255));
        circleImage1.setForeground(new java.awt.Color(255, 255, 255));
        circleImage1.setBorderSize(5);
        circleImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log_1.png"))); // NOI18N
        add(circleImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 60, 60));

        txtADMIN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtADMIN.setForeground(new java.awt.Color(116, 185, 255));
        txtADMIN.setText("ADMIN");
        add(txtADMIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 18, 91, 28));

        txtQLHT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQLHT.setForeground(new java.awt.Color(116, 188, 255));
        txtQLHT.setText("Quản Trị Hệ Thống");
        add(txtQLHT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 151, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ConnectUI.CircleImage circleImage1;
    private javax.swing.JLabel txtADMIN;
    private javax.swing.JLabel txtQLHT;
    // End of variables declaration//GEN-END:variables
}
