package Main;

import Login.Login;
import PanelAdmin.*;
import dashboardUI.event.EventMenu;
import java.awt.*;
import javax.swing.JOptionPane;

public class DashboardAdmin extends javax.swing.JFrame {
    
    int xMouse,yMouse;
    
    public DashboardAdmin() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        showForm(new Home());
    }

    private void showForm(Component com) {
        panelMain.removeAll();
        panelMain.add(com);
        panelMain.repaint();
        panelMain.revalidate();
    }

    public void hideForm() {
        this.setVisible(false);
        new Login().setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClose = new javax.swing.JButton();
        panelBorder1 = new dashboardUI.swing.PanelBorder();
        sidebar1 = new PanelAdmin.Sidebar();
        panelMain = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnClose.setBackground(new Color(0.0f,0.0f,0.0f,0.0f));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close copy.png"))); // NOI18N
        btnClose.setBorder(null);
        btnClose.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close1.png"))); // NOI18N
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(996, -4, 32, 32));

        panelBorder1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelBorder1MouseDragged(evt);
            }
        });
        panelBorder1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelBorder1MousePressed(evt);
            }
        });

        panelMain.setPreferredSize(new java.awt.Dimension(780, 0));
        panelMain.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(sidebar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sidebar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panelBorder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.2) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
        sidebar1.setSelectedIndex(0);
        sidebar1.addEvent(new EventMenu() {
            @Override
            public void menuIndexChange(int index) {
                if (index == 0) {
                    showForm(new Home());
                } else if (index == 1) {
                    showForm(new QLMonTC());
                } else if (index == 2) {
                    showForm(new QLKhoiTC());
                } else if (index == 3) {
                    showForm(new QLSinhVien());
                } else if (index == 4) {
                    showForm(new QLGiangVien());
                } else if (index == 5) {
                    showForm(new PCGiangDay());
                } else if (index == 6) {
                    showForm(new QLDiem());
                } else if (index == 7) {
                    int chk = JOptionPane.showConfirmDialog(rootPane, "Bạn muốn đăng xuất?", "Thông báo", JOptionPane.YES_NO_OPTION);
                    if (chk == JOptionPane.YES_OPTION) {
                        hideForm();
                    }
                }
            }
        });
    }//GEN-LAST:event_formWindowOpened

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void panelBorder1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBorder1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelBorder1MousePressed

    private void panelBorder1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBorder1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panelBorder1MouseDragged

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private dashboardUI.swing.PanelBorder panelBorder1;
    private javax.swing.JLayeredPane panelMain;
    private PanelAdmin.Sidebar sidebar1;
    // End of variables declaration//GEN-END:variables
}
